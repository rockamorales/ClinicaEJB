/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.facades.catalogos;

import java.util.List;
import javax.ejb.Local;
import sv.com.cormaria.servicios.entidades.catalogos.CatConsultorio;
import sv.com.cormaria.servicios.exceptions.ClinicaModelexception;

/**
 *
 * @author Claudia
 */
@Local
public interface CatConsultorioFacadeLocal {

    void create(CatConsultorio catConsultorio) throws ClinicaModelexception;

    void edit(CatConsultorio catConsultorio) throws ClinicaModelexception;

    void remove(CatConsultorio catConsultorio) throws ClinicaModelexception;

    CatConsultorio find(Object id) throws ClinicaModelexception;

    List<CatConsultorio> findAll() throws ClinicaModelexception;

    List<CatConsultorio> findRange(int[] range) throws ClinicaModelexception;

    int count() throws ClinicaModelexception;
    
}
