/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.facades.catalogos;

import java.util.List;
import javax.ejb.Local;
import sv.com.cormaria.servicios.entidades.consultasmedicas.CatCategoriaExamenes;
import sv.com.cormaria.servicios.exceptions.ClinicaModelexception;

/**
 *
 * @author romorales
 */
@Local
public interface CatCategoriaExamenesFacadeLocal {
    public List<CatCategoriaExamenes> findAll() throws ClinicaModelexception;
    public CatCategoriaExamenes edit(CatCategoriaExamenes entity) throws ClinicaModelexception;
    public void remove(CatCategoriaExamenes entity) throws ClinicaModelexception;
    public CatCategoriaExamenes find(Object id) throws ClinicaModelexception;
}
