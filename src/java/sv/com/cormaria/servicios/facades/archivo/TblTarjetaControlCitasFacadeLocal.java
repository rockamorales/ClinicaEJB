/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.facades.archivo;

import java.util.List;
import javax.ejb.Local;
import sv.com.cormaria.servicios.entidades.archivo.TblTarjetaControlCitas;
import sv.com.cormaria.servicios.exceptions.ClinicaModelexception;

/**
 *
 * @author Mackk
 */
@Local
public interface TblTarjetaControlCitasFacadeLocal {

    TblTarjetaControlCitas create(TblTarjetaControlCitas tblTarjetaControlCitas) throws ClinicaModelexception;

    TblTarjetaControlCitas edit(TblTarjetaControlCitas tblTarjetaControlCitas) throws ClinicaModelexception;

    void remove(TblTarjetaControlCitas tblTarjetaControlCitas) throws ClinicaModelexception;

    TblTarjetaControlCitas find(Object id) throws ClinicaModelexception;

    List<TblTarjetaControlCitas> findAll() throws ClinicaModelexception;

    List<TblTarjetaControlCitas> findRange(int[] range) throws ClinicaModelexception;

    int count() throws ClinicaModelexception;
    
    public List<TblTarjetaControlCitas> findByNumExpediente(Integer numExpediente) throws ClinicaModelexception;
    
    public List<TblTarjetaControlCitas> findActiveByNumExpediente(Integer numExpediente) throws ClinicaModelexception;

    public List<TblTarjetaControlCitas> findNoPagadoByNumExpediente(Integer numExpediente) throws ClinicaModelexception;
}
