/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.facades.catalogos;

import java.util.List;
import javax.ejb.Local;
import sv.com.cormaria.servicios.entidades.catalogos.CatOrigenIngresoProducto;
import sv.com.cormaria.servicios.exceptions.ClinicaModelexception;

/**
 *
 * @author Claudia
 */
@Local
public interface CatOrigenIngresoProductoFacadeLocal {

    void create(CatOrigenIngresoProducto catOrigenIngresoProducto) throws ClinicaModelexception;

    void edit(CatOrigenIngresoProducto catOrigenIngresoProducto) throws ClinicaModelexception;

    void remove(CatOrigenIngresoProducto catOrigenIngresoProducto) throws ClinicaModelexception;

    CatOrigenIngresoProducto find(Object id) throws ClinicaModelexception;

    List<CatOrigenIngresoProducto> findAll() throws ClinicaModelexception;

    List<CatOrigenIngresoProducto> findRange(int[] range) throws ClinicaModelexception;

    int count() throws ClinicaModelexception;
    
}
