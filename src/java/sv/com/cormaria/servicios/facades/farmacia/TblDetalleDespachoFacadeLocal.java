/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.facades.farmacia;

import java.util.List;
import javax.ejb.Local;
import sv.com.cormaria.servicios.entidades.farmacia.TblDetalleDespacho;
import sv.com.cormaria.servicios.exceptions.ClinicaModelexception;

/**
 *
 * @author Mackk
 */
@Local
public interface TblDetalleDespachoFacadeLocal {

    TblDetalleDespacho create(TblDetalleDespacho tblDetalleDespacho)  throws ClinicaModelexception;

    TblDetalleDespacho edit(TblDetalleDespacho tblDetalleDespacho)  throws ClinicaModelexception;

    void remove(TblDetalleDespacho tblDetalleDespacho)  throws ClinicaModelexception;

    TblDetalleDespacho find(Object id)  throws ClinicaModelexception;

    List<TblDetalleDespacho> findAll()  throws ClinicaModelexception;

    List<TblDetalleDespacho> findRange(int[] range)  throws ClinicaModelexception;

    int count()  throws ClinicaModelexception;
    
}
