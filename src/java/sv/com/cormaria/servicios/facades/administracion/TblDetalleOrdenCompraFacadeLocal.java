/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.facades.administracion;

import java.util.List;
import javax.ejb.Local;
import sv.com.cormaria.servicios.entidades.administracion.TblDetalleOrdenCompra;
import sv.com.cormaria.servicios.exceptions.ClinicaModelexception;

/**
 *
 * @author Mackk
 */
@Local
public interface TblDetalleOrdenCompraFacadeLocal {

    TblDetalleOrdenCompra create(TblDetalleOrdenCompra tblDetalleOrdenCompra) throws ClinicaModelexception;

    TblDetalleOrdenCompra edit(TblDetalleOrdenCompra tblDetalleOrdenCompra) throws ClinicaModelexception;

    void remove(TblDetalleOrdenCompra tblDetalleOrdenCompra) throws ClinicaModelexception;

    TblDetalleOrdenCompra find(Object id) throws ClinicaModelexception;

    List<TblDetalleOrdenCompra> findAll() throws ClinicaModelexception;

    List<TblDetalleOrdenCompra> findRange(int[] range) throws ClinicaModelexception;

    int count() throws ClinicaModelexception;
    
}
