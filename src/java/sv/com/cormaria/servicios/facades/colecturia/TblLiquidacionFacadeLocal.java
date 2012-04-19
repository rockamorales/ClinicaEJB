/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.facades.colecturia;

import java.util.List;
import javax.ejb.Local;
import sv.com.cormaria.servicios.entidades.colecturia.TblLiquidacion;
import sv.com.cormaria.servicios.exceptions.ClinicaModelexception;

/**
 *
 * @author Mackk
 */
@Local
public interface TblLiquidacionFacadeLocal {

    void create(TblLiquidacion tblLiquidacion) throws ClinicaModelexception;

    void edit(TblLiquidacion tblLiquidacion) throws ClinicaModelexception;

    void remove(TblLiquidacion tblLiquidacion) throws ClinicaModelexception;

    TblLiquidacion find(Object id) throws ClinicaModelexception;

    List<TblLiquidacion> findAll() throws ClinicaModelexception;

    List<TblLiquidacion> findRange(int[] range) throws ClinicaModelexception;

    int count() throws ClinicaModelexception;
    
}
