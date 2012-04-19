package sv.com.cormaria.servicios.facades.security;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import sv.com.cormaria.servicios.entidades.security.CatRoles;
import sv.com.cormaria.servicios.exceptions.ClinicaModelexception;


/**
 * Session Bean implementation class CatRolesSessionFacade
 */
@Stateless
public class CatRolesSessionFacade implements CatRolesSessionFacadeLocal {

    @Resource 
    SessionContext sessionContext;

    @PersistenceContext(unitName = "ClinicaEJBPU")
    EntityManager em;

    /**
     * 
     * @return
     * @throws ClinicaModelexception 
     */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<CatRoles> findAllActiveRoles() throws ClinicaModelexception{
    	try{
	    	Query q = em.createNamedQuery("CatRoles.findAll");
	    	return q.getResultList();
    	}catch(Exception ex){
    		ex.printStackTrace();
    		throw new ClinicaModelexception(ex.getMessage(), ex);
    	}
    }
    
    /**
     * 
     * @param r
     * @return
     * @throws ClinicaModelexception 
     */
    public CatRoles create(CatRoles r) throws ClinicaModelexception{
    	try{
	    	em.persist(r);
	    	return r;
    	}catch(Exception ex){
    		ex.printStackTrace();
    		throw new ClinicaModelexception(ex.getMessage(),ex);
    	}
    }

    /**
     * 
     * @param r
     * @return
     * @throws ClinicaModelexception 
     */
    public CatRoles update(CatRoles r) throws ClinicaModelexception{
    	try{
	    	return em.merge(r);
    	}catch(Exception ex){
    		ex.printStackTrace();
    		throw new ClinicaModelexception(ex.getMessage(),ex);
    	}
    }

    /**
     * 
     * @param CatRolessid
     * @return
     * @throws ClinicaModelexception 
     */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public CatRoles findByPk(Long CatRolessid) throws ClinicaModelexception{
    	try{
    		return em.find(CatRoles.class, CatRolessid);
    	}catch(Exception ex){
    		ex.printStackTrace();
    		throw new ClinicaModelexception(ex.getMessage(), ex);
    	}
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public CatRoles findByCodigoExterno(String codigoexterno) throws ClinicaModelexception{
    	try{
    		Query q = em.createNamedQuery("CatRoles.findByCodigoExterno");
    		q.setParameter("codigoexterno", codigoexterno);
    		return (CatRoles) q.getSingleResult();
    	}catch(NoResultException ex){
    		return null;
    	}catch(Exception ex){
    		ex.printStackTrace();
    		throw new ClinicaModelexception(ex.getMessage(), ex);
    	}
    }    
    
    /**
     * 
     * @param r
     * @throws ClinicaModelexception 
     */
    public void delete(CatRoles r) throws ClinicaModelexception{
    	try{
	    	em.remove(this.findByPk(r.getCodRol()));
    	}catch(Exception ex){
    		throw new ClinicaModelexception(ex.getMessage(),ex);
    	}
    }
}
