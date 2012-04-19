/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.facades.catalogos;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import sv.com.cormaria.servicios.entidades.catalogos.CatUbicacionFisica;
import sv.com.cormaria.servicios.exceptions.ClinicaModelexception;
import sv.com.cormaria.servicios.facades.common.AbstractFacade;

/**
 *
 * @author Claudia
 */

@Stateless
public class CatUbicacionFisicaFacade extends AbstractFacade<CatUbicacionFisica> implements CatUbicacionFisicaFacadeLocal {
    @PersistenceContext(unitName = "ClinicaEJBPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public CatUbicacionFisicaFacade() {
        super(CatUbicacionFisica.class);
    }

    @Override
    public List<CatUbicacionFisica> findAll() throws ClinicaModelexception {
        try{
            Query q = em.createNamedQuery("CatUbicacionFisica.findAll");
            return q.getResultList();
        }catch(Exception ex){
            throw new ClinicaModelexception(ex.getMessage(), ex);
        }
    }

    @Override
    public List<CatUbicacionFisica> findRange(int[] range) throws ClinicaModelexception {
        try{
            Query q = em.createNamedQuery("CatUbicacionFisica.findAll");
            q.setMaxResults(range[1] - range[0]);
            return q.getResultList();
        }catch(Exception ex){
            throw new ClinicaModelexception(ex.getMessage(), ex);
        }
    }

    @Override
    public int count() throws ClinicaModelexception {
        try{
            Query q = em.createQuery("Select count(*) from CatUbicacionFisica");
            Long count = (Long)q.getSingleResult();
            if (count!=null){
                return count.intValue();
            }
            return 0;
        }catch(Exception ex){
            throw new ClinicaModelexception(ex.getMessage(), ex);
        }
    }
    public List<CatUbicacionFisica> findActive() throws ClinicaModelexception {
        try{
            Query q = em.createNamedQuery("CatUbicacionFisica.findActive");
            return q.getResultList();
        }catch(Exception ex){
            throw new ClinicaModelexception(ex.getMessage(), ex);
        }
    }
}
