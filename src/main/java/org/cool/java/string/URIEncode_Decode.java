/**
 * 
 */
package org.cool.java.string;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @author Colin
 *
 */
public class URIEncode_Decode {

	/**
	 * 
	 */
	public URIEncode_Decode() {
	}

	public String URIEncode_(final String txt) throws UnsupportedEncodingException {
		return URLEncoder.encode(txt, "UTF-8");
	}

	public String URIDecode_(final String txt) throws UnsupportedEncodingException {
		return URLDecoder.decode(txt, "UTF-8");
	}

}
