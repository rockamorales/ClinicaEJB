/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.facades.administracion;

import java.util.List;
import javax.ejb.Local;
import sv.com.cormaria.servicios.entidades.administracion.TblProducto;
import sv.com.cormaria.servicios.exceptions.ClinicaModelexception;

/**
 *
 * @author Mackk
 */
@Local
public interface TblProductoFacadeLocal {

    TblProducto create(TblProducto tblProducto)  throws ClinicaModelexception;

    TblProducto edit(TblProducto tblProducto)  throws ClinicaModelexception;

    void remove(TblProducto tblProducto)  throws ClinicaModelexception;

    TblProducto find(Object id)  throws ClinicaModelexception;

    List<TblProducto> findAll()  throws ClinicaModelexception;

    List<TblProducto> findRange(int[] range)  throws ClinicaModelexception;

    int count()  throws ClinicaModelexception;
    
    public List<TblProducto> findByNombreProducto(String nomProducto, int firstRow, int maxResults) throws ClinicaModelexception;    
    
    public List<TblProducto> findActive() throws ClinicaModelexception;
    
    public void desactivar(Integer numProducto) throws ClinicaModelexception;

    public List<TblProducto> findActiveServices() throws ClinicaModelexception;    
    
    public List<TblProducto> findTarjetaControl() throws ClinicaModelexception;
    
    public List<TblProducto> findMedicamentos() throws ClinicaModelexception;
    
    public List<TblProducto> findProductoAlquiler() throws ClinicaModelexception;
    
    public List<TblProducto> findAlertas() throws ClinicaModelexception;

    public void generarAlertas() throws ClinicaModelexception;
}
