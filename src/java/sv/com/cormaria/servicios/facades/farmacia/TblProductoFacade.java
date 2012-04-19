/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.facades.farmacia;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import sv.com.cormaria.servicios.entidades.farmacia.TblProducto;
import sv.com.cormaria.servicios.exceptions.ClinicaModelexception;
import sv.com.cormaria.servicios.facades.common.AbstractFacade;

/**
 *
 * @author Mackk
 */
@Stateless
public class TblProductoFacade extends AbstractFacade<TblProducto> implements TblProductoFacadeLocal {
    @PersistenceContext(unitName = "ClinicaEJBPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public TblProductoFacade() {
        super(TblProducto.class);
    }

    @Override
    public List<TblProducto> findAll() throws ClinicaModelexception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<TblProducto> findRange(int[] range) throws ClinicaModelexception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int count() throws ClinicaModelexception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public List<TblProducto> findByNombreProducto(String nomProducto, int firstRow, int maxResults) throws ClinicaModelexception {
        try{
            Query q = em.createNamedQuery("TblProdcuto.findByNombreProducto");
            q.setParameter("nomProducto", nomProducto);
            
            q.setFirstResult(firstRow);
            q.setMaxResults(maxResults);
            return q.getResultList();
        }catch(Exception ex){
            ex.printStackTrace();
            throw new ClinicaModelexception(ex.getMessage(), ex);
        }
    }
    public List<TblProducto> findActive() throws ClinicaModelexception {
        try{
            Query q = em.createNamedQuery("TblProducto.findActive");
            return q.getResultList();
        }catch(Exception ex){
            throw new ClinicaModelexception(ex.getMessage(), ex);
        }
    }    
        
    public List<TblProducto> findActiveServices() throws ClinicaModelexception{
        try{
            Query q = em.createNamedQuery("TblProducto.findActiveServices");
            return q.getResultList();
        }catch(Exception ex){
            ex.printStackTrace();
            throw new ClinicaModelexception(ex.getMessage(), ex);
        }
    }
    
    public List<TblProducto> findTarjetaControl() throws ClinicaModelexception{
        try{
            Query q = em.createNamedQuery("TblProducto.findTarjetaControl");
            return q.getResultList();
        }catch(Exception ex){
            ex.printStackTrace();
            throw new ClinicaModelexception(ex.getMessage(), ex);
        }
    }
}