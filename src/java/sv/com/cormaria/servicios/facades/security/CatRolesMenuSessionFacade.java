package sv.com.cormaria.servicios.facades.security;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import sv.com.cormaria.servicios.entidades.security.CatMenu;
import sv.com.cormaria.servicios.entidades.security.CatRolesMenu;
import sv.com.cormaria.servicios.entidades.security.CatRolesMenuPK;
import sv.com.cormaria.servicios.exceptions.ClinicaModelexception;


/**
 * Session Bean implementation class CatRolesMenuSessionFacade
 */
@Stateless
public class CatRolesMenuSessionFacade implements CatRolesMenuSessionFacadeLocal {

    @EJB
    CatMenuSessionFacadeLocal menuSession;
	
    @PersistenceContext(unitName = "ClinicaEJBPU")
    EntityManager em;
    /**
     * Default constructor. 
     */
    public CatRolesMenuSessionFacade() {
    }
        
    /**
     * 
     * @param rolesmenu
     * @return
     * @throws ClinicaModelexception 
     */
    @Override
    public CatRolesMenu create(CatRolesMenu rolesmenu) throws ClinicaModelexception{
    	try{
    		
    		em.persist(rolesmenu);
    		return rolesmenu;
    	}catch(Exception ex){
    		throw new ClinicaModelexception(ex.getMessage(), ex);
    	}
    }

    /**
     * 
     * @param rolesmenu
     * @return
     * @throws ClinicaModelexception 
     */
    @Override
    public CatRolesMenu delete(CatRolesMenu rolesmenu) throws ClinicaModelexception{
    	try{
    		em.remove(this.findByPk(rolesmenu.getId()));
    		return rolesmenu;
    	}catch(Exception ex){
    		throw new ClinicaModelexception(ex.getMessage(), ex);
    	}
    }
    
 
    /**
     * 
     * @param pk
     * @return
     * @throws VuiModelexception 
     */
    @Override
    public CatRolesMenu findByPk(CatRolesMenuPK pk) throws ClinicaModelexception{
    	try{
    		return em.find(CatRolesMenu.class, pk);
    	}catch(NoResultException ex){
    		return null;
    	}catch(Exception ex){
    		throw new ClinicaModelexception(ex.getMessage(), ex);
    	}
    }

    /**
     * 
     * @param rolesid
     * @param menu
     * @param added
     * @throws VuiModelexception 
     */
    @Override
    public void addOrRemoveOption(Long rolesid, CatMenu menu, Boolean added) throws ClinicaModelexception{
    	this.addOrRemoveOption(rolesid, menu, added, true);
    }
    
    
    /**
     * 
     * @param rolesid
     * @param menu
     * @param added
     * @param addchilds
     * @throws ClinicaModelexception 
     */
    public void addOrRemoveOption(Long rolesid, CatMenu menu, Boolean added, Boolean addchilds) throws ClinicaModelexception{
    	try{
    		menu = em.find(CatMenu.class, menu.getCodMenu());
    		CatMenu parentMenu = null;
    		CatRolesMenuPK parentPk = null;
    		CatRolesMenuPK childPk = null;
	    	if (added){
	    		CatRolesMenu rolesmenu = new CatRolesMenu();
	    		CatRolesMenuPK pk = new CatRolesMenuPK();
	    		pk.setCodRol(rolesid);
	    		pk.setCodMenu(menu.getCodMenu());
	    		rolesmenu.setId(pk);
	    		List<CatMenu> childList = menuSession.findByParent(menu.getCodMenu());
    			for (CatMenu childMenu : childList){
	    			childPk = new CatRolesMenuPK();
	    			childPk.setCodMenu(childMenu.getCodMenu());
	    			childPk.setCodRol(rolesid);
	    			CatRolesMenu rolesMenuChild = this.findByPk(childPk);
	    			if (rolesMenuChild!=null){
	    				this.addOrRemoveOption(rolesid, childMenu, true, null);
	    			}					
				}
	    		this.delete(rolesmenu);
	    	}else{
	    		CatRolesMenu rolesmenu = new CatRolesMenu();
	    		CatRolesMenuPK pk = new CatRolesMenuPK();
	    		pk.setCodRol(rolesid);
	    		pk.setCodMenu(menu.getCodMenu());
	    		rolesmenu.setId(pk);
	    		this.create(rolesmenu);
	    		if (addchilds){
		    		List<CatMenu> childList = menuSession.findByParent(menu.getCodMenu());
	    			for (CatMenu childMenu : childList) {
		    			childPk = new CatRolesMenuPK();
		    			childPk.setCodMenu(childMenu.getCodMenu());
		    			childPk.setCodRol(rolesid);
		    			CatRolesMenu rolesMenuChild = this.findByPk(childPk);
		    			if (rolesMenuChild==null){
		    				this.addOrRemoveOption(rolesid, childMenu, false, true);
		    			}
					}
	    		}
	    		parentMenu = menu.getMenu();
	    		if (parentMenu!=null){
	    			parentPk = new CatRolesMenuPK();
	    			parentPk.setCodMenu(parentMenu.getCodMenu());
	    			parentPk.setCodRol(rolesid);
	    			CatRolesMenu rolesMenuParent = this.findByPk(parentPk);
	    			if (rolesMenuParent==null){
	    				this.addOrRemoveOption(rolesid, parentMenu, false, false);
	    			}
	    		}
	    	}
    	}catch(ClinicaModelexception ex){
    		throw ex;
    	}catch(Exception ex){
    		throw new ClinicaModelexception(ex.getMessage(), ex);
    	}
    }
}