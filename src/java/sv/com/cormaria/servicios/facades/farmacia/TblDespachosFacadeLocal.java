/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.facades.farmacia;

import java.util.List;
import javax.ejb.Local;
import sv.com.cormaria.servicios.entidades.farmacia.TblDespachos;
import sv.com.cormaria.servicios.exceptions.ClinicaModelexception;

/**
 *
 * @author Mackk
 */
@Local
public interface TblDespachosFacadeLocal {

    void create(TblDespachos tblDespachos) throws ClinicaModelexception;

    void edit(TblDespachos tblDespachos) throws ClinicaModelexception;

    void remove(TblDespachos tblDespachos) throws ClinicaModelexception;

    TblDespachos find(Object id) throws ClinicaModelexception;

    List<TblDespachos> findAll() throws ClinicaModelexception;

    List<TblDespachos> findRange(int[] range) throws ClinicaModelexception;

    int count() throws ClinicaModelexception;
    
}
