/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.facades.farmacia;

import java.util.List;
import javax.ejb.Local;
import sv.com.cormaria.servicios.entidades.farmacia.TblDetalleAlquilerEquipo;
import sv.com.cormaria.servicios.exceptions.ClinicaModelexception;

/**
 *
 * @author Mackk
 */
@Local
public interface TblDetalleAlquilerEquipoFacadeLocal {

    TblDetalleAlquilerEquipo create(TblDetalleAlquilerEquipo tblDetalleAlquilerEquipo)  throws ClinicaModelexception;

    TblDetalleAlquilerEquipo edit(TblDetalleAlquilerEquipo tblDetalleAlquilerEquipo)  throws ClinicaModelexception;

    void remove(TblDetalleAlquilerEquipo tblDetalleAlquilerEquipo)  throws ClinicaModelexception;

    TblDetalleAlquilerEquipo find(Object id)  throws ClinicaModelexception;

    List<TblDetalleAlquilerEquipo> findAll()  throws ClinicaModelexception;

    List<TblDetalleAlquilerEquipo> findRange(int[] range)  throws ClinicaModelexception;

    int count()  throws ClinicaModelexception;

    public List<TblDetalleAlquilerEquipo> findByNumSolAlquiler(Integer numSolAlquiler) throws ClinicaModelexception;
}
