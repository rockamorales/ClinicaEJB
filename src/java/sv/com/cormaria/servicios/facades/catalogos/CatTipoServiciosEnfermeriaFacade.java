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
import sv.com.cormaria.servicios.entidades.catalogos.CatTipoServiciosEnfermeria;
import sv.com.cormaria.servicios.exceptions.ClinicaModelexception;

/**
 *
 * @author Claudia
 */
@Stateless
public class CatTipoServiciosEnfermeriaFacade extends AbstractFacade<CatTipoServiciosEnfermeria> implements CatTipoServiciosEnfermeriaFacadeLocal {
    @PersistenceContext(unitName = "ClinicaEJBPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public CatTipoServiciosEnfermeriaFacade() {
        super(CatTipoServiciosEnfermeria.class);
    }

    @Override
    public List<CatTipoServiciosEnfermeria> findAll() throws ClinicaModelexception {
        try{
            Query q = em.createNamedQuery("CatTipoServiciosEnfermeria.findAll");
            return q.getResultList();
        }catch(Exception ex){
            throw new ClinicaModelexception(ex.getMessage(), ex);
        }
    }

    @Override
    public List<CatTipoServiciosEnfermeria> findRange(int[] range) throws ClinicaModelexception {
        try{
            Query q = em.createNamedQuery("CatTipoServiciosEnfermeria.findAll");
            q.setMaxResults(range[1] - range[0]);
            return q.getResultList();
        }catch(Exception ex){
            throw new ClinicaModelexception(ex.getMessage(), ex);
        }
    }

    @Override
    public int count() throws ClinicaModelexception {
        try{
            Query q = em.createQuery("Select count(*) from CatTipoServiciosEnfermeria");
            Long count = (Long)q.getSingleResult();
            if (count!=null){
                return count.intValue();
            }
            return 0;
        }catch(Exception ex){
            throw new ClinicaModelexception(ex.getMessage(), ex);
        }
    }
    
}
