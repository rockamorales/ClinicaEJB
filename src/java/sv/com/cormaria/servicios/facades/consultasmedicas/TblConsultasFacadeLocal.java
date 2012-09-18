/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.facades.consultasmedicas;

import java.util.List;
import javax.ejb.Local;
import sv.com.cormaria.servicios.criteria.ISearchable;
import sv.com.cormaria.servicios.entidades.consultasmedicas.TblConsultas;
import sv.com.cormaria.servicios.exceptions.ClinicaModelexception;

/**
 *
 * @author Mackk
 */
@Local
public interface TblConsultasFacadeLocal extends ISearchable<TblConsultas> {

    void create(TblConsultas tblConsultas) throws ClinicaModelexception;

    void edit(TblConsultas tblConsultas) throws ClinicaModelexception;

    void remove(TblConsultas tblConsultas) throws ClinicaModelexception;

    TblConsultas find(Object id) throws ClinicaModelexception;

    List<TblConsultas> findAll() throws ClinicaModelexception;

    List<TblConsultas> findRange(int[] range) throws ClinicaModelexception;

    int count() throws ClinicaModelexception;
    
}
