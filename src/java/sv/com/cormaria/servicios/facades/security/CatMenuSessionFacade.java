package sv.com.cormaria.servicios.facades.security;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import sv.com.cormaria.servicios.entidades.security.CatMenu;
import sv.com.cormaria.servicios.exceptions.ClinicaModelexception;



/**
 * Session Bean implementation class CatMenuSessionFacade
 */
@Stateless
public class CatMenuSessionFacade implements CatMenuSessionFacadeLocal {

    /**
     * Default constructor. 
     */
    @PersistenceContext(unitName = "ClinicaEJBPU")
    EntityManager em;

	
    public CatMenuSessionFacade() {
    }

    /**
     * Extrae la lista de menus activos para el usuario especificado
     * @param userid Codigo de usuario
     * @return Lista de menus
     * @throws ClinicaModelexception 
     */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    @Override
    public List<CatMenu> findActivePublicMenuByUserId(String userid) throws ClinicaModelexception{
    	try{
	    	Query q = em.createNamedQuery("menu.findNonPublicMenu");
	    	return (List<CatMenu>)q.getResultList();
    	}catch(Exception ex){
    		throw new ClinicaModelexception(ex.getMessage(), ex);
    	}
    }
    
    /**
     * 
     * @param rolesid
     * @return
     * @throws ClinicaModelexception 
     */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    @Override
    public List<CatMenu> findAllPublicMenu(Long rolesid) throws ClinicaModelexception{
    	try{
	    	Query q = em.createNamedQuery("menu.findAllNonPublicMenu");
	    	q.setParameter("rolesid", rolesid);
	    	return q.getResultList();
    	}catch(Exception ex){
    		throw new ClinicaModelexception(ex.getMessage(), ex);
    	}
    }

    /**
     * @see ni.gob.vui.business.sessions.security.CatMenuSessionFacadeLocal#findByParent(java.lang.Long)
     */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    @Override
    public List<CatMenu> findByParent(Long codigomenupadre) throws ClinicaModelexception{
    	try{
            Query q = em.createNamedQuery("menu.findByParent");
            q.setParameter("codPadMenu", codigomenupadre);
            return q.getResultList();
    	}catch(Exception ex){
            throw new ClinicaModelexception(ex.getMessage(), ex);
    	}
    }
    
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    @Override
    public List<CatMenu> findAllMenu() throws ClinicaModelexception{
    	try{
            Query q = em.createNamedQuery("menu.findAllMenu");
            return q.getResultList();
    	}catch(Exception ex){
            throw new ClinicaModelexception(ex.getMessage(), ex);
    	}
    }
    
    @Override
    public CatMenu create(CatMenu menu) throws ClinicaModelexception{
    	try{
                System.out.println("Menu: "+menu.getCodPadMenu());
    		em.persist(menu);
    		return menu;
    	}catch(Exception ex){
    		throw new ClinicaModelexception(ex.getMessage(), ex);
    	}
    }

    /**
     * @see ni.gob.vui.business.sessions.security.MenuSessionFacadeLocale#update(ni.gob.vui.business.entities.security.Menu)
     */
    @Override
    public CatMenu update(CatMenu menu) throws ClinicaModelexception{
    	try{
            return em.merge(menu);
    	}catch(Exception ex){
            throw new ClinicaModelexception(ex.getMessage(), ex);
    	}
    }
    
    /**
     * @see ni.gob.vui.business.sessions.security.CatMenuSessionFacadeLocal#findByPk(java.lang.Long)
     */
    @Override
    public CatMenu findByPk(Long codigomenu) throws ClinicaModelexception{
    	try{
    		return em.find(CatMenu.class, codigomenu);
    	}catch(Exception ex){
    		throw new ClinicaModelexception(ex.getMessage(), ex);
    	}
    }

    /**
     * @see ni.gob.vui.business.sessions.security.CatMenuSessionFacadeLocal#delete(java.lang.Long)
     */
    @Override
    public void delete(Long codigomenu) throws ClinicaModelexception{
    	try{
    		em.remove(this.findByPk(codigomenu));
    	}catch(Exception ex){
    		throw new ClinicaModelexception(ex.getMessage(), ex);
    	}
    }
}