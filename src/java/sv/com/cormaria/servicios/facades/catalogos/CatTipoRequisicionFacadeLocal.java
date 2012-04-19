/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.facades.catalogos;

import java.util.List;
import javax.ejb.Local;
import sv.com.cormaria.servicios.entidades.catalogos.CatTipoRequisicion;
import sv.com.cormaria.servicios.exceptions.ClinicaModelexception;


/**
 *
 * @author Claudia
 */
@Local
public interface CatTipoRequisicionFacadeLocal {

    void create(CatTipoRequisicion catTipoRequisicion) throws ClinicaModelexception;

    void edit(CatTipoRequisicion catTipoRequisicion) throws ClinicaModelexception;

    void remove(CatTipoRequisicion catTipoRequisicion) throws ClinicaModelexception;

    CatTipoRequisicion find(Object id) throws ClinicaModelexception;

    List<CatTipoRequisicion> findAll() throws ClinicaModelexception;

    List<CatTipoRequisicion> findRange(int[] range) throws ClinicaModelexception;

    int count() throws ClinicaModelexception;
    
    public List<CatTipoRequisicion> findActive() throws ClinicaModelexception;
    
}
