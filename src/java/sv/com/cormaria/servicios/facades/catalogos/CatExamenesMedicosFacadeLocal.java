/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.facades.catalogos;

import java.util.List;
import javax.ejb.Local;
import sv.com.cormaria.servicios.entidades.catalogos.CatExamenesMedicos;
import sv.com.cormaria.servicios.exceptions.ClinicaModelexception;

/**
 *
 * @author Claudia
 */
@Local
public interface CatExamenesMedicosFacadeLocal {

    void create(CatExamenesMedicos catExamenesMedicos) throws ClinicaModelexception;

    void edit(CatExamenesMedicos catExamenesMedicos) throws ClinicaModelexception;

    void remove(CatExamenesMedicos catExamenesMedicos) throws ClinicaModelexception;

    CatExamenesMedicos find(Object id) throws ClinicaModelexception;

    List<CatExamenesMedicos> findAll() throws ClinicaModelexception;

    List<CatExamenesMedicos> findRange(int[] range) throws ClinicaModelexception;

    int count() throws ClinicaModelexception;
    
}
