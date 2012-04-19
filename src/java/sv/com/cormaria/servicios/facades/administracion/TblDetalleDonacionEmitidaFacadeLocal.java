/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.facades.administracion;

import java.util.List;
import javax.ejb.Local;
import sv.com.cormaria.servicios.entidades.administracion.TblDetalleDonacionEmitida;
import sv.com.cormaria.servicios.exceptions.ClinicaModelexception;

/**
 *
 * @author Mackk
 */
@Local
public interface TblDetalleDonacionEmitidaFacadeLocal {

    void create(TblDetalleDonacionEmitida tblDetalleDonacionEmitida) throws ClinicaModelexception;

    void edit(TblDetalleDonacionEmitida tblDetalleDonacionEmitida) throws ClinicaModelexception;

    void remove(TblDetalleDonacionEmitida tblDetalleDonacionEmitida) throws ClinicaModelexception;

    TblDetalleDonacionEmitida find(Object id) throws ClinicaModelexception;

    List<TblDetalleDonacionEmitida> findAll() throws ClinicaModelexception;

    List<TblDetalleDonacionEmitida> findRange(int[] range) throws ClinicaModelexception;

    int count() throws ClinicaModelexception;
    
}
