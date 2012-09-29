/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.facades.administracion;

import java.util.List;
import javax.ejb.Local;
import sv.com.cormaria.servicios.entidades.administracion.TblTrasladosProductos;
import sv.com.cormaria.servicios.exceptions.ClinicaModelexception;

/**
 *
 * @author Mackk
 */
@Local
public interface TblTrasladosProductosFacadeLocal {

    TblTrasladosProductos create(TblTrasladosProductos tblTrasladosProductos) throws ClinicaModelexception;

    TblTrasladosProductos edit(TblTrasladosProductos tblTrasladosProductos) throws ClinicaModelexception;

    void remove(TblTrasladosProductos tblTrasladosProductos) throws ClinicaModelexception;

    TblTrasladosProductos find(Object id) throws ClinicaModelexception;

    List<TblTrasladosProductos> findAll() throws ClinicaModelexception;

    List<TblTrasladosProductos> findRange(int[] range) throws ClinicaModelexception;

    int count() throws ClinicaModelexception;
    
}
