/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.facades.administracion;

import java.util.List;
import javax.ejb.Local;
import sv.com.cormaria.servicios.entidades.administracion.TblDetalleSolicitudDonacion;
import sv.com.cormaria.servicios.exceptions.ClinicaModelexception;

/**
 *
 * @author Mackk
 */
@Local
public interface TblDetalleSolicitudDonacionFacadeLocal {

    void create(TblDetalleSolicitudDonacion tblDetalleSolicitudDonacion) throws ClinicaModelexception;

    void edit(TblDetalleSolicitudDonacion tblDetalleSolicitudDonacion) throws ClinicaModelexception;

    void remove(TblDetalleSolicitudDonacion tblDetalleSolicitudDonacion) throws ClinicaModelexception;

    TblDetalleSolicitudDonacion find(Object id) throws ClinicaModelexception;

    List<TblDetalleSolicitudDonacion> findAll() throws ClinicaModelexception;

    List<TblDetalleSolicitudDonacion> findRange(int[] range) throws ClinicaModelexception;

    int count() throws ClinicaModelexception;
    
}
