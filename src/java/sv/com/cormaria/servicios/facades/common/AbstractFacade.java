/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.facades.common;

import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import sv.com.cormaria.servicios.criteria.SearchCriteria;
import sv.com.cormaria.servicios.exceptions.ClinicaModelexception;

/**
 *
 * @author Claudia
 */
public abstract class AbstractFacade<T> {
    private Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    public void create(T entity) throws ClinicaModelexception{
        try{
            getEntityManager().persist(entity);
        }catch(Exception ex){
            throw new ClinicaModelexception(ex.getMessage(), ex);
        }
    }

    public void edit(T entity) throws ClinicaModelexception {
        try{
            getEntityManager().merge(entity);
         }catch(Exception ex){
            throw new ClinicaModelexception(ex.getMessage(), ex);
        }
   }

    public void remove(T entity) throws ClinicaModelexception {
        try{
            getEntityManager().remove(getEntityManager().merge(entity));
        }catch(Exception ex){
            throw new ClinicaModelexception(ex.getMessage(), ex);
        }        
    }

    public T find(Object id) throws ClinicaModelexception {
        try{
            return getEntityManager().find(entityClass, id);
        }catch(Exception ex){
            throw new ClinicaModelexception(ex.getMessage(), ex);
        }
    }

    public abstract List<T> findAll() throws ClinicaModelexception;

    public abstract List<T> findRange(int[] range) throws ClinicaModelexception;

    public abstract int count() throws ClinicaModelexception;

    public List<T> find(SearchCriteria sc, int firstRow, int maxResults){
        Query q = getEntityManager().createQuery(sc.createQuery());
        Map<String,Object> parameters = sc.getParameters();
        for (String parameterName: parameters.keySet()) {
            q.setParameter(parameterName, parameters.get(parameterName));
        }
        q.setFirstResult(firstRow);
        q.setMaxResults(maxResults);
        return q.getResultList();       
   }

    public int count(SearchCriteria sc){
        Query q = getEntityManager().createQuery(sc.createCountQuery());
        Map<String,Object> parameters = sc.getParameters();
        for (String parameterName: parameters.keySet()) {
           q.setParameter(parameterName, parameters.get(parameterName));
        }
        Long count = (Long) q.getSingleResult();
        if (count!=null){
            return count.intValue();
        }
        return 0;
   }
}