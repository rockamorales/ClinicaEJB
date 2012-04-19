/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.facades.catalogos;

import java.util.List;
import javax.ejb.Local;
import sv.com.cormaria.servicios.entidades.catalogos.CatBancos;
import sv.com.cormaria.servicios.exceptions.ClinicaModelexception;

/**
 *
 * @author Claudia
 */
@Local
public interface CatBancosFacadeLocal {

    void create(CatBancos catBancos) throws ClinicaModelexception;

    void edit(CatBancos catBancos)  throws ClinicaModelexception;

    void remove(CatBancos catBancos) throws ClinicaModelexception;

    CatBancos find(Object id) throws ClinicaModelexception;

    List<CatBancos> findAll() throws ClinicaModelexception;

    List<CatBancos> findRange(int[] range) throws ClinicaModelexception;

    int count() throws ClinicaModelexception;
    
    public List<CatBancos> findActive() throws ClinicaModelexception;
    
}
