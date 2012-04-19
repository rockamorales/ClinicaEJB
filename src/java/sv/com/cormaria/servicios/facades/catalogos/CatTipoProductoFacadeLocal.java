/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.facades.catalogos;

import java.util.List;
import javax.ejb.Local;
import sv.com.cormaria.servicios.entidades.catalogos.CatTipoProducto;
import sv.com.cormaria.servicios.exceptions.ClinicaModelexception;

/**
 *
 * @author Claudia
 */
@Local
public interface CatTipoProductoFacadeLocal {

    void create(CatTipoProducto catTipoProducto) throws ClinicaModelexception;

    void edit(CatTipoProducto catTipoProducto) throws ClinicaModelexception;

    void remove(CatTipoProducto catTipoProducto) throws ClinicaModelexception;

    CatTipoProducto find(Object id) throws ClinicaModelexception;

    List<CatTipoProducto> findAll() throws ClinicaModelexception;

    List<CatTipoProducto> findRange(int[] range) throws ClinicaModelexception;

    int count() throws ClinicaModelexception;
    
}
