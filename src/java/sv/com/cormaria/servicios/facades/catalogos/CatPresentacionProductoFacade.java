/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.facades.catalogos;

import sv.com.cormaria.servicios.facades.common.AbstractFacade;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import sv.com.cormaria.servicios.entidades.catalogos.CatPresentacionProducto;
import sv.com.cormaria.servicios.exceptions.ClinicaModelexception;

/**
 *
 * @author Claudia
 */
@Stateless
public class CatPresentacionProductoFacade extends AbstractFacade<CatPresentacionProducto> implements CatPresentacionProductoFacadeLocal {
    @PersistenceContext(unitName = "ClinicaEJBPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public CatPresentacionProductoFacade() {
        super(CatPresentacionProducto.class);
    }

    @Override
    public List<CatPresentacionProducto> findAll() throws ClinicaModelexception {
        try{
            Query q = em.createNamedQuery("CatPresentacionProducto.findAll");
            return q.getResultList();
        }catch(Exception ex){
            throw new ClinicaModelexception(ex.getMessage(), ex);
        }
    }

    @Override
    public List<CatPresentacionProducto> findRange(int[] range) throws ClinicaModelexception {
        try{
            Query q = em.createNamedQuery("CatPresentacionProducto.findAll");
            q.setMaxResults(range[1] - range[0]);
            return q.getResultList();
        }catch(Exception ex){
            throw new ClinicaModelexception(ex.getMessage(), ex);
        }
    }

    @Override
    public int count() throws ClinicaModelexception {
        try{
            Query q = em.createQuery("Select count(*) from CatPresentacionProducto");
            Long count = (Long)q.getSingleResult();
            if (count!=null){
                return count.intValue();
            }
            return 0;
        }catch(Exception ex){
            throw new ClinicaModelexception(ex.getMessage(), ex);
        }
    }
  
    public List<CatPresentacionProducto> findActive() throws ClinicaModelexception {
        try{
            Query q = em.createNamedQuery("CatPresentacionProducto.findActive");
            return q.getResultList();
        }catch(Exception ex){
            throw new ClinicaModelexception(ex.getMessage(), ex);
        }
    }
}
