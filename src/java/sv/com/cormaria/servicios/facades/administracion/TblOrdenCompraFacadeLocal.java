/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.facades.administracion;

import java.util.List;
import javax.ejb.Local;
import sv.com.cormaria.servicios.entidades.administracion.TblOrdenCompra;
import sv.com.cormaria.servicios.exceptions.ClinicaModelexception;

/**
 *
 * @author Mackk
 */
@Local
public interface TblOrdenCompraFacadeLocal {

    TblOrdenCompra create(TblOrdenCompra tblOrdenCompra) throws ClinicaModelexception;

    TblOrdenCompra edit(TblOrdenCompra tblOrdenCompra) throws ClinicaModelexception;

    void remove(TblOrdenCompra tblOrdenCompra) throws ClinicaModelexception;

    TblOrdenCompra find(Object id) throws ClinicaModelexception;

    List<TblOrdenCompra> findAll() throws ClinicaModelexception;

    List<TblOrdenCompra> findRange(int[] range) throws ClinicaModelexception;

    int count() throws ClinicaModelexception;
    
}
