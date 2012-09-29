/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.facades.colecturia;

import java.util.List;
import javax.ejb.Local;
import sv.com.cormaria.servicios.entidades.colecturia.TblDetalleComprobanteDonacion;
import sv.com.cormaria.servicios.exceptions.ClinicaModelexception;

/**
 *
 * @author Mackk
 */
@Local
public interface TblDetalleComprobanteDonacionFacadeLocal {

    TblDetalleComprobanteDonacion create(TblDetalleComprobanteDonacion tblDetalleComprobanteDonacion) throws ClinicaModelexception;

    TblDetalleComprobanteDonacion edit(TblDetalleComprobanteDonacion tblDetalleComprobanteDonacion) throws ClinicaModelexception;

    void remove(TblDetalleComprobanteDonacion tblDetalleComprobanteDonacion) throws ClinicaModelexception;

    TblDetalleComprobanteDonacion find(Object id) throws ClinicaModelexception;

    List<TblDetalleComprobanteDonacion> findAll() throws ClinicaModelexception;

    List<TblDetalleComprobanteDonacion> findRange(int[] range) throws ClinicaModelexception;

    int count() throws ClinicaModelexception;
    
    public List<TblDetalleComprobanteDonacion> findByComprobanteDonacion(Integer numComprobanteDonacion) throws ClinicaModelexception;
    
}
