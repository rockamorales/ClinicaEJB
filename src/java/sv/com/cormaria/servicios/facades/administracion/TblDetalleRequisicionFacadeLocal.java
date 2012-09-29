/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.facades.administracion;

import java.util.List;
import javax.ejb.Local;
import sv.com.cormaria.servicios.entidades.administracion.TblDetalleRequisicion;
import sv.com.cormaria.servicios.exceptions.ClinicaModelexception;

/**
 *
 * @author Mackk
 */
@Local
public interface TblDetalleRequisicionFacadeLocal {

    TblDetalleRequisicion create(TblDetalleRequisicion tblDetalleRequisicion) throws ClinicaModelexception;

    TblDetalleRequisicion edit(TblDetalleRequisicion tblDetalleRequisicion) throws ClinicaModelexception;

    void remove(TblDetalleRequisicion tblDetalleRequisicion) throws ClinicaModelexception;

    TblDetalleRequisicion find(Object id) throws ClinicaModelexception;

    List<TblDetalleRequisicion> findAll() throws ClinicaModelexception;

    List<TblDetalleRequisicion> findRange(int[] range) throws ClinicaModelexception;

    int count() throws ClinicaModelexception;
    
}
