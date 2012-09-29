/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.facades.administracion;

import java.util.List;
import javax.ejb.Local;
import sv.com.cormaria.servicios.entidades.administracion.TblSolicitudDonacion;
import sv.com.cormaria.servicios.exceptions.ClinicaModelexception;

/**
 *
 * @author Mackk
 */
@Local
public interface TblSolicitudDonacionFacadeLocal {

    TblSolicitudDonacion create(TblSolicitudDonacion tblSolicitudDonacion) throws ClinicaModelexception;

    TblSolicitudDonacion edit(TblSolicitudDonacion tblSolicitudDonacion) throws ClinicaModelexception;

    void remove(TblSolicitudDonacion tblSolicitudDonacion) throws ClinicaModelexception;

    TblSolicitudDonacion find(Object id) throws ClinicaModelexception;

    List<TblSolicitudDonacion> findAll() throws ClinicaModelexception;

    List<TblSolicitudDonacion> findRange(int[] range) throws ClinicaModelexception;

    int count() throws ClinicaModelexception;
    
}
