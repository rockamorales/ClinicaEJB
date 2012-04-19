package sv.com.cormaria.servicios.facades.security;
import javax.ejb.Local;

import sv.com.cormaria.servicios.entidades.security.CatMenu;
import sv.com.cormaria.servicios.entidades.security.CatRolesMenu;
import sv.com.cormaria.servicios.entidades.security.CatRolesMenuPK;
import sv.com.cormaria.servicios.exceptions.ClinicaModelexception;

@Local
public interface CatRolesMenuSessionFacadeLocal {
    /**
     * Creacion de registros de Rolesmenu
     * @param rolesmenu de tipo Rolesmenu
     * @return Rolesmenu
     * @throws VuiModelexception
     */
     public CatRolesMenu create(CatRolesMenu rolesmenu) throws ClinicaModelexception;
	
	 /**
     * Elimacion de registros de Rolesmenu
     * @param rolesmenu de tipo Rolesmenu
     * @return Rolesmenu
     * @throws VuiModelexception
     */
    public CatRolesMenu delete(CatRolesMenu rolesmenu) throws ClinicaModelexception;    
    
    /**
     * Obtiene todos los registros de Rolesmenu por id 
     * @param pk Objetto tipo RolesmenuPK
     * @return Objeto RolesmenuPK
     * @throws VuiModelexception
     */
    public CatRolesMenu findByPk(CatRolesMenuPK pk) throws ClinicaModelexception;
    
    /**
     * Remueve una opcion del menu
     * @param rolesid de tipo Long
     * @param menu de tipo Menu
     * @param added de tipo Boolean
     * @throws VuiModelexception
     */
    public void addOrRemoveOption(Long rolesid, CatMenu menu, Boolean added) throws ClinicaModelexception;
}
