/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.facades.farmacia;

import java.util.List;
import javax.ejb.Local;
import sv.com.cormaria.servicios.entidades.farmacia.TblAlquilerEquipo;
import sv.com.cormaria.servicios.exceptions.ClinicaModelexception;

/**
 *
 * @author Mackk
 */
@Local
public interface TblAlquilerEquipoFacadeLocal {

    void create(TblAlquilerEquipo tblAlquilerEquipo) throws ClinicaModelexception;

    void edit(TblAlquilerEquipo tblAlquilerEquipo) throws ClinicaModelexception;

    void remove(TblAlquilerEquipo tblAlquilerEquipo) throws ClinicaModelexception;

    TblAlquilerEquipo find(Object id) throws ClinicaModelexception;

    List<TblAlquilerEquipo> findAll() throws ClinicaModelexception;

    List<TblAlquilerEquipo> findRange(int[] range) throws ClinicaModelexception;

    int count() throws ClinicaModelexception;
    
}
