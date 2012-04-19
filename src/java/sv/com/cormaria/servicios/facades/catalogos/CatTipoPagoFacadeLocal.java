/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.facades.catalogos;

import java.util.List;
import javax.ejb.Local;
import sv.com.cormaria.servicios.entidades.catalogos.CatTipoPago;
import sv.com.cormaria.servicios.exceptions.ClinicaModelexception;

/**
 *
 * @author Claudia
 */
@Local
public interface CatTipoPagoFacadeLocal {

    void create(CatTipoPago catTipoPago) throws ClinicaModelexception;

    void edit(CatTipoPago catTipoPago) throws ClinicaModelexception;

    void remove(CatTipoPago catTipoPago) throws ClinicaModelexception;

    CatTipoPago find(Object id) throws ClinicaModelexception;

    List<CatTipoPago> findAll() throws ClinicaModelexception;

    List<CatTipoPago> findRange(int[] range) throws ClinicaModelexception;

    int count() throws ClinicaModelexception;
    
    public List<CatTipoPago> findActive() throws ClinicaModelexception;    
    
}
