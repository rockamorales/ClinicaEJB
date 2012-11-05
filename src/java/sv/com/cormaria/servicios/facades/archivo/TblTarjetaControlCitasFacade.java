/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.facades.archivo;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import sv.com.cormaria.servicios.entidades.archivo.TblExpedientePacientes;
import sv.com.cormaria.servicios.entidades.archivo.TblTarjetaControlCitas;
import sv.com.cormaria.servicios.entidades.colecturia.TblComprobanteDonacion;
import sv.com.cormaria.servicios.entidades.colecturia.TblDetalleComprobanteDonacion;
import sv.com.cormaria.servicios.entidades.colecturia.TblDetalleComprobanteDonacionPK;
import sv.com.cormaria.servicios.entidades.administracion.TblProducto;
import sv.com.cormaria.servicios.enums.Estado;
import sv.com.cormaria.servicios.enums.EstadoComprobanteDonacion;
import sv.com.cormaria.servicios.enums.EstadoTarjeta;
import sv.com.cormaria.servicios.enums.TipoComprobanteDonacion;
import sv.com.cormaria.servicios.exceptions.ClinicaModelexception;
import sv.com.cormaria.servicios.facades.colecturia.TblComprobanteDonacionFacadeLocal;
import sv.com.cormaria.servicios.facades.colecturia.TblDetalleComprobanteDonacionFacadeLocal;
import sv.com.cormaria.servicios.facades.common.AbstractFacade;
import sv.com.cormaria.servicios.facades.administracion.TblProductoFacadeLocal;
import sv.com.cormaria.servicios.helpers.NumToText;

/**
 *
 * @author Mackk
 */
@Stateless
public class TblTarjetaControlCitasFacade extends AbstractFacade<TblTarjetaControlCitas> implements TblTarjetaControlCitasFacadeLocal {
    @PersistenceContext(unitName = "ClinicaEJBPU")
    private EntityManager em;

    @EJB
    private TblComprobanteDonacionFacadeLocal comprobanteFacade;
    
    @EJB
    private TblProductoFacadeLocal productoFacade;

    @EJB
    private TblDetalleComprobanteDonacionFacadeLocal detalleComprobanteFacade;
    
    protected EntityManager getEntityManager() {
        return em;
    }

    public TblTarjetaControlCitasFacade() {
        super(TblTarjetaControlCitas.class);
    }

    @Override
    public List<TblTarjetaControlCitas> findAll() throws ClinicaModelexception {
     try{
            Query q = em.createNamedQuery("TblTarjetaControlCitas.findAll");
            return q.getResultList();
        }catch(Exception ex){
            throw new ClinicaModelexception(ex.getMessage(), ex);
        }
    }

    
    public List<TblTarjetaControlCitas> findActiveByNumExpediente(Integer numExpediente) throws ClinicaModelexception {
        try{
            Query q = em.createNamedQuery("TblTarjetaControlCitas.findActiveByNumExpediente");
            q.setParameter("numExpediente", numExpediente);
            return q.getResultList();
        }catch(Exception ex){
            throw new ClinicaModelexception(ex.getMessage(), ex);
        }
    }

    public List<TblTarjetaControlCitas> findNoPagadoByNumExpediente(Integer numExpediente) throws ClinicaModelexception {
        try{
            Query q = em.createNamedQuery("TblTarjetaControlCitas.findNoPagadoByNumExpediente");
            q.setParameter("numExpediente", numExpediente);
            return q.getResultList();
        }catch(Exception ex){
            throw new ClinicaModelexception(ex.getMessage(), ex);
        }
    }
    
    @Override
    public List<TblTarjetaControlCitas> findRange(int[] range) throws ClinicaModelexception {
        try{
            Query q = em.createNamedQuery("TblTarjetaControlCitas.findAll");
            q.setMaxResults(range[1] - range[0]);
            return q.getResultList();
        }catch(Exception ex){
            throw new ClinicaModelexception(ex.getMessage(), ex);
        }
    }
    

    @Override
    public int count() throws ClinicaModelexception {
        try{
            Query q = em.createQuery("Select count(*) from TblTarjetaControlCitas");
            Long count = (Long)q.getSingleResult();
            if (count!=null){
                return count.intValue();
            }
            return 0;
        }catch(Exception ex){
            throw new ClinicaModelexception(ex.getMessage(), ex);
        }
    }
    
    public List<TblTarjetaControlCitas> findByNumExpediente(Integer numExpediente) throws ClinicaModelexception {
        try{
            Query q = em.createNamedQuery("TblTarjetaControlCitas.findByNumExpediente");
            q.setParameter("numExpediente", numExpediente);
            return q.getResultList();
        }catch(Exception ex){
            throw new ClinicaModelexception(ex.getMessage(), ex);
        }
    }
    
    @Override
    public TblTarjetaControlCitas create(TblTarjetaControlCitas entity) throws ClinicaModelexception{
        try{
            TblExpedientePacientes expediente = em.find(TblExpedientePacientes.class, entity.getNumExpediente());
            List<TblTarjetaControlCitas> tarjetasList = this.findActiveByNumExpediente(entity.getNumExpediente());
            if (!tarjetasList.isEmpty()){
                TblTarjetaControlCitas control = tarjetasList.get(0);
                control.setActTarjeta(Estado.INACTIVO);
            }
            entity.setActTarjeta(Estado.ACTIVO);
            entity.setEstTarjeta(EstadoTarjeta.NOPAGADO);
            getEntityManager().persist(entity);
            
           TblComprobanteDonacion tblComprobante = new TblComprobanteDonacion();
           tblComprobante.setCodCarisma(1);
           tblComprobante.setCodTipDonacion(2);
           tblComprobante.setCodTipDonante(2);
           tblComprobante.setEstComDonacion(EstadoComprobanteDonacion.EMITIDO);
           tblComprobante.setFecComDonacion(new java.util.Date());
           tblComprobante.setCanLetras("Cero");
           tblComprobante.setNumExpediente(expediente.getNumExpediente());
           tblComprobante.setNomComDonacion(expediente.getNomPaciente() + " " + expediente.getPriApePaciente() + " " + expediente.getSecApePaciente());
           tblComprobante.setTipComprobante(TipoComprobanteDonacion.COBRO);
           comprobanteFacade.create(tblComprobante);

           TblDetalleComprobanteDonacion detalleComprobante = new TblDetalleComprobanteDonacion();
           List<TblProducto> productosList = productoFacade.findTarjetaControl();
           if (!tarjetasList.isEmpty()){
            TblProducto tarjeta = productosList.get(0);
            detalleComprobante.setCanProComDonacion(1);
            detalleComprobante.setPreUniComDonacion(tarjeta.getPreFinProducto());
            TblDetalleComprobanteDonacionPK pk = new TblDetalleComprobanteDonacionPK();
            pk.setNumComDonacion(tblComprobante.getNumComDonacion());
            pk.setNumProducto(tarjeta.getNumProducto());
            detalleComprobante.setTblDetalleComprobanteDonacionPK(pk);
            detalleComprobante.setTotIteComDonacion(tarjeta.getPreFinProducto());
            tblComprobante.setTotDonacion(tarjeta.getPreFinProducto());
            tblComprobante.setCanLetras(NumToText.convertirLetras(tblComprobante.getTotDonacion()));
            detalleComprobanteFacade.create(detalleComprobante);
          }
          return entity;
        }catch(Exception ex){
            throw new ClinicaModelexception(ex.getMessage(), ex);
        }
    }    
  }