/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.facades.administracion;

import java.util.List;
import javax.ejb.Local;
import sv.com.cormaria.servicios.entidades.administracion.TblDonacionEmitida;
import sv.com.cormaria.servicios.exceptions.ClinicaModelexception;

/**
 *
 * @author Mackk
 */
@Local
public interface TblDonacionEmitidaFacadeLocal {

    void create(TblDonacionEmitida tblDonacionEmitida) throws ClinicaModelexception;

    void edit(TblDonacionEmitida tblDonacionEmitida) throws ClinicaModelexception;

    void remove(TblDonacionEmitida tblDonacionEmitida) throws ClinicaModelexception;

    TblDonacionEmitida find(Object id) throws ClinicaModelexception;

    List<TblDonacionEmitida> findAll() throws ClinicaModelexception;

    List<TblDonacionEmitida> findRange(int[] range) throws ClinicaModelexception;

    int count() throws ClinicaModelexception;
    
}
