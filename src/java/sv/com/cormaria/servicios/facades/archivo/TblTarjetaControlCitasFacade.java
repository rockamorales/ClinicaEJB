/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.facades.archivo;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import sv.com.cormaria.servicios.entidades.archivo.TblTarjetaControlCitas;
import sv.com.cormaria.servicios.enums.Estado;
import sv.com.cormaria.servicios.enums.EstadoTarjeta;
import sv.com.cormaria.servicios.exceptions.ClinicaModelexception;
import sv.com.cormaria.servicios.facades.common.AbstractFacade;

/**
 *
 * @author Mackk
 */
@Stateless
public class TblTarjetaControlCitasFacade extends AbstractFacade<TblTarjetaControlCitas> implements TblTarjetaControlCitasFacadeLocal {
    @PersistenceContext(unitName = "ClinicaEJBPU")
    private EntityManager em;

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
    public void create(TblTarjetaControlCitas entity) throws ClinicaModelexception{
        try{
            List<TblTarjetaControlCitas> tarjetasList = this.findActiveByNumExpediente(entity.getNumExpediente());
            if (!tarjetasList.isEmpty()){
                TblTarjetaControlCitas control = tarjetasList.get(0);
                control.setActTarjeta(Estado.INACTIVO);
            }
            entity.setActTarjeta(Estado.ACTIVO);
            entity.setEstTarjeta(EstadoTarjeta.NOPAGADO);
            getEntityManager().persist(entity);
        }catch(Exception ex){
            throw new ClinicaModelexception(ex.getMessage(), ex);
        }
    }
    
    
  }
    

