/**
 * 
 */
package org.cool.java.local.encrypt;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * @author Colin
 *
 */
public final class _StartupEncrypt_ {

	/**
	 * 
	 */
	public _StartupEncrypt_() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 * @throws UnsupportedEncodingException 
	 * @throws NoSuchAlgorithmException 
	 */
	public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {

		EncryptText.getInstance().MD5( "abcde" ).chars().forEach( System.out::println );;
	}

}
