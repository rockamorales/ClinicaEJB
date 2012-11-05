/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.helpers;

/**
 *
 * @author romorales
 */
public class NumUtils {
    public static double round(double value, int numberOfDecimal){
        value = value*Math.pow(10, numberOfDecimal);
        value = Math.round(value)/Math.pow(10, numberOfDecimal);
        return value;
    }
    public static float round(float value, int numberOfDecimal){
        value = (float)(value*Math.pow(10, numberOfDecimal));
        value = (float)(Math.round(value)/Math.pow(10, numberOfDecimal));
        return value;
    }
    
}
