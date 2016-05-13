/**
 * 
 */
package org.cool_java;

/**
 * @author Colin
 *
 */
public class _16_10_8_2 {

	/**
	 * 
	 */
	public _16_10_8_2() {
	}

	public static void main(String[] args) {

		String line = "-----------------------------------------";

		String hex = "1A2B3C";

		int num = Integer.parseInt(hex, 16);

		String out = String.format("%s%n%d", line, num);
		System.out.println(out);

		out = String.format("%s%n%s", line, Integer.toBinaryString(num));
		System.out.println(out);

		System.out.println( ((1 & 0xFF) >> 4) );

	}

}
