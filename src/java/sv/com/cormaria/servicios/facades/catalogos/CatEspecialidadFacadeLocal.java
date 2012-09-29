/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.facades.catalogos;

import java.util.List;
import javax.ejb.Local;
import sv.com.cormaria.servicios.entidades.catalogos.CatEspecialidad;
import sv.com.cormaria.servicios.exceptions.ClinicaModelexception;

/**
 *
 * @author Claudia
 */
@Local
public interface CatEspecialidadFacadeLocal {

    CatEspecialidad create(CatEspecialidad catEspecialidad)throws ClinicaModelexception;

    CatEspecialidad edit(CatEspecialidad catEspecialidad)throws ClinicaModelexception;

    void remove(CatEspecialidad catEspecialidad)throws ClinicaModelexception;

    CatEspecialidad find(Object id)throws ClinicaModelexception;

    List<CatEspecialidad> findAll()throws ClinicaModelexception;

    List<CatEspecialidad> findRange(int[] range)throws ClinicaModelexception;

    int count()throws ClinicaModelexception;

    public List<CatEspecialidad> findActive() throws ClinicaModelexception;     
}
