/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.exceptions;

import javax.ejb.ApplicationException;

/**
 *
 * @author Administrador
 */
@ApplicationException(rollback=true)
public class ClinicaModelexception extends Exception {

    public ClinicaModelexception(String message, Exception ex) {
        super(message);
    }

    public ClinicaModelexception(String message) {
        super(message);
    }
    
}
