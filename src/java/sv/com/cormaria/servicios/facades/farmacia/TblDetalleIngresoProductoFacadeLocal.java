/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.facades.farmacia;

import java.util.List;
import javax.ejb.Local;
import sv.com.cormaria.servicios.entidades.farmacia.TblDetalleIngresoProducto;
import sv.com.cormaria.servicios.exceptions.ClinicaModelexception;

/**
 *
 * @author Mackk
 */
@Local
public interface TblDetalleIngresoProductoFacadeLocal {

    TblDetalleIngresoProducto create(TblDetalleIngresoProducto tblDetalleIngresoProducto)  throws ClinicaModelexception;

    TblDetalleIngresoProducto edit(TblDetalleIngresoProducto tblDetalleIngresoProducto)  throws ClinicaModelexception;

    void remove(TblDetalleIngresoProducto tblDetalleIngresoProducto)  throws ClinicaModelexception;

    TblDetalleIngresoProducto find(Object id)  throws ClinicaModelexception;

    List<TblDetalleIngresoProducto> findAll()  throws ClinicaModelexception;

    List<TblDetalleIngresoProducto> findRange(int[] range)  throws ClinicaModelexception;

    int count()  throws ClinicaModelexception;
    
}
