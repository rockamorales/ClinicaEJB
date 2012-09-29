/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.facades.catalogos;

import java.util.List;
import javax.ejb.Local;
import sv.com.cormaria.servicios.entidades.catalogos.CatTipoSalida;
import sv.com.cormaria.servicios.exceptions.ClinicaModelexception;


/**
 *
 * @author Claudia
 */
@Local
public interface CatTipoSalidaFacadeLocal {

    CatTipoSalida create(CatTipoSalida catTipoSalida) throws ClinicaModelexception;

    CatTipoSalida edit(CatTipoSalida catTipoSalida) throws ClinicaModelexception;

    void remove(CatTipoSalida catTipoSalida) throws ClinicaModelexception;

    CatTipoSalida find(Object id) throws ClinicaModelexception;

    List<CatTipoSalida> findAll() throws ClinicaModelexception;

    List<CatTipoSalida> findRange(int[] range) throws ClinicaModelexception;

    int count() throws ClinicaModelexception;
    
}
