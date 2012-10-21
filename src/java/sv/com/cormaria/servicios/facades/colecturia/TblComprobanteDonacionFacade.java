/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.facades.colecturia;

import java.util.List;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import sv.com.cormaria.servicios.entidades.archivo.EstadoServiciosEnfermeria;
import sv.com.cormaria.servicios.entidades.archivo.TblServiciosEnfermeria;
import sv.com.cormaria.servicios.entidades.archivo.TblTarjetaControlCitas;
import sv.com.cormaria.servicios.entidades.catalogos.CatCategoriaProducto;
import sv.com.cormaria.servicios.entidades.colecturia.TblComprobanteDonacion;
import sv.com.cormaria.servicios.entidades.colecturia.TblDetalleComprobanteDonacion;
import sv.com.cormaria.servicios.entidades.consultasmedicas.TblConsultas;
import sv.com.cormaria.servicios.entidades.security.TblUsuarios;
import sv.com.cormaria.servicios.enums.EstadoConsultas;
import sv.com.cormaria.servicios.enums.EstadoTarjeta;
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
                if (detalle.getTblProducto().getCodTipProducto() == CatCategoriaProducto.TARJETA_CONTROL){
                    List<TblTarjetaControlCitas> tarjetasList = tarjetaFacade.findNoPagadoByNumExpediente(comprobante.getNumExpediente());
                    if (tarjetasList.isEmpty()){
                        throw new ClinicaModelValidationException("No existe registros de tarjetas pendientes de pago en el expediente");
                    }
                    TblTarjetaControlCitas tarjeta = tarjetasList.get(0);
                    tarjeta.setEstTarjeta(EstadoTarjeta.PAGADO);
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

            }
        }catch(Exception ex){
            ex.printStackTrace();
            throw new ClinicaModelexception(ex.getMessage(), ex);
        }
    }
}