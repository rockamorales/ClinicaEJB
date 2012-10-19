/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.facades.administracion;

import java.util.List;
import java.util.Map;
import javax.ejb.Local;
import javax.persistence.Query;
import sv.com.cormaria.servicios.criteria.SearchCriteria;
import sv.com.cormaria.servicios.entidades.administracion.TblRequisiciones;
import sv.com.cormaria.servicios.exceptions.ClinicaModelexception;

/**
 *
 * @author Mackk
 */
@Local
public interface TblRequisicionesFacadeLocal {

    TblRequisiciones create(TblRequisiciones tblRequisiciones) throws ClinicaModelexception;

    TblRequisiciones edit(TblRequisiciones tblRequisiciones) throws ClinicaModelexception;

    void remove(TblRequisiciones tblRequisiciones) throws ClinicaModelexception;

    TblRequisiciones find(Object id) throws ClinicaModelexception;

    List<TblRequisiciones> findAll() throws ClinicaModelexception;

    List<TblRequisiciones> findRange(int[] range) throws ClinicaModelexception;

    int count() throws ClinicaModelexception;
    
    public List<TblRequisiciones> find(SearchCriteria sc, int firstRow, int maxResults);
    public int count(SearchCriteria sc);    
}
