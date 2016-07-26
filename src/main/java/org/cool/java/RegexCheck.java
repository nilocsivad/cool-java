/**
 * 
 */
package org.cool.java;

import java.util.regex.Pattern;

/**
 * @author Colin
 *
 */
public class RegexCheck {

	/**
	 * 
	 */
	public RegexCheck() {
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		{
			String[] arr = { "33", "35,325", "2x", "23,25x" };

			for (String item : arr) {
				boolean b = Pattern.matches("^\\d+(,\\d+)*$", item);
				System.out.println(b);
			}
		}

		System.out.println();
		System.out.println();
		System.out.println();

		{
			String[] arr = { "33", "35.325", "35,325", "2x", "23,25x" };

			for (String item : arr) {
				boolean b = Pattern.matches("^\\d+(\\.\\d+)*$", item);
				System.out.println(b);
			}
		}


	}

}
