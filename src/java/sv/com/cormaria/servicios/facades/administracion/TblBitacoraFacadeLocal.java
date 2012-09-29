/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.facades.administracion;

import java.util.List;
import javax.ejb.Local;
import sv.com.cormaria.servicios.entidades.administracion.TblBitacora;
import sv.com.cormaria.servicios.exceptions.ClinicaModelexception;

/**
 *
 * @author Mackk
 */
@Local
public interface TblBitacoraFacadeLocal {

    TblBitacora create(TblBitacora tblBitacora) throws ClinicaModelexception;

    TblBitacora edit(TblBitacora tblBitacora) throws ClinicaModelexception;

    void remove(TblBitacora tblBitacora) throws ClinicaModelexception;

    TblBitacora find(Object id) throws ClinicaModelexception;

    List<TblBitacora> findAll() throws ClinicaModelexception;

    List<TblBitacora> findRange(int[] range) throws ClinicaModelexception;

    int count() throws ClinicaModelexception;
    
}
