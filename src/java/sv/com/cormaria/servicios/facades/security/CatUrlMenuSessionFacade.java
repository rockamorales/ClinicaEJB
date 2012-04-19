package sv.com.cormaria.servicios.facades.security;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import sv.com.cormaria.servicios.entidades.security.CatUrlMenu;
import sv.com.cormaria.servicios.exceptions.ClinicaModelexception;


/**
 * Session Bean implementation class CatUrlMenuSessionFacade
 */
@Stateless
public class CatUrlMenuSessionFacade implements UrlsmenuSessionFacadeLocal {

    @PersistenceContext(unitName = "ClinicaEJBPU")
    EntityManager em;
    /**
     * Default constructor. 
     */
    public CatUrlMenuSessionFacade() {
    }
    
    public CatUrlMenu insert(CatUrlMenu u) throws ClinicaModelexception{
    	try{
    		em.persist(u);
    		return u;
    	}catch(Exception ex){
    		throw new ClinicaModelexception(ex.getMessage(), ex);
    	}
    }

    public CatUrlMenu update(CatUrlMenu u) throws ClinicaModelexception{
    	try{
    		return em.merge(u);
    	}catch(Exception ex){
    		throw new ClinicaModelexception(ex.getMessage(), ex);
    	}
    }
    
    public CatUrlMenu findByPk(Long urlsmenuid) throws ClinicaModelexception{
    	try{
    		return em.find(CatUrlMenu.class, urlsmenuid);
    	}catch(Exception ex){
    		throw new ClinicaModelexception(ex.getMessage(), ex);
    	}
    }    
    
    public void delete(Long urlsmenuid) throws ClinicaModelexception{
    	try{
    		em.remove(this.findByPk(urlsmenuid));
    	}catch(Exception ex){
    		throw new ClinicaModelexception(ex.getMessage(), ex);
    	}
    }
    
    public List<CatUrlMenu> findByCodigomenu(Long codigomenu) throws ClinicaModelexception{
    	try{
    		Query q = em.createNamedQuery("urlsmenu.findByCodigomenu");
    		q.setParameter("codigomenu", codigomenu);
    		return q.getResultList();
    	}catch(Exception ex){
    		throw new ClinicaModelexception(ex.getMessage(), ex);
    	}
    }    
}