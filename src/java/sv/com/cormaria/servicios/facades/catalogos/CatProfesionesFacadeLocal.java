/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.facades.catalogos;

import java.util.List;
import javax.ejb.Local;
import sv.com.cormaria.servicios.entidades.catalogos.CatProfesiones;
import sv.com.cormaria.servicios.exceptions.ClinicaModelexception;

/**
 *
 * @author Claudia
 */
@Local
public interface CatProfesionesFacadeLocal {

    void create(CatProfesiones catProfesiones) throws ClinicaModelexception;

    void edit(CatProfesiones catProfesiones) throws ClinicaModelexception;

    void remove(CatProfesiones catProfesiones) throws ClinicaModelexception;

    CatProfesiones find(Object id) throws ClinicaModelexception;

    List<CatProfesiones> findAll() throws ClinicaModelexception;

    List<CatProfesiones> findRange(int[] range) throws ClinicaModelexception;
    
    int count() throws ClinicaModelexception;
    
    public List<CatProfesiones> findActive() throws ClinicaModelexception; 
    
}
