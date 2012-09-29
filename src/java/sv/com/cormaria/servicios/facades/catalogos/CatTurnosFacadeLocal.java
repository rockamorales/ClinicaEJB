/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.facades.catalogos;

import java.util.List;
import javax.ejb.Local;
import sv.com.cormaria.servicios.entidades.catalogos.CatTurnos;
import sv.com.cormaria.servicios.exceptions.ClinicaModelexception;

/**
 *
 * @author Claudia
 */
@Local
public interface CatTurnosFacadeLocal {

    CatTurnos create(CatTurnos catTurnos) throws ClinicaModelexception;

    CatTurnos edit(CatTurnos catTurnos) throws ClinicaModelexception;

    void remove(CatTurnos catTurnos) throws ClinicaModelexception;

    CatTurnos find(Object id) throws ClinicaModelexception;

    List<CatTurnos> findAll() throws ClinicaModelexception;

    List<CatTurnos> findRange(int[] range) throws ClinicaModelexception;

    int count() throws ClinicaModelexception;
    
}
