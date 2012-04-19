/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.facades.catalogos;

import java.util.List;
import javax.ejb.Local;
import sv.com.cormaria.servicios.entidades.catalogos.CatTipoDonante;
import sv.com.cormaria.servicios.exceptions.ClinicaModelexception;

/**
 *
 * @author Claudia
 */
@Local
public interface CatTipoDonanteFacadeLocal {

    void create(CatTipoDonante catTipoDonante) throws ClinicaModelexception;

    void edit(CatTipoDonante catTipoDonante) throws ClinicaModelexception;

    void remove(CatTipoDonante catTipoDonante) throws ClinicaModelexception;

    CatTipoDonante find(Object id) throws ClinicaModelexception;

    List<CatTipoDonante> findAll() throws ClinicaModelexception;

    List<CatTipoDonante> findRange(int[] range) throws ClinicaModelexception;

    int count() throws ClinicaModelexception;
    
    public List<CatTipoDonante> findActive() throws ClinicaModelexception;
    
}
