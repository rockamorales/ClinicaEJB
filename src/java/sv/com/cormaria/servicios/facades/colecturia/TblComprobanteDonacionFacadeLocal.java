/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.facades.colecturia;

import java.util.List;
import javax.ejb.Local;
import sv.com.cormaria.servicios.entidades.colecturia.TblComprobanteDonacion;
import sv.com.cormaria.servicios.exceptions.ClinicaModelexception;

/**
 *
 * @author Mackk
 */
@Local
public interface TblComprobanteDonacionFacadeLocal {

    void create(TblComprobanteDonacion tblComprobanteDonacion) throws ClinicaModelexception;

    void edit(TblComprobanteDonacion tblComprobanteDonacion) throws ClinicaModelexception;

    void remove(TblComprobanteDonacion tblComprobanteDonacion) throws ClinicaModelexception;

    TblComprobanteDonacion find(Object id) throws ClinicaModelexception;

    List<TblComprobanteDonacion> findAll() throws ClinicaModelexception;

    List<TblComprobanteDonacion> findRange(int[] range) throws ClinicaModelexception;

    int count() throws ClinicaModelexception;

    public void recibirPago(TblComprobanteDonacion comprobante) throws ClinicaModelexception;
}
