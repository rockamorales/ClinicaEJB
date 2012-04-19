/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.facades.catalogos;

import java.util.List;
import javax.ejb.Local;
import sv.com.cormaria.servicios.entidades.catalogos.CatAreas;
import sv.com.cormaria.servicios.exceptions.ClinicaModelexception;

/**
 *
 * @author Claudia
 */
@Local
public interface CatAreasFacadeLocal {

    void create(CatAreas catAreas) throws ClinicaModelexception;

    void edit(CatAreas catAreas) throws ClinicaModelexception;

    void remove(CatAreas catAreas) throws ClinicaModelexception;

    CatAreas find(Object id) throws ClinicaModelexception;

    List<CatAreas> findAll() throws ClinicaModelexception;

    List<CatAreas> findRange(int[] range) throws ClinicaModelexception;

    int count() throws ClinicaModelexception;
    
    public List<CatAreas> findActive() throws ClinicaModelexception;
}
