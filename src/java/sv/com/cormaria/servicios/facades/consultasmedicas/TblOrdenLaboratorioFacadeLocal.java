/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.facades.consultasmedicas;

import java.util.List;
import javax.ejb.Local;
import sv.com.cormaria.servicios.entidades.consultasmedicas.TblOrdenLaboratorio;
import sv.com.cormaria.servicios.exceptions.ClinicaModelexception;

/**
 *
 * @author Mackk
 */
@Local
public interface TblOrdenLaboratorioFacadeLocal {

    TblOrdenLaboratorio create(TblOrdenLaboratorio tblOrdenLaboratorio) throws ClinicaModelexception;

    TblOrdenLaboratorio edit(TblOrdenLaboratorio tblOrdenLaboratorio) throws ClinicaModelexception;

    void remove(TblOrdenLaboratorio tblOrdenLaboratorio) throws ClinicaModelexception;

    TblOrdenLaboratorio find(Object id) throws ClinicaModelexception;

    List<TblOrdenLaboratorio> findAll() throws ClinicaModelexception;

    List<TblOrdenLaboratorio> findRange(int[] range) throws ClinicaModelexception;

    int count() throws ClinicaModelexception;
    public TblOrdenLaboratorio findByNumConsulta(Integer numConsulta) throws ClinicaModelexception;

    
}
