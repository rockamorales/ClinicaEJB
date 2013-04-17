/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.facades.consultasmedicas;

import java.util.List;
import javax.ejb.Local;
import sv.com.cormaria.servicios.entidades.consultasmedicas.TblDetalleReceta;
import sv.com.cormaria.servicios.exceptions.ClinicaModelexception;

/**
 *
 * @author Mackk
 */
@Local
public interface TblDetalleRecetaFacadeLocal {

    TblDetalleReceta create(TblDetalleReceta tblDetalleReceta) throws ClinicaModelexception;

    TblDetalleReceta edit(TblDetalleReceta tblDetalleReceta) throws ClinicaModelexception;

    void remove(TblDetalleReceta tblDetalleReceta) throws ClinicaModelexception;

    TblDetalleReceta find(Object id) throws ClinicaModelexception;

    List<TblDetalleReceta> findAll() throws ClinicaModelexception;

    List<TblDetalleReceta> findRange(int[] range) throws ClinicaModelexception;

    int count() throws ClinicaModelexception;

    public List<TblDetalleReceta> findByNumReceta(Integer numReceta) throws ClinicaModelexception;
    public List<TblDetalleReceta> findNoContribuibleByNumReceta(Integer numReceta) throws ClinicaModelexception;
    public List<TblDetalleReceta> findContribuibleByNumReceta(Integer numReceta) throws ClinicaModelexception;    
}
