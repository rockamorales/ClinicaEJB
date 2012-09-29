/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.facades.administracion;

import java.util.List;
import javax.ejb.Local;
import sv.com.cormaria.servicios.entidades.administracion.TblMedico;
import sv.com.cormaria.servicios.exceptions.ClinicaModelexception;

/**
 *
 * @author Mackk
 */
@Local
public interface TblMedicoFacadeLocal {

    TblMedico create(TblMedico tblMedico) throws ClinicaModelexception;

    TblMedico edit(TblMedico tblMedico) throws ClinicaModelexception;

    void remove(TblMedico tblMedico) throws ClinicaModelexception;

    TblMedico find(Object id) throws ClinicaModelexception;

    List<TblMedico> findAll() throws ClinicaModelexception;

    List<TblMedico> findRange(int[] range) throws ClinicaModelexception;

    int count() throws ClinicaModelexception;
    
    public void desactivar(TblMedico entity) throws ClinicaModelexception;    
    
}
