/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.facades.archivo;

import java.util.List;
import javax.ejb.Local;
import sv.com.cormaria.servicios.criteria.ISearchable;
import sv.com.cormaria.servicios.entidades.archivo.TblExpedientePacientes;
import sv.com.cormaria.servicios.entidades.archivo.TblServiciosEnfermeria;
import sv.com.cormaria.servicios.exceptions.ClinicaModelexception;

/**
 *
 * @author Mackk
 */
@Local
public interface TblServiciosEnfermeriaFacadeLocal extends ISearchable<TblServiciosEnfermeria> {

    void create(TblServiciosEnfermeria tblServiciosEnfermeria) throws ClinicaModelexception;

    void edit(TblServiciosEnfermeria tblServiciosEnfermeria) throws ClinicaModelexception;

    void remove(TblServiciosEnfermeria tblServiciosEnfermeria) throws ClinicaModelexception;

    TblServiciosEnfermeria find(Object id) throws ClinicaModelexception;

    List<TblServiciosEnfermeria> findAll() throws ClinicaModelexception;

    List<TblServiciosEnfermeria> findRange(int[] range) throws ClinicaModelexception;

    int count() throws ClinicaModelexception;
    
    public TblServiciosEnfermeria crearServicio(TblServiciosEnfermeria servicio, TblExpedientePacientes expediente) throws ClinicaModelexception;
    
}
