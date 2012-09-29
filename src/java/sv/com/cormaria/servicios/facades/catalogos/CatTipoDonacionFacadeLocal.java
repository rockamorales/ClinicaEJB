/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.facades.catalogos;

import java.util.List;
import javax.ejb.Local;
import sv.com.cormaria.servicios.entidades.catalogos.CatTipoDonacion;
import sv.com.cormaria.servicios.exceptions.ClinicaModelexception;

/**
 *
 * @author Claudia
 */
@Local
public interface CatTipoDonacionFacadeLocal {

    CatTipoDonacion create(CatTipoDonacion catTipoDonacion) throws ClinicaModelexception;

    CatTipoDonacion edit(CatTipoDonacion catTipoDonacion) throws ClinicaModelexception;

    void remove(CatTipoDonacion catTipoDonacion) throws ClinicaModelexception;

    CatTipoDonacion find(Object id) throws ClinicaModelexception;

    List<CatTipoDonacion> findAll() throws ClinicaModelexception;

    List<CatTipoDonacion> findRange(int[] range) throws ClinicaModelexception;

    int count() throws ClinicaModelexception;
    
    public List<CatTipoDonacion> findActive() throws ClinicaModelexception;
    
}
