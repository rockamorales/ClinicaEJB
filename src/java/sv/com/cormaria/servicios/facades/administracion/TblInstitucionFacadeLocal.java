/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.facades.administracion;

import java.util.List;
import javax.ejb.Local;
import sv.com.cormaria.servicios.entidades.administracion.TblInstitucion;
import sv.com.cormaria.servicios.exceptions.ClinicaModelexception;

/**
 *
 * @author Mackk
 */
@Local
public interface TblInstitucionFacadeLocal {

    TblInstitucion create(TblInstitucion tblInstitucion) throws ClinicaModelexception;

    TblInstitucion edit(TblInstitucion tblInstitucion) throws ClinicaModelexception;

    void remove(TblInstitucion tblInstitucion) throws ClinicaModelexception;

    TblInstitucion find(Object id) throws ClinicaModelexception;

    List<TblInstitucion> findAll() throws ClinicaModelexception;

    List<TblInstitucion> findRange(int[] range) throws ClinicaModelexception;

    int count() throws ClinicaModelexception;
    
}
