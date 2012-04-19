/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.facades.archivo;

import java.util.List;
import javax.ejb.Local;
import sv.com.cormaria.servicios.entidades.archivo.TblProgramacionMedicos;
import sv.com.cormaria.servicios.exceptions.ClinicaModelexception;

/**
 *
 * @author Mackk
 */
@Local
public interface TblProgramacionMedicosFacadeLocal {

    void create(TblProgramacionMedicos tblProgramacionMedicos) throws ClinicaModelexception;

    void edit(TblProgramacionMedicos tblProgramacionMedicos) throws ClinicaModelexception;

    void remove(TblProgramacionMedicos tblProgramacionMedicos) throws ClinicaModelexception;

    TblProgramacionMedicos find(Object id) throws ClinicaModelexception;

    List<TblProgramacionMedicos> findAll() throws ClinicaModelexception;

    List<TblProgramacionMedicos> findRange(int[] range) throws ClinicaModelexception;

    int count() throws ClinicaModelexception;
    
}
