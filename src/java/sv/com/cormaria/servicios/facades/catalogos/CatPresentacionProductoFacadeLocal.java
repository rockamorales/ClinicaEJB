/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.facades.catalogos;

import java.util.List;
import javax.ejb.Local;
import sv.com.cormaria.servicios.entidades.catalogos.CatPresentacionProducto;
import sv.com.cormaria.servicios.exceptions.ClinicaModelexception;

/**
 *
 * @author Claudia
 */
@Local
public interface CatPresentacionProductoFacadeLocal {

    CatPresentacionProducto create(CatPresentacionProducto catPresentacionProducto) throws ClinicaModelexception;

    CatPresentacionProducto edit(CatPresentacionProducto catPresentacionProducto) throws ClinicaModelexception;

    void remove(CatPresentacionProducto catPresentacionProducto) throws ClinicaModelexception;

    CatPresentacionProducto find(Object id) throws ClinicaModelexception;

    List<CatPresentacionProducto> findAll() throws ClinicaModelexception;

    List<CatPresentacionProducto> findRange(int[] range) throws ClinicaModelexception;

    int count() throws ClinicaModelexception;
    
    public List<CatPresentacionProducto> findActive() throws ClinicaModelexception;
}
