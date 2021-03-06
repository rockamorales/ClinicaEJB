/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.facades.consultasmedicas;

import java.util.List;
import javax.ejb.Local;
import sv.com.cormaria.servicios.entidades.consultasmedicas.TblRecetaMedica;
import sv.com.cormaria.servicios.exceptions.ClinicaModelexception;

/**
 *
 * @author Mackk
 */
@Local
public interface TblRecetaMedicaFacadeLocal {

    TblRecetaMedica create(TblRecetaMedica tblRecetaMedica) throws ClinicaModelexception;

    TblRecetaMedica edit(TblRecetaMedica tblRecetaMedica) throws ClinicaModelexception;

    void remove(TblRecetaMedica tblRecetaMedica) throws ClinicaModelexception;

    TblRecetaMedica find(Object id) throws ClinicaModelexception;

    List<TblRecetaMedica> findAll() throws ClinicaModelexception;

    List<TblRecetaMedica> findRange(int[] range) throws ClinicaModelexception;

    int count() throws ClinicaModelexception;
    
    public TblRecetaMedica findByNumConsulta(Integer numConsulta) throws ClinicaModelexception;
    
}
