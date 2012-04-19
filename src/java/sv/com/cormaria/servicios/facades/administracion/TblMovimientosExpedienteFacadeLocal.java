/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.facades.administracion;

import java.util.List;
import javax.ejb.Local;
import sv.com.cormaria.servicios.entidades.administracion.TblMovimientosExpediente;
import sv.com.cormaria.servicios.exceptions.ClinicaModelexception;

/**
 *
 * @author Mackk
 */
@Local
public interface TblMovimientosExpedienteFacadeLocal {

    void create(TblMovimientosExpediente tblMovimientosExpediente) throws ClinicaModelexception;

    void edit(TblMovimientosExpediente tblMovimientosExpediente) throws ClinicaModelexception;

    void remove(TblMovimientosExpediente tblMovimientosExpediente) throws ClinicaModelexception;

    TblMovimientosExpediente find(Object id) throws ClinicaModelexception;

    List<TblMovimientosExpediente> findAll() throws ClinicaModelexception;

    List<TblMovimientosExpediente> findRange(int[] range) throws ClinicaModelexception;

    int count() throws ClinicaModelexception;
    
}
