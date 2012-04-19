/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.facades.catalogos;

import java.util.List;
import javax.ejb.Local;
import sv.com.cormaria.servicios.entidades.catalogos.CatSexo;
import sv.com.cormaria.servicios.exceptions.ClinicaModelexception;

/**
 *
 * @author Claudia
 */
@Local
public interface CatSexoFacadeLocal {

    void create(CatSexo catSexo) throws ClinicaModelexception;

    void edit(CatSexo catSexo) throws ClinicaModelexception;

    void remove(CatSexo catSexo) throws ClinicaModelexception;

    CatSexo find(Object id) throws ClinicaModelexception;

    List<CatSexo> findAll() throws ClinicaModelexception;

    List<CatSexo> findRange(int[] range) throws ClinicaModelexception;

    int count() throws ClinicaModelexception;
    
    public List<CatSexo> findActive() throws ClinicaModelexception;
    
}
