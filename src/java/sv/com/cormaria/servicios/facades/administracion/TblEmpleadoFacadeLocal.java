/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.facades.administracion;

import java.util.List;
import javax.ejb.Local;
import sv.com.cormaria.servicios.entidades.administracion.TblEmpleado;
import sv.com.cormaria.servicios.exceptions.ClinicaModelexception;

/**
 *
 * @author Mackk
 */
@Local
public interface TblEmpleadoFacadeLocal {

    TblEmpleado create(TblEmpleado tblEmpleado) throws ClinicaModelexception;

    TblEmpleado edit(TblEmpleado tblEmpleado) throws ClinicaModelexception;

    void remove(TblEmpleado tblEmpleado) throws ClinicaModelexception;

    TblEmpleado find(Object id) throws ClinicaModelexception;

    List<TblEmpleado> findAll() throws ClinicaModelexception;

    List<TblEmpleado> findRange(int[] range) throws ClinicaModelexception;

    int count() throws ClinicaModelexception;
    
    public List<TblEmpleado> findActive() throws ClinicaModelexception;
    
}
