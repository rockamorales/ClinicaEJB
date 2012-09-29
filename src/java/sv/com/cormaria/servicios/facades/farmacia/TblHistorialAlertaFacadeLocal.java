/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.facades.farmacia;

import java.util.List;
import javax.ejb.Local;
import sv.com.cormaria.servicios.entidades.farmacia.TblHistorialAlerta;
import sv.com.cormaria.servicios.exceptions.ClinicaModelexception;

/**
 *
 * @author Mackk
 */
@Local
public interface TblHistorialAlertaFacadeLocal {

    TblHistorialAlerta create(TblHistorialAlerta tblHistorialAlerta)  throws ClinicaModelexception;

    TblHistorialAlerta edit(TblHistorialAlerta tblHistorialAlerta)  throws ClinicaModelexception;

    void remove(TblHistorialAlerta tblHistorialAlerta)  throws ClinicaModelexception;

    TblHistorialAlerta find(Object id)  throws ClinicaModelexception;

    List<TblHistorialAlerta> findAll()  throws ClinicaModelexception;

    List<TblHistorialAlerta> findRange(int[] range)  throws ClinicaModelexception;

    int count()  throws ClinicaModelexception;
    
}
