/**
 * 
 */
package org.cool_java;

import java.io.File;
import java.io.IOException;

/**
 * @author Colin
 *
 */
public class CmdMove2 {

	/**
	 * 
	 */
	public CmdMove2() {
	}

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		String from = "F:\\2", dest = "F:\\3";

		File folder = new File(from);

		list4(folder, dest, false);

	}

	static void list4(File folder, String dest, boolean createFolder) throws IOException {
		for (File f : folder.listFiles()) {
			if (f.isDirectory()) {
				if (createFolder) {
					File _f = new File(dest, f.getName());
					_f.mkdirs();
					list4(f, _f.getAbsolutePath(), createFolder);
				} else {
					list4(f, dest, createFolder);
				}
			} else {
				Runtime.getRuntime().exec(String.format(" cmd /c move \"%s\" \"%s\" ", f.getAbsolutePath(), dest));
			}
		}
	}

}
