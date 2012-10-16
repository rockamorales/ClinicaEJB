/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.facades.archivo;

import java.util.List;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sv.com.cormaria.servicios.entidades.archivo.EstadoServiciosEnfermeria;
import sv.com.cormaria.servicios.entidades.archivo.TblExpedientePacientes;
import sv.com.cormaria.servicios.entidades.archivo.TblServiciosEnfermeria;
import sv.com.cormaria.servicios.entidades.catalogos.CatEspecialidad;
import sv.com.cormaria.servicios.entidades.catalogos.CatTipoServiciosEnfermeria;
import sv.com.cormaria.servicios.entidades.colecturia.TblComprobanteDonacion;
import sv.com.cormaria.servicios.entidades.colecturia.TblDetalleComprobanteDonacion;
import sv.com.cormaria.servicios.entidades.colecturia.TblDetalleComprobanteDonacionPK;
import sv.com.cormaria.servicios.entidades.security.TblUsuarios;
import sv.com.cormaria.servicios.enums.EstadoComprobanteDonacion;
import sv.com.cormaria.servicios.exceptions.ClinicaModelValidationException;
import sv.com.cormaria.servicios.exceptions.ClinicaModelexception;
import sv.com.cormaria.servicios.facades.catalogos.CatTipoServiciosEnfermeriaFacadeLocal;
import sv.com.cormaria.servicios.facades.colecturia.TblComprobanteDonacionFacadeLocal;
import sv.com.cormaria.servicios.facades.colecturia.TblDetalleComprobanteDonacionFacadeLocal;
import sv.com.cormaria.servicios.facades.common.AbstractFacade;
import sv.com.cormaria.servicios.facades.administracion.TblProductoFacadeLocal;
import sv.com.cormaria.servicios.facades.security.TblUsuariosSessionFacadeLocal;

/**
 *
 * @author Mackk
 */
@Stateless
public class TblServiciosEnfermeriaFacade extends AbstractFacade<TblServiciosEnfermeria> implements TblServiciosEnfermeriaFacadeLocal {
    @PersistenceContext(unitName = "ClinicaEJBPU")
    private EntityManager em;
    
    @Resource
    SessionContext sessionContext;

    @EJB
    private TblComprobanteDonacionFacadeLocal comprobanteFacade;

    @EJB
    private TblProductoFacadeLocal productoFacade;

    @EJB
    private TblUsuariosSessionFacadeLocal usuariosFacade;

    @EJB
    private CatTipoServiciosEnfermeriaFacadeLocal tipoServicioFacade;
    
    @EJB
    private TblDetalleComprobanteDonacionFacadeLocal detalleComprobanteFacade;
    
    
    protected EntityManager getEntityManager() {
        return em;
    }

    public TblServiciosEnfermeriaFacade() {
        super(TblServiciosEnfermeria.class);
    }

    @Override
    public List<TblServiciosEnfermeria> findAll() throws ClinicaModelexception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<TblServiciosEnfermeria> findRange(int[] range) throws ClinicaModelexception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int count() throws ClinicaModelexception {
        throw new UnsupportedOperationException("Not supported yet.");
    }    
    
    public TblServiciosEnfermeria crearServicio(TblServiciosEnfermeria servicio, TblExpedientePacientes expediente) throws ClinicaModelexception{
        try{
           TblUsuarios usuario = usuariosFacade.findByCodigoUsuario(sessionContext.getCallerPrincipal().getName());
           if (usuario.getEmpleado()==null){
               throw new ClinicaModelValidationException("El usuario con el que ha ingresado no esta registrado como empleado de la institucion");
           }
           servicio.setNumEmpleado(usuario.getNumEmpleado());
           servicio.setEstSerEnfermeria(EstadoServiciosEnfermeria.CREADO);
           this.create(servicio);
           TblComprobanteDonacion tblComprobante = new TblComprobanteDonacion();
           tblComprobante.setCodCarisma(1);
           tblComprobante.setCodTipDonacion(2);
           tblComprobante.setCodTipDonante(2);
           tblComprobante.setEstComDonacion(EstadoComprobanteDonacion.EMITIDO);
           tblComprobante.setFecComDonacion(new java.util.Date());
           tblComprobante.setCanLetras("Cero");
           tblComprobante.setNumExpediente(expediente.getNumExpediente());
           tblComprobante.setNomComDonacion(expediente.getNomPaciente() + " " + expediente.getPriApePaciente() + " " + expediente.getSecApePaciente());
           comprobanteFacade.create(tblComprobante);
           System.out.println("Numero de comprobante: "+tblComprobante.getNumComDonacion());
           //Agregando la consulta
           TblDetalleComprobanteDonacion detalleComprobante = new TblDetalleComprobanteDonacion();
           CatTipoServiciosEnfermeria tipoServicio = tipoServicioFacade.find(servicio.getCodServEnfermeria());
           detalleComprobante.setCanProComDonacion(1);
           detalleComprobante.setPreUniComDonacion(tipoServicio.getProducto().getPreFinProducto());
           TblDetalleComprobanteDonacionPK pk = new TblDetalleComprobanteDonacionPK();
           pk.setNumComDonacion(tblComprobante.getNumComDonacion());
           pk.setNumProducto(tipoServicio.getNumProducto());
           detalleComprobante.setNumSerEnfermeria(servicio.getNumSerEnfermeria());
           detalleComprobante.setTblDetalleComprobanteDonacionPK(pk);
           detalleComprobante.setTotIteComDonacion(tipoServicio.getProducto().getPreFinProducto());
           detalleComprobanteFacade.create(detalleComprobante);
           return servicio;
        }catch(Exception ex){
            ex.printStackTrace();
            throw new ClinicaModelexception(ex.getMessage(), ex);
        }
    }
    
    @Override
    public void remove(TblServiciosEnfermeria entity) throws ClinicaModelexception {
        try{
            entity.setEstSerEnfermeria(EstadoServiciosEnfermeria.ELIMINADO);
            getEntityManager().merge(entity);
        }catch(Exception ex){
            throw new ClinicaModelexception(ex.getMessage(), ex);
        }        
    }
    
    public TblServiciosEnfermeria saveAndMarkAsApplied(TblServiciosEnfermeria servicio) throws ClinicaModelexception{
        try{
            servicio.setEstSerEnfermeria(EstadoServiciosEnfermeria.APLICADO);
            return em.merge(servicio);
        }catch(Exception ex){
            ex.printStackTrace();
            throw new ClinicaModelexception(ex.getMessage(), ex);
        }
    }
}