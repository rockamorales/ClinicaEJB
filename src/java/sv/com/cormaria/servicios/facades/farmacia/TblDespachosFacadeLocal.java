/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.facades.farmacia;

import java.util.List;
import javax.ejb.Local;
import sv.com.cormaria.servicios.entidades.farmacia.TblDespachos;
import sv.com.cormaria.servicios.entidades.farmacia.TblDetalleDespacho;
import sv.com.cormaria.servicios.exceptions.ClinicaModelexception;

/**
 *
 * @author Mackk
 */
@Local
public interface TblDespachosFacadeLocal {
    TblDespachos create(TblDespachos tblIngresosProducto)  throws ClinicaModelexception;

    TblDespachos edit(TblDespachos tblIngresosProducto)  throws ClinicaModelexception;

    void remove(TblDespachos tblDespachos)  throws ClinicaModelexception;

    TblDespachos find(Object id) throws ClinicaModelexception;

    List<TblDespachos> findAll() throws ClinicaModelexception;

    List<TblDespachos> findRange(int[] range) throws ClinicaModelexception;

    int count() throws ClinicaModelexception;
    public TblDespachos findByNumReceta(Integer numReceta) throws ClinicaModelexception;
    
}
