/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.facades.catalogos;

import java.util.List;
import javax.ejb.Local;
import sv.com.cormaria.servicios.entidades.catalogos.CatRubro;
import sv.com.cormaria.servicios.exceptions.ClinicaModelexception;

/**
 *
 * @author Claudia
 */
@Local
public interface CatRubroFacadeLocal {

    CatRubro create(CatRubro catRubro) throws ClinicaModelexception;

    CatRubro edit(CatRubro catRubro) throws ClinicaModelexception;

    void remove(CatRubro catRubro) throws ClinicaModelexception;

    CatRubro find(Object id) throws ClinicaModelexception;

    List<CatRubro> findAll() throws ClinicaModelexception;

    List<CatRubro> findRange(int[] range) throws ClinicaModelexception;

    int count() throws ClinicaModelexception;
    
}
