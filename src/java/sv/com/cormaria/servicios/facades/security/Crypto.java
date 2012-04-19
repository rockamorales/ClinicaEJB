/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.facades.security;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.NoSuchPaddingException;

/**
 *
 * @author Administrador
 */
public class Crypto {
	public static byte[] encrypt(String password) throws NoSuchAlgorithmException,
		NoSuchPaddingException, InvalidKeyException, IOException {
		if (password!=null){
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			md.update(password.getBytes("UTF-8"));
			byte[] result = md.digest();
			return result;
		}else{
			return null;
		}
	}
}
