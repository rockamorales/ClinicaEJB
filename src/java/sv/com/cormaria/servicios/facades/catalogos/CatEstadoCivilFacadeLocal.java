/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.facades.catalogos;

import java.util.List;
import javax.ejb.Local;
import sv.com.cormaria.servicios.entidades.catalogos.CatEstadoCivil;
import sv.com.cormaria.servicios.exceptions.ClinicaModelexception;

/**
 *
 * @author Claudia
 */
@Local
public interface CatEstadoCivilFacadeLocal {

    void create(CatEstadoCivil catEstadoCivil) throws ClinicaModelexception;

    void edit(CatEstadoCivil catEstadoCivil) throws ClinicaModelexception;

    void remove(CatEstadoCivil catEstadoCivil) throws ClinicaModelexception;

    CatEstadoCivil find(Object id) throws ClinicaModelexception;

    List<CatEstadoCivil> findAll() throws ClinicaModelexception;

    List<CatEstadoCivil> findRange(int[] range) throws ClinicaModelexception;

    int count() throws ClinicaModelexception;
    
    public List<CatEstadoCivil> findActive() throws ClinicaModelexception;
    
}
