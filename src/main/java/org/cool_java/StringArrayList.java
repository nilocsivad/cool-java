/**
 * 
 */
package org.cool_java;

import java.util.Arrays;
import java.util.List;

/**
 * @author Colin
 */
public class StringArrayList {

	public static final String TYPE[] = { "", "default", "number" };
	public static final List<String> TYPES = Arrays.asList(TYPE);

	/**
	 * 
	 */
	public StringArrayList() {
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String[] arr_hello = { null, "12", "default" };
		for (String h : arr_hello) {
			System.out.println("--> " + TYPES.contains(h));
		}

	}

}
