/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.facades.catalogos;

import java.util.List;
import javax.ejb.Local;
import sv.com.cormaria.servicios.entidades.catalogos.CatTipoServicio;
import sv.com.cormaria.servicios.exceptions.ClinicaModelexception;


/**
 *
 * @author Claudia
 */
@Local
public interface CatTipoServicioFacadeLocal {

    void create(CatTipoServicio catTipoServicio) throws ClinicaModelexception;

    void edit(CatTipoServicio catTipoServicio) throws ClinicaModelexception;

    void remove(CatTipoServicio catTipoServicio) throws ClinicaModelexception;

    CatTipoServicio find(Object id) throws ClinicaModelexception;

    List<CatTipoServicio> findAll() throws ClinicaModelexception;

    List<CatTipoServicio> findRange(int[] range) throws ClinicaModelexception;

    int count() throws ClinicaModelexception;
    
    public List<CatTipoServicio> findActive() throws ClinicaModelexception;    
    
}
