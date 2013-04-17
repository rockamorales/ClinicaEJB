/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.facades.consultasmedicas;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import sv.com.cormaria.servicios.entidades.consultasmedicas.TblDetalleReceta;
import sv.com.cormaria.servicios.exceptions.ClinicaModelexception;
import sv.com.cormaria.servicios.facades.common.AbstractFacade;

/**
 *
 * @author Mackk
 */
@Stateless
public class TblDetalleRecetaFacade extends AbstractFacade<TblDetalleReceta> implements TblDetalleRecetaFacadeLocal {
    @PersistenceContext(unitName = "ClinicaEJBPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public TblDetalleRecetaFacade() {
        super(TblDetalleReceta.class);
    }
    
    
    public List<TblDetalleReceta> findByNumReceta(Integer numReceta) throws ClinicaModelexception {
        try{
            Query q = em.createNamedQuery("TblDetalleReceta.findByNumReceta");
            q.setParameter("numReceta", numReceta);
            return q.getResultList();
        }catch(Exception ex){
            ex.printStackTrace();
            throw new ClinicaModelexception(ex.getMessage(), ex);
        }
    }
    
    public List<TblDetalleReceta> findNoContribuibleByNumReceta(Integer numReceta) throws ClinicaModelexception {
        try{
            Query q = em.createNamedQuery("TblDetalleReceta.findNoContribuibleByNumReceta");
            q.setParameter("numReceta", numReceta);
            return q.getResultList();
        }catch(Exception ex){
            ex.printStackTrace();
            throw new ClinicaModelexception(ex.getMessage(), ex);
        }
    }
    public List<TblDetalleReceta> findContribuibleByNumReceta(Integer numReceta) throws ClinicaModelexception {
        try{
            Query q = em.createNamedQuery("TblDetalleReceta.findContribuibleByNumReceta");
            q.setParameter("numReceta", numReceta);
            return q.getResultList();
        }catch(Exception ex){
            ex.printStackTrace();
            throw new ClinicaModelexception(ex.getMessage(), ex);
        }
    }


    @Override
    public List<TblDetalleReceta> findAll() throws ClinicaModelexception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<TblDetalleReceta> findRange(int[] range) throws ClinicaModelexception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int count() throws ClinicaModelexception {
        throw new UnsupportedOperationException("Not supported yet.");
    }    
}
