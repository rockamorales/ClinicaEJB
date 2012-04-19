/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.facades.catalogos;

import java.util.List;
import javax.ejb.Local;
import sv.com.cormaria.servicios.entidades.catalogos.CatUbicacionFisica;
import sv.com.cormaria.servicios.exceptions.ClinicaModelexception;

/**
 *
 * @author Claudia
 */
@Local
public interface CatUbicacionFisicaFacadeLocal {

    void create(CatUbicacionFisica catUbicacionFisica) throws ClinicaModelexception;

    void edit(CatUbicacionFisica catUbicacionFisica) throws ClinicaModelexception;

    void remove(CatUbicacionFisica catUbicacionFisica) throws ClinicaModelexception;

    CatUbicacionFisica find(Object id) throws ClinicaModelexception;

    List<CatUbicacionFisica> findAll() throws ClinicaModelexception;

    List<CatUbicacionFisica> findRange(int[] range) throws ClinicaModelexception;

    int count() throws ClinicaModelexception;
    
    public List<CatUbicacionFisica> findActive() throws ClinicaModelexception;
    
}
