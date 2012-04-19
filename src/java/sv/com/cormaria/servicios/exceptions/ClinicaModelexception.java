/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.exceptions;

/**
 *
 * @author Administrador
 */
public class ClinicaModelexception extends Exception {

    public ClinicaModelexception(String message, Exception ex) {
        super(message);
    }

    public ClinicaModelexception(String message) {
        super(message);
    }
    
}
