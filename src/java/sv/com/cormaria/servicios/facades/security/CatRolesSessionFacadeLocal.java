package sv.com.cormaria.servicios.facades.security;
import java.util.List;

import javax.ejb.Local;

import sv.com.cormaria.servicios.entidades.security.CatRoles;
import sv.com.cormaria.servicios.exceptions.ClinicaModelexception;

@Local
public interface CatRolesSessionFacadeLocal {
	
	/**
     * Obtiene todos los registros de Role almacenados 
     * @return List de Objetos Role
     * @throws VuiModelexception
     */
	public List<CatRoles> findAllActiveRoles() throws ClinicaModelexception;
    
    /**
     * Creacion de registros de Role
     * @param r de tipo Role
     * @return Role
     * @throws VuiModelexception
     */
    public CatRoles create(CatRoles r) throws ClinicaModelexception;
    
    /**
     * Actualizacion de registros de Role
     * @param r de tipo Role
     * @return Role
     * @throws VuiModelexception
     */
    public CatRoles update(CatRoles r) throws ClinicaModelexception;
   
    /**
     * Obtiene todos los registros de Role por id 
     * @param rolesid Id de Role de tipo Long
     * @return Objeto Role
     * @throws VuiModelexception
     */
    public CatRoles findByPk(Long rolesid) throws ClinicaModelexception;
    
    /**
     * Eliminacion de registros de Role
     * @param r de tipo Role
     * @throws VuiModelexception
     */
    public void delete(CatRoles r) throws ClinicaModelexception;
    
    /**
     * Busca el role por codigoexterno
     * @param codigoexterno Valor del codigo externo que se desea localizar
     * @return Role retorna la informacion del role encontrado
     * @throws VuiModelexception si falla la consulta se lanza esta excepcion
     */
    public CatRoles findByCodigoExterno(String codigoexterno) throws ClinicaModelexception;
}
