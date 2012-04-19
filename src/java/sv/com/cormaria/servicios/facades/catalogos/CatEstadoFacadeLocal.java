/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.facades.catalogos;

import java.util.List;
import javax.ejb.Local;
import sv.com.cormaria.servicios.entidades.catalogos.CatEstado;
import sv.com.cormaria.servicios.exceptions.ClinicaModelexception;

/**
 *
 * @author Claudia
 */
@Local
public interface CatEstadoFacadeLocal {

    void create(CatEstado catEstado) throws ClinicaModelexception;

    void edit(CatEstado catEstado) throws ClinicaModelexception;

    void remove(CatEstado catEstado) throws ClinicaModelexception;

    CatEstado find(Object id) throws ClinicaModelexception;

    List<CatEstado> findAll() throws ClinicaModelexception;

    List<CatEstado> findRange(int[] range) throws ClinicaModelexception;

    int count() throws ClinicaModelexception;
    
}
