/**
 * 
 */
package org.cool.java.local.string;

import java.io.UnsupportedEncodingException;

/**
 * @author Colin
 *
 */
public class _StartupString_ {

	/**
	 * 
	 */
	public _StartupString_() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 * @throws UnsupportedEncodingException 
	 */
	public static void main(String[] args) throws UnsupportedEncodingException {
		
		URIEncode_Decode ed = new URIEncode_Decode();
		
		System.out.println( ed.URIEncode_( "+" ) );
		System.out.println( ed.URIDecode_( "%2b" ) );
		
		/*
		long len = 1000 * 1;
		while ( len > 0 ) {
			System.out.println( RandomString.getInstance().Length( 12 ).Random( true ) );
			len--;
		}*/
	}

}
