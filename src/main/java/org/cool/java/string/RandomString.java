/**
 * 
 */
package org.cool.java.string;

/**
 * @author Colin
 * 
 */
public final class RandomString {

	public static final String[] CODES_BASE = { "a", "A", "b", "B", "c", "C", "d", "D", "e", "E", "f", "F", "g", "G", "h", "H", "i", "I", "j", "J", "k", "K", "l", "L", "m", "M", "n", "N", "o", "O", "p", "P", "q", "Q", "r", "R", "s", "S", "t", "T", "u", "U", "v", "V", "w", "W", "x", "X", "y", "Y", "z", "Z", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };

	public static final String[] CODES_ALL = { "a", "A", "b", "B", "c", "C", "d", "D", "e", "E", "f", "F", "g", "G", "h", "H", "i", "I", "j", "J", "k", "K", "l", "L", "m", "M", "n", "N", "o", "O", "p", "P", "q", "Q", "r", "R", "s", "S", "t", "T", "u", "U", "v", "V", "w", "W", "x", "X", "y", "Y", "z", "Z", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "!", "@", "#", "$", "%", "^", "&", "*", "(", ")", "-", "_", "=", "+", "`", "~", ",", ":", "'", "<", ".", ">", "/", "?", "\"" };

	private static final int BASE_MAX_AREA = CODES_BASE.length;
	private static final int ALL_MAX_AREA = CODES_ALL.length;

	private int length = 8;
	private boolean all = false;


	/**
	 * 
	 */
	private RandomString() {
	}


	private static final class RandomStringSingleton {
		private static final RandomString INSTANCE = new RandomString();
	}


	public static RandomString getInstance() {
		return RandomStringSingleton.INSTANCE;
	}

	public synchronized RandomString Length(final int length) {
		this.length = length;
		return this;
	}

	public synchronized RandomString Random(final boolean all) {
		this.all = all;
		return this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < this.length; ++i) {
			buf.append(this.all ? CODES_ALL[(int) (Math.random() * ALL_MAX_AREA)] : CODES_BASE[(int) (Math.random() * BASE_MAX_AREA)]);
		}
		return buf.toString();
	}

}
