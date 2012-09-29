/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.facades.catalogos;

import java.util.List;
import javax.ejb.Local;
import sv.com.cormaria.servicios.entidades.catalogos.CatTipoConsulta;
import sv.com.cormaria.servicios.exceptions.ClinicaModelexception;

/**
 *
 * @author Claudia
 */
@Local
public interface CatTipoConsultaFacadeLocal {

    CatTipoConsulta create(CatTipoConsulta catTipoConsulta) throws ClinicaModelexception;

    CatTipoConsulta edit(CatTipoConsulta catTipoConsulta) throws ClinicaModelexception;

    void remove(CatTipoConsulta catTipoConsulta) throws ClinicaModelexception;

    CatTipoConsulta find(Object id) throws ClinicaModelexception;

    List<CatTipoConsulta> findAll() throws ClinicaModelexception;

    List<CatTipoConsulta> findRange(int[] range) throws ClinicaModelexception;

    int count() throws ClinicaModelexception;
    
    public List<CatTipoConsulta> findActive() throws ClinicaModelexception;
}
