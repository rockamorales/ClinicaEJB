/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.facades.administracion;

import java.util.List;
import javax.ejb.Local;
import sv.com.cormaria.servicios.criteria.ISearchable;
import sv.com.cormaria.servicios.entidades.administracion.TblRequisiciones;
import sv.com.cormaria.servicios.exceptions.ClinicaModelexception;

/**
 *
 * @author Mackk
 */
@Local
public interface TblRequisicionesFacadeLocal extends ISearchable<TblRequisiciones> {

    TblRequisiciones create(TblRequisiciones tblRequisiciones) throws ClinicaModelexception;

    TblRequisiciones edit(TblRequisiciones tblRequisiciones) throws ClinicaModelexception;

    void remove(TblRequisiciones tblRequisiciones) throws ClinicaModelexception;

    TblRequisiciones find(Object id) throws ClinicaModelexception;

    List<TblRequisiciones> findAll() throws ClinicaModelexception;

    List<TblRequisiciones> findRange(int[] range) throws ClinicaModelexception;

    int count() throws ClinicaModelexception;
    
}
