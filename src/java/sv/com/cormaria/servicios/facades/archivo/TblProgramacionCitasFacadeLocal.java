/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.facades.archivo;

import java.util.List;
import javax.ejb.Local;
import sv.com.cormaria.servicios.entidades.archivo.TblProgramacionCitas;
import sv.com.cormaria.servicios.exceptions.ClinicaModelexception;

/**
 *
 * @author Mackk
 */
@Local
public interface TblProgramacionCitasFacadeLocal {

    TblProgramacionCitas create(TblProgramacionCitas tblProgramacionCitas) throws ClinicaModelexception;

    TblProgramacionCitas edit(TblProgramacionCitas tblProgramacionCitas) throws ClinicaModelexception;

    void remove(TblProgramacionCitas tblProgramacionCitas) throws ClinicaModelexception;

    TblProgramacionCitas find(Object id) throws ClinicaModelexception;

    List<TblProgramacionCitas> findAll() throws ClinicaModelexception;

    List<TblProgramacionCitas> findRange(int[] range) throws ClinicaModelexception;

    int count() throws ClinicaModelexception;
    
}
