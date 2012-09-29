/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.facades.farmacia;

import java.util.List;
import javax.ejb.Local;
import sv.com.cormaria.servicios.entidades.farmacia.TblIngresosProducto;
import sv.com.cormaria.servicios.exceptions.ClinicaModelexception;

/**
 *
 * @author Mackk
 */
@Local
public interface TblIngresosProductoFacadeLocal {

    TblIngresosProducto create(TblIngresosProducto tblIngresosProducto)  throws ClinicaModelexception;

    TblIngresosProducto edit(TblIngresosProducto tblIngresosProducto)  throws ClinicaModelexception;

    void remove(TblIngresosProducto tblIngresosProducto)  throws ClinicaModelexception;

    TblIngresosProducto find(Object id)  throws ClinicaModelexception;

    List<TblIngresosProducto> findAll()  throws ClinicaModelexception;

    List<TblIngresosProducto> findRange(int[] range)  throws ClinicaModelexception;

    int count()  throws ClinicaModelexception;
    
}
