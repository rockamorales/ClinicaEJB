/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.facades.archivo;

import java.util.List;
import javax.ejb.Local;
import sv.com.cormaria.servicios.entidades.archivo.TblExpedientePacientes;
import sv.com.cormaria.servicios.entidades.colecturia.TblComprobanteDonacion;
import sv.com.cormaria.servicios.entidades.consultasmedicas.TblConsultas;
import sv.com.cormaria.servicios.exceptions.ClinicaModelexception;

/**
 *
 * @author Mackk
 */
@Local
public interface TblExpedientePacientesFacadeLocal {

    void create(TblExpedientePacientes tblExpedientePacientes) throws ClinicaModelexception;

    void edit(TblExpedientePacientes tblExpedientePacientes) throws ClinicaModelexception;

    void remove(TblExpedientePacientes tblExpedientePacientes) throws ClinicaModelexception;

    TblExpedientePacientes find(Object id) throws ClinicaModelexception;

    List<TblExpedientePacientes> findAll() throws ClinicaModelexception;

    List<TblExpedientePacientes> findRange(int[] range) throws ClinicaModelexception;

    int count() throws ClinicaModelexception;

    public void generarConsulta(TblConsultas consulta, TblExpedientePacientes expediente, Integer codEspecialidad) throws ClinicaModelexception;
}
