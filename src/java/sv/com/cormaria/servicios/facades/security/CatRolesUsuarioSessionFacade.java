package sv.com.cormaria.servicios.facades.security;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import sv.com.cormaria.servicios.entidades.security.CatRolesUsuario;
import sv.com.cormaria.servicios.entidades.security.CatRolesUsuarioPK;
import sv.com.cormaria.servicios.exceptions.ClinicaModelexception;


/**
 * Session Bean implementation class CatRolesUsuarioSessionFacade
 */
@Stateless
public class CatRolesUsuarioSessionFacade implements CatRolesUsuarioSessionFacadeLocal {

    /**
     * Default constructor. 
     */
    @PersistenceContext(unitName = "ClinicaEJBPU")
    EntityManager em;
    
	/**
         * 
         * @param usuariosid
         * @return
         * @throws ClinicaModelexception 
         */
        @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
        @Override
	public List<CatRolesUsuario> findAllRolesByUser(Long usuariosid) throws ClinicaModelexception{
    	try{
	    	Query q = em.createNamedQuery("rolesusuario.findAllRolesByUser");
	    	q.setParameter("usuariosid", usuariosid);
	    	return q.getResultList();
    	}catch(Exception ex){
    		throw new ClinicaModelexception(ex.getMessage(),ex);
    	}
    }
    
    /**
     * @see ni.gob.vui.business.sessions.security.CatRolesUsuarioSessionFacadeLocal#create(ni.gob.vui.business.entities.security.Rolesusuario)
     */
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public CatRolesUsuario create(CatRolesUsuario r) throws ClinicaModelexception{
    	try{
            em.persist(r);
            return r;
    	}catch(Exception ex){
            throw new ClinicaModelexception(ex.getMessage(), ex);
    	}
    }

    /**
     * @see ni.gob.vui.business.sessions.security.CatRolesUsuarioSessionFacadeLocal#update(ni.gob.vui.business.entities.security.Rolesusuario)
     */
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public CatRolesUsuario update(CatRolesUsuario r) throws ClinicaModelexception{
    	try{
    		return em.merge(r);
    	}catch(Exception ex){
    		throw new ClinicaModelexception(ex.getMessage(), ex);
    	}
    }

    /**
     * @see ni.gob.vui.business.sessions.security.CatRolesUsuarioSessionFacadeLocal#findByPk(ni.gob.vui.business.entities.security.RolesusuarioPK)
     */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public CatRolesUsuario findByPk(CatRolesUsuarioPK pk) throws ClinicaModelexception{
    	try{
    		return em.find(CatRolesUsuario.class, pk);
    	}catch(Exception ex){
    		throw new ClinicaModelexception(ex.getMessage(), ex);
    	}
    }

    /**
     * @see ni.gob.vui.business.sessions.security.CatRolesUsuarioSessionFacadeLocal#delete(ni.gob.vui.business.entities.security.Rolesusuario)
     */
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void delete(CatRolesUsuario r) throws ClinicaModelexception{
    	try{
    		em.remove(this.findByPk(r.getId()));
    	}catch(Exception ex){
    		throw new ClinicaModelexception(ex.getMessage(), ex);
    	}
    }
}
