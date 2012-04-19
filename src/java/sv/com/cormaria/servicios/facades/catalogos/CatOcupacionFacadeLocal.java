/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.facades.catalogos;

import java.util.List;
import javax.ejb.Local;
import sv.com.cormaria.servicios.entidades.catalogos.CatOcupacion;
import sv.com.cormaria.servicios.exceptions.ClinicaModelexception;

/**
 *
 * @author Claudia
 */
@Local
public interface CatOcupacionFacadeLocal {

    void create(CatOcupacion catOcupacion) throws ClinicaModelexception;

    void edit(CatOcupacion catOcupacion) throws ClinicaModelexception;

    void remove(CatOcupacion catOcupacion) throws ClinicaModelexception;

    CatOcupacion find(Object id) throws ClinicaModelexception;

    List<CatOcupacion> findAll() throws ClinicaModelexception;

    List<CatOcupacion> findRange(int[] range) throws ClinicaModelexception;

    int count() throws ClinicaModelexception;
    
    public List<CatOcupacion> findActive() throws ClinicaModelexception;
    
}
