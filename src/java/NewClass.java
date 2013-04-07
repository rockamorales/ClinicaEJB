
import sun.misc.BASE64Encoder;
import sv.com.cormaria.servicios.facades.security.Crypto;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author romorales
 */
public class NewClass {
    public static void main (String[] args){
        try{
            System.out.println(new BASE64Encoder().encode(Crypto.encrypt("password")));
        }catch(Exception ex){
            
        }
    }
}
