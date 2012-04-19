/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.facades.catalogos;

import java.util.List;
import javax.ejb.Local;
import sv.com.cormaria.servicios.entidades.catalogos.CatTipoServiciosEnfermeria;
import sv.com.cormaria.servicios.exceptions.ClinicaModelexception;

/**
 *
 * @author Claudia
 */
@Local
public interface CatTipoServiciosEnfermeriaFacadeLocal {

    void create(CatTipoServiciosEnfermeria catTipoServiciosEnfermeria) throws ClinicaModelexception;

    void edit(CatTipoServiciosEnfermeria catTipoServiciosEnfermeria) throws ClinicaModelexception;

    void remove(CatTipoServiciosEnfermeria catTipoServiciosEnfermeria) throws ClinicaModelexception;

    CatTipoServiciosEnfermeria find(Object id) throws ClinicaModelexception;

    List<CatTipoServiciosEnfermeria> findAll() throws ClinicaModelexception;

    List<CatTipoServiciosEnfermeria> findRange(int[] range) throws ClinicaModelexception;

    int count() throws ClinicaModelexception;
    
}
