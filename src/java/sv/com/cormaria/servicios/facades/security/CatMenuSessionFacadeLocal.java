package sv.com.cormaria.servicios.facades.security;
import java.util.List;

import javax.ejb.Local;
import sv.com.cormaria.servicios.exceptions.ClinicaModelexception;
import sv.com.cormaria.servicios.entidades.security.CatMenu;

@Local
public interface CatMenuSessionFacadeLocal {
	
    /**
     * Obtiene todos los registros de Menu almacenados no publico por usuario
     * @param userid Id de Usuario de tipo String
     * @return List de Objetos Menu
     * @throws ClinicaModelexception
     */
	public List<CatMenu> findActivePublicMenuByUserId(String userid) throws ClinicaModelexception;
	
	/**
     * Obtiene todos los registros de Menu almacenados no publico por rol
     * @param rolesid Id de Rol de tipo Long
     * @return List de Objetos Menu
     * @throws ClinicaModelexception
     */
	public List<CatMenu> findAllPublicMenu(Long rolesid) throws ClinicaModelexception;
	
	/**
     * Obtiene todos los registros de Menu almacenados no publico por codigomenupadre
     * @param codigomenupadre Id de Rol de tipo Long
     * @return List de Objetos Menu
     * @throws ClinicaModelexception
     */
	public List<CatMenu> findByParent(Long codigomenupadre) throws ClinicaModelexception;
	
	/**
     * Obtiene todos los registros de Menu almacenados 
     * @return List de Objetos Menu
     * @throws ClinicaModelexception
     */
    public List<CatMenu> findAllMenu() throws ClinicaModelexception;
    
    /**
     * Creacion de registros de Menu
     * @param menu de tipo Menu
     * @return Menu
     * @throws ClinicaModelexception
     */
    public CatMenu create(CatMenu menu) throws ClinicaModelexception;
    
    /**
     * Actualizacion de registros de Menu
     * @param menu de tipo Menu
     * @return Menu
     * @throws ClinicaModelexception
     */
    public CatMenu update(CatMenu menu) throws ClinicaModelexception;    
   
    /**
     * Obtiene todos los registros de Menu por id de menu
     * @param codigomenu Id de Menu de tipo Long
     * @return Objeto Menu
     * @throws ClinicaModelexception
     */
    public CatMenu findByPk(Long codigomenu) throws ClinicaModelexception;
    
    /**
     * Eliminacion de registros de Menu
     * @param codigomenu de tipo Long
     * @throws ClinicaModelexception
     */
    public void delete(Long codigomenu) throws ClinicaModelexception;
}
