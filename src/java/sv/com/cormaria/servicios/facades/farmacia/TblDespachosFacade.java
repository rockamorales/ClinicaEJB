/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.facades.farmacia;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import sv.com.cormaria.servicios.entidades.farmacia.TblDespachos;
import sv.com.cormaria.servicios.exceptions.ClinicaModelexception;
import sv.com.cormaria.servicios.facades.common.AbstractFacade;

/**
 *
 * @author Mackk
 */
@Stateless
public class TblDespachosFacade extends AbstractFacade<TblDespachos> implements TblDespachosFacadeLocal {
    @PersistenceContext(unitName = "ClinicaEJBPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public TblDespachosFacade() {
        super(TblDespachos.class);
    }
    
    @Override
    public List<TblDespachos> findAll() throws ClinicaModelexception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public TblDespachos findByNumReceta(Integer numReceta) throws ClinicaModelexception {
        try{
            Query q = em.createNamedQuery("TblDespachos.findByNumReceta");
            q.setParameter("numReceta", numReceta);
            return (TblDespachos) q.getSingleResult();
        }catch(EntityNotFoundException ex){
            return null;
        }catch(NoResultException ex){
            return null;
        }catch(Exception ex){
            ex.printStackTrace();
            throw new ClinicaModelexception(ex.getMessage(), ex);
        }
    }

    @Override
    public List<TblDespachos> findRange(int[] range) throws ClinicaModelexception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int count() throws ClinicaModelexception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public List<TblDespachos> findDespachosCreados() throws ClinicaModelexception{
        try{
            Query q = em.createNamedQuery("tblDespachos.findDespachosCreados");
            return q.getResultList();
        }catch(Exception ex){
            ex.printStackTrace();
            throw new ClinicaModelexception(ex.getMessage(), ex);
        }
    }
}
