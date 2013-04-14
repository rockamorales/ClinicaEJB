/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.facades.colecturia;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import sv.com.cormaria.servicios.entidades.archivo.EstadoServiciosEnfermeria;
import sv.com.cormaria.servicios.entidades.archivo.TblServiciosEnfermeria;
import sv.com.cormaria.servicios.entidades.archivo.TblTarjetaControlCitas;
import sv.com.cormaria.servicios.entidades.catalogos.CatCategoriaProducto;
import sv.com.cormaria.servicios.entidades.colecturia.CorteDiario;
import sv.com.cormaria.servicios.entidades.colecturia.TblComprobanteDonacion;
import sv.com.cormaria.servicios.entidades.colecturia.TblDetalleComprobanteDonacion;
import sv.com.cormaria.servicios.entidades.consultasmedicas.TblConsultas;
import sv.com.cormaria.servicios.entidades.consultasmedicas.TblDetalleReceta;
import sv.com.cormaria.servicios.entidades.consultasmedicas.TblDetalleRecetaPK;
import sv.com.cormaria.servicios.entidades.consultasmedicas.TblRecetaMedica;
import sv.com.cormaria.servicios.entidades.security.TblUsuarios;
import sv.com.cormaria.servicios.enums.EstadoComprobanteDonacion;
import sv.com.cormaria.servicios.enums.EstadoConsultas;
import sv.com.cormaria.servicios.enums.EstadoRecetaMedica;
import sv.com.cormaria.servicios.enums.EstadoTarjeta;
import sv.com.cormaria.servicios.enums.OrigenDonacionEnum;
import sv.com.cormaria.servicios.exceptions.ClinicaModelValidationException;
import sv.com.cormaria.servicios.exceptions.ClinicaModelexception;
import sv.com.cormaria.servicios.facades.archivo.TblTarjetaControlCitasFacadeLocal;
import sv.com.cormaria.servicios.facades.common.AbstractFacade;
import sv.com.cormaria.servicios.facades.security.TblUsuariosSessionFacadeLocal;

/**
 *
 * @author Mackk
 */
@Stateless
public class TblComprobanteDonacionFacade extends AbstractFacade<TblComprobanteDonacion> implements TblComprobanteDonacionFacadeLocal {
    @PersistenceContext(unitName = "ClinicaEJBPU")
    private EntityManager em;
    @EJB
    TblUsuariosSessionFacadeLocal usuarioFacade;
    @EJB
    TblDetalleComprobanteDonacionFacadeLocal detalleFacade;
    @EJB
    TblTarjetaControlCitasFacadeLocal tarjetaFacade;
    @Resource
    SessionContext sessionContext;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TblComprobanteDonacionFacade() {
        super(TblComprobanteDonacion.class);
    }

    @Override
    public List<TblComprobanteDonacion> findAll() throws ClinicaModelexception {
         try{
            Query q = em.createNamedQuery("TblComprobanteDonacion.findAll");
            return q.getResultList();
        }catch(Exception ex){
            throw new ClinicaModelexception(ex.getMessage(), ex);
        }
    }

    @Override
    public List<TblComprobanteDonacion> findRange(int[] range) throws ClinicaModelexception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int count() throws ClinicaModelexception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public TblComprobanteDonacion create(TblComprobanteDonacion entity) throws ClinicaModelexception{
        try{
            System.out.println("Codigo: "+sessionContext.getCallerPrincipal().getName());
            TblUsuarios usuario = usuarioFacade.findByCodigoUsuario(sessionContext.getCallerPrincipal().getName());
            System.out.println("Usuario: "+ usuario);
            entity.setOriDonacion(OrigenDonacionEnum.OTROS);
            entity.setNumEmpleado(usuario.getNumEmpleado());
            getEntityManager().persist(entity);
            return entity;
        }catch(Exception ex){
            throw new ClinicaModelexception(ex.getMessage(), ex);
        }
    }
    
    public void recibirPago(TblComprobanteDonacion comprobante) throws ClinicaModelexception{
        try{
            this.edit(comprobante);
            List<TblDetalleComprobanteDonacion> detalleList = detalleFacade.findByComprobanteDonacion(comprobante.getNumComDonacion());
            for (TblDetalleComprobanteDonacion detalle : detalleList) {
                    System.out.println("Codtipproducto: "+detalle.getTblProducto().getCodTipProducto());
                if (detalle.getTblProducto().getCodTipProducto().equals(CatCategoriaProducto.TARJETA_CONTROL)){
                    List<TblTarjetaControlCitas> tarjetasList = tarjetaFacade.findNoPagadoByNumExpediente(comprobante.getNumExpediente());
                    if (tarjetasList.isEmpty()){
                        throw new ClinicaModelValidationException("No existe registros de tarjetas pendientes de pago en el expediente");
                    }
                    System.out.println("Cambiando el estado de la TARJETA");
                    TblTarjetaControlCitas tarjeta = tarjetasList.get(0);
                    tarjeta.setEstTarjeta(EstadoTarjeta.PAGADO);
                    em.merge(tarjeta);
                }
                if (detalle.getNumConsulta()!=null){
                    System.out.println("Cambiando el estado de la consulta");
                    TblConsultas consulta = em.find(TblConsultas.class, detalle.getNumConsulta());
                    consulta.setEstConsulta(EstadoConsultas.PAGADA);
                }
                
                if (detalle.getNumSerEnfermeria()!=null){
                    TblServiciosEnfermeria serviciosEnfermeria = em.find(TblServiciosEnfermeria.class, detalle.getNumSerEnfermeria());
                    serviciosEnfermeria.setEstSerEnfermeria(EstadoServiciosEnfermeria.PAGADO);
                }
                if (detalle.getNumReceta()!=null){
                    TblRecetaMedica receta = em.find(TblRecetaMedica.class, detalle.getNumReceta());
                    receta.setEstReceta(EstadoRecetaMedica.PAGADA);
                    TblDetalleRecetaPK PK = new TblDetalleRecetaPK();
                    PK.setNumProducto(detalle.getTblProducto().getNumProducto());
                    TblDetalleReceta detalleReceta = em.find(TblDetalleReceta.class, PK);
                    detalleReceta.setEstDetReceta(EstadoRecetaMedica.PAGADA);
                    //em.remove(detalleReceta);
                }
            }
        }catch(Exception ex){
            ex.printStackTrace();
            throw new ClinicaModelexception(ex.getMessage(), ex);
        }
    }
    
    @Override
    public List<CorteDiario> calcularCorteDiario(Date fecCorte) throws ClinicaModelexception{
        try{
            Query q = em.createNamedQuery("CorteDiario.findByDate");
            q.setParameter("fecComDonacion",fecCorte, TemporalType.DATE);
            return q.getResultList();
        }catch(Exception ex){
            ex.printStackTrace();
            throw new ClinicaModelexception(ex.getMessage(), ex);
        }
    }

    @Override
    public List<CorteDiario> calcularCorteDiario1(Date fecCorte) throws ClinicaModelexception{
        try{
            Query q = em.createNamedQuery("CorteDiario.findByDateGroupByCodTipPagoAndCodBanco");
            q.setParameter("fecComDonacion",fecCorte, TemporalType.DATE);
            return q.getResultList();
        }catch(Exception ex){
            ex.printStackTrace();
            throw new ClinicaModelexception(ex.getMessage(), ex);
        }
    }
    
    @Override
    public void anularComprobante(Integer numComprobante) throws ClinicaModelexception{
        try{
            TblComprobanteDonacion donacion = this.find(numComprobante);
            donacion.setEstComDonacion(EstadoComprobanteDonacion.ANULADO);
        }catch(Exception ex){
            ex.printStackTrace();
            throw new ClinicaModelexception(ex.getMessage(), ex);
        }
    }
    
    public void remove(TblComprobanteDonacion entity) throws ClinicaModelexception {
        try{
            TblComprobanteDonacion comprobante = em.find(TblComprobanteDonacion.class, entity.getNumComDonacion());
            comprobante.setEstComDonacion(EstadoComprobanteDonacion.ELIMINADO);
        }catch(Exception ex){
            throw new ClinicaModelexception(ex.getMessage(), ex);
        }        
    }    
}