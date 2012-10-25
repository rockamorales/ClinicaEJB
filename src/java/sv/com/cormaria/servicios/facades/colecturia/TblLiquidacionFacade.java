/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.facades.colecturia;

import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import sv.com.cormaria.servicios.entidades.colecturia.TblLiquidacion;
import sv.com.cormaria.servicios.exceptions.ClinicaModelexception;
import sv.com.cormaria.servicios.facades.common.AbstractFacade;

/**
 *
 * @author Mackk
 */
@Stateless
public class TblLiquidacionFacade extends AbstractFacade<TblLiquidacion> implements TblLiquidacionFacadeLocal {
    @PersistenceContext(unitName = "ClinicaEJBPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public TblLiquidacionFacade() {
        super(TblLiquidacion.class);
    }
    
    public TblLiquidacion findByDate(Date fecLiquidacion) throws ClinicaModelexception{
        try{
            Query q = em.createNamedQuery("TblLiquidacion.findByDate");
            q.setParameter("fecLiquidacion", fecLiquidacion, TemporalType.DATE);
            return (TblLiquidacion) q.getSingleResult();
        }catch(NoResultException ex){
            return null;
        }catch(Exception ex){
            ex.printStackTrace();
            throw new ClinicaModelexception(ex.getMessage(), ex);
        }
    }
    public List<TblLiquidacion> findByAll() throws ClinicaModelexception{
        try{
            Query q = em.createNamedQuery("TblLiquidacion.findAll");
            return q.getResultList();
        }catch(NoResultException ex){
            return null;
        }catch(Exception ex){
            ex.printStackTrace();
            throw new ClinicaModelexception(ex.getMessage(), ex);
        }
    }

    @Override
    public List<TblLiquidacion> findAll() throws ClinicaModelexception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<TblLiquidacion> findRange(int[] range) throws ClinicaModelexception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int count() throws ClinicaModelexception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
