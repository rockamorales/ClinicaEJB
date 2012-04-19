package sv.com.cormaria.servicios.facades.security;
import java.util.List;

import javax.ejb.Local;
import sv.com.cormaria.servicios.entidades.security.CatRolesUsuario;
import sv.com.cormaria.servicios.entidades.security.CatRolesUsuarioPK;
import sv.com.cormaria.servicios.exceptions.ClinicaModelexception;


@Local
public interface CatRolesUsuarioSessionFacadeLocal {
	/**
     * Obtiene todos los registros de Rolesusuario almacenados por usuario
     * @param usuariosid de tipo Long
     * @return List de Objetos Rolesusuario
     * @throws VuiModelexception
     */
    public List<CatRolesUsuario> findAllRolesByUser(Long usuariosid) throws ClinicaModelexception;
	 
	/**
     * Creacion de registros de Rolesusuario
     * @param r de tipo Rolesusuario
     * @return Rolesusuario
     * @throws VuiModelexception
     */
	public CatRolesUsuario create(CatRolesUsuario r) throws ClinicaModelexception;
	
	/**
     * Actualizacion de registros de Rolesusuario
     * @param r de tipo Rolesusuario
     * @return Rolesusuario
     * @throws VuiModelexception
     */
	public CatRolesUsuario update(CatRolesUsuario r) throws ClinicaModelexception;
    
    /**
     * Obtiene todos los registros de Rolesusuario almacenados por RolesusuarioPK
     * @param pk de tipo RolesusuarioPK
     * @return List de Objetos Rolesusuario
     * @throws VuiModelexception
     */
    public CatRolesUsuario findByPk(CatRolesUsuarioPK pk) throws ClinicaModelexception;
    
    /**
     * Eliminacion de registros de Rolesusuario
     * @param r de tipo Rolesusuario
     * @throws VuiModelexception
     */
    public void delete(CatRolesUsuario r) throws ClinicaModelexception;
}
