/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.facades.catalogos;

import java.util.List;
import javax.ejb.Local;
import sv.com.cormaria.servicios.entidades.catalogos.CatCarisma;
import sv.com.cormaria.servicios.exceptions.ClinicaModelexception;

/**
 *
 * @author Claudia
 */
@Local
public interface CatCarismaFacadeLocal {

    CatCarisma create(CatCarisma catCarisma) throws ClinicaModelexception ;

    CatCarisma edit(CatCarisma catCarisma) throws ClinicaModelexception ;

    void remove(CatCarisma catCarisma) throws ClinicaModelexception ;

    CatCarisma find(Object id) throws ClinicaModelexception ;

    List<CatCarisma> findAll() throws ClinicaModelexception ;

    List<CatCarisma> findRange(int[] range) throws ClinicaModelexception ;

    int count() throws ClinicaModelexception;
    
    public List<CatCarisma> findActive() throws ClinicaModelexception;
    
}
