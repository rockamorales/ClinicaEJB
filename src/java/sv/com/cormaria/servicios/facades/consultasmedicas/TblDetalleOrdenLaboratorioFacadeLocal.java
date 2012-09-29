/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.facades.consultasmedicas;

import java.util.List;
import javax.ejb.Local;
import sv.com.cormaria.servicios.entidades.consultasmedicas.TblDetalleOrdenLaboratorio;
import sv.com.cormaria.servicios.exceptions.ClinicaModelexception;

/**
 *
 * @author Mackk
 */
@Local
public interface TblDetalleOrdenLaboratorioFacadeLocal {

    TblDetalleOrdenLaboratorio create(TblDetalleOrdenLaboratorio tblDetalleOrdenLaboratorio) throws ClinicaModelexception;

    TblDetalleOrdenLaboratorio edit(TblDetalleOrdenLaboratorio tblDetalleOrdenLaboratorio) throws ClinicaModelexception;

    void remove(TblDetalleOrdenLaboratorio tblDetalleOrdenLaboratorio) throws ClinicaModelexception;

    TblDetalleOrdenLaboratorio find(Object id) throws ClinicaModelexception;

    List<TblDetalleOrdenLaboratorio> findAll() throws ClinicaModelexception;

    List<TblDetalleOrdenLaboratorio> findRange(int[] range) throws ClinicaModelexception;

    int count() throws ClinicaModelexception;
    
}
