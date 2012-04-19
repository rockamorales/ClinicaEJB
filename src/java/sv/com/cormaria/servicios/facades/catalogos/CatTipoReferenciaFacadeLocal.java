/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.facades.catalogos;

import java.util.List;
import javax.ejb.Local;
import sv.com.cormaria.servicios.entidades.catalogos.CatTipoReferencia;
import sv.com.cormaria.servicios.exceptions.ClinicaModelexception;

/**
 *
 * @author Claudia
 */
@Local
public interface CatTipoReferenciaFacadeLocal {

    void create(CatTipoReferencia catTipoReferencia) throws ClinicaModelexception;

    void edit(CatTipoReferencia catTipoReferencia) throws ClinicaModelexception;

    void remove(CatTipoReferencia catTipoReferencia) throws ClinicaModelexception;

    CatTipoReferencia find(Object id) throws ClinicaModelexception;

    List<CatTipoReferencia> findAll() throws ClinicaModelexception;

    List<CatTipoReferencia> findRange(int[] range) throws ClinicaModelexception;

    int count() throws ClinicaModelexception;
    
}
