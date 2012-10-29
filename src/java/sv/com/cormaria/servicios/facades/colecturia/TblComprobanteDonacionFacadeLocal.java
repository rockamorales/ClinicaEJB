/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.facades.colecturia;

import java.util.Date;
import java.util.List;
import javax.ejb.Local;
import sv.com.cormaria.servicios.criteria.ISearchable;
import sv.com.cormaria.servicios.entidades.colecturia.CorteDiario;
import sv.com.cormaria.servicios.entidades.colecturia.TblComprobanteDonacion;
import sv.com.cormaria.servicios.exceptions.ClinicaModelexception;

/**
 *
 * @author Mackk
 */
@Local
public interface TblComprobanteDonacionFacadeLocal extends ISearchable<TblComprobanteDonacion> {

    TblComprobanteDonacion create(TblComprobanteDonacion tblComprobanteDonacion) throws ClinicaModelexception;

    TblComprobanteDonacion edit(TblComprobanteDonacion tblComprobanteDonacion) throws ClinicaModelexception;

    void remove(TblComprobanteDonacion tblComprobanteDonacion) throws ClinicaModelexception;

    TblComprobanteDonacion find(Object id) throws ClinicaModelexception;

    List<TblComprobanteDonacion> findAll() throws ClinicaModelexception;

    List<TblComprobanteDonacion> findRange(int[] range) throws ClinicaModelexception;

    int count() throws ClinicaModelexception;

    public void recibirPago(TblComprobanteDonacion comprobante) throws ClinicaModelexception;
    
    public List<CorteDiario> calcularCorteDiario(Date fecCorte) throws ClinicaModelexception;
    
    public List<CorteDiario> calcularCorteDiario1(Date fecCorte) throws ClinicaModelexception;
    
    public void anularComprobante(Integer numComprobante) throws ClinicaModelexception;
}
