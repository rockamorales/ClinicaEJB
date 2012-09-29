/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.facades.farmacia;

import java.util.List;
import javax.ejb.Local;
import sv.com.cormaria.servicios.entidades.farmacia.TblDetalleTrasladoProductos;
import sv.com.cormaria.servicios.exceptions.ClinicaModelexception;

/**
 *
 * @author Mackk
 */
@Local
public interface TblDetalleTrasladoProductosFacadeLocal {

    TblDetalleTrasladoProductos create(TblDetalleTrasladoProductos tblDetalleTrasladoProductos)  throws ClinicaModelexception;

    TblDetalleTrasladoProductos edit(TblDetalleTrasladoProductos tblDetalleTrasladoProductos)  throws ClinicaModelexception;

    void remove(TblDetalleTrasladoProductos tblDetalleTrasladoProductos)  throws ClinicaModelexception;

    TblDetalleTrasladoProductos find(Object id)  throws ClinicaModelexception;

    List<TblDetalleTrasladoProductos> findAll()  throws ClinicaModelexception;

    List<TblDetalleTrasladoProductos> findRange(int[] range)  throws ClinicaModelexception;

    int count()  throws ClinicaModelexception;
    
}
