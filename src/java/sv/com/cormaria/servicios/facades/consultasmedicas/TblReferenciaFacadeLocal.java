/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.facades.consultasmedicas;

import java.util.List;
import javax.ejb.Local;
import sv.com.cormaria.servicios.entidades.consultasmedicas.TblReferencia;
import sv.com.cormaria.servicios.exceptions.ClinicaModelexception;

/**
 *
 * @author Mackk
 */
@Local
public interface TblReferenciaFacadeLocal {

    TblReferencia create(TblReferencia tblReferencia) throws ClinicaModelexception;

    TblReferencia edit(TblReferencia tblReferencia) throws ClinicaModelexception;

    void remove(TblReferencia tblReferencia) throws ClinicaModelexception;

    TblReferencia find(Object id) throws ClinicaModelexception;

    List<TblReferencia> findAll() throws ClinicaModelexception;

    List<TblReferencia> findRange(int[] range) throws ClinicaModelexception;

    int count() throws ClinicaModelexception;
    
    public TblReferencia findByNumConsulta(Integer numConsulta) throws ClinicaModelexception;
}
