/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.facades.security;

import java.util.List;
import javax.ejb.Local;
import sv.com.cormaria.servicios.entidades.security.TblUsuarios;
import sv.com.cormaria.servicios.exceptions.ClinicaModelexception;

/**
 *
 * @author Administrador
 */
@Local
public interface TblUsuariosSessionFacadeLocal {

    TblUsuarios cambiarContrasena(String codigoUsuario, String contrasenaAnt, String nuevaContrasena, String confContrasena) throws ClinicaModelexception;

    TblUsuarios create(TblUsuarios usuario) throws ClinicaModelexception;

    void deactive(TblUsuarios usuarios) throws ClinicaModelexception;

    void delete(TblUsuarios usuarios) throws ClinicaModelexception;

    List<TblUsuarios> findAllActiveUsers() throws ClinicaModelexception;

    List<TblUsuarios> findAllUsuarios() throws ClinicaModelexception;

    List<TblUsuarios> findAllUsuariosByEstado(Integer estado) throws ClinicaModelexception;

    TblUsuarios findByCodigoUsuario(String usuario) throws ClinicaModelexception;

    TblUsuarios findByCodigoUsuarioWithMenu(String usuario) throws ClinicaModelexception;

    TblUsuarios findUsuarioByPk(Long usuariosid) throws ClinicaModelexception;

    TblUsuarios findUsuarioFrmByPk(Long usuariosid) throws ClinicaModelexception;

    TblUsuarios restablecerContrasena(String codigousuario, String contrasena, String confirmacion) throws ClinicaModelexception;

    TblUsuarios update(TblUsuarios usuario) throws ClinicaModelexception;

    TblUsuarios updateAll(TblUsuarios usuario) throws ClinicaModelexception;
    
}
