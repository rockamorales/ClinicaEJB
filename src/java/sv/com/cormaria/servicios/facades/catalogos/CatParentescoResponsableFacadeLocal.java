/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.facades.catalogos;

import java.util.List;
import javax.ejb.Local;
import sv.com.cormaria.servicios.entidades.catalogos.CatParentescoResponsable;
import sv.com.cormaria.servicios.exceptions.ClinicaModelexception;

/**
 *
 * @author Claudia
 */
@Local
public interface CatParentescoResponsableFacadeLocal {

    void create(CatParentescoResponsable catParentescoResponsable) throws ClinicaModelexception;

    void edit(CatParentescoResponsable catParentescoResponsable) throws ClinicaModelexception;

    void remove(CatParentescoResponsable catParentescoResponsable) throws ClinicaModelexception;

    CatParentescoResponsable find(Object id) throws ClinicaModelexception;

    List<CatParentescoResponsable> findAll() throws ClinicaModelexception;

    List<CatParentescoResponsable> findRange(int[] range) throws ClinicaModelexception;

    int count() throws ClinicaModelexception;
   
    public List<CatParentescoResponsable> findActive() throws ClinicaModelexception;
}
