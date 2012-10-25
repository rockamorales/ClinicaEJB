/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.facades.catalogos;

import java.util.List;
import javax.ejb.Local;
import sv.com.cormaria.servicios.entidades.catalogos.CatClasificacionProducto;
import sv.com.cormaria.servicios.exceptions.ClinicaModelexception;

/**
 *
 * @author Claudia
 */
@Local
public interface CatClasificacionProductoFacadeLocal {

    CatClasificacionProducto create(CatClasificacionProducto catAreas) throws ClinicaModelexception;

    CatClasificacionProducto edit(CatClasificacionProducto catAreas) throws ClinicaModelexception;

    void remove(CatClasificacionProducto catAreas) throws ClinicaModelexception;

    CatClasificacionProducto find(Object id) throws ClinicaModelexception;

    List<CatClasificacionProducto> findAll() throws ClinicaModelexception;

    List<CatClasificacionProducto> findRange(int[] range) throws ClinicaModelexception;

    int count() throws ClinicaModelexception;
    
    public List<CatClasificacionProducto> findActive() throws ClinicaModelexception;
}
