/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.facades.catalogos;

import java.util.List;
import javax.ejb.Local;
import sv.com.cormaria.servicios.entidades.catalogos.CatTipoTransaccion;
import sv.com.cormaria.servicios.exceptions.ClinicaModelexception;

/**
 *
 * @author Claudia
 */
@Local
public interface CatTipoTransaccionFacadeLocal {

    CatTipoTransaccion create(CatTipoTransaccion catTipoTransaccion) throws ClinicaModelexception;

    CatTipoTransaccion edit(CatTipoTransaccion catTipoTransaccion) throws ClinicaModelexception;

    void remove(CatTipoTransaccion catTipoTransaccion) throws ClinicaModelexception;

    CatTipoTransaccion find(Object id) throws ClinicaModelexception;

    List<CatTipoTransaccion> findAll() throws ClinicaModelexception;

    List<CatTipoTransaccion> findRange(int[] range) throws ClinicaModelexception;

    int count() throws ClinicaModelexception;
    
}
