/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.facades.catalogos;

import java.util.List;
import javax.ejb.Local;
import sv.com.cormaria.servicios.entidades.catalogos.CatCategoriaProducto;
import sv.com.cormaria.servicios.exceptions.ClinicaModelexception;

/**
 *
 * @author Claudia
 */
@Local
public interface CatCategoriaProductoFacadeLocal {

    CatCategoriaProducto create(CatCategoriaProducto catCategoriaProducto) throws ClinicaModelexception;

    CatCategoriaProducto edit(CatCategoriaProducto catCategoriaProducto) throws ClinicaModelexception;

    void remove(CatCategoriaProducto catCategoriaProducto) throws ClinicaModelexception;

    CatCategoriaProducto find(Object id) throws ClinicaModelexception;

    List<CatCategoriaProducto> findAll() throws ClinicaModelexception;

    List<CatCategoriaProducto> findRange(int[] range) throws ClinicaModelexception;

    int count() throws ClinicaModelexception;
    
    public List<CatCategoriaProducto> findActive() throws ClinicaModelexception;
}
