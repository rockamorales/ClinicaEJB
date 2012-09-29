/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.facades.colecturia;

import java.util.List;
import javax.ejb.Local;
import sv.com.cormaria.servicios.entidades.colecturia.TblDetalleCheques;
import sv.com.cormaria.servicios.exceptions.ClinicaModelexception;

/**
 *
 * @author Mackk
 */
@Local
public interface TblDetalleChequesFacadeLocal {

    TblDetalleCheques create(TblDetalleCheques tblDetalleCheques) throws ClinicaModelexception;

    TblDetalleCheques edit(TblDetalleCheques tblDetalleCheques) throws ClinicaModelexception;

    void remove(TblDetalleCheques tblDetalleCheques) throws ClinicaModelexception;

    TblDetalleCheques find(Object id) throws ClinicaModelexception;

    List<TblDetalleCheques> findAll() throws ClinicaModelexception;

    List<TblDetalleCheques> findRange(int[] range) throws ClinicaModelexception;

    int count() throws ClinicaModelexception;
    
}
