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

		String from = "F:\\3", dest = "F:\\3";

		File folder = new File(from);

		String[] suffix = { ".bt.td", ".torrent" };
		list4(folder, suffix);
		move2(folder, dest, suffix, false);

	}

	static void list4(File folder, final String[] suffix) {
		for (File f : folder.listFiles()) {
			if (f.isDirectory()) {
				list4(f, suffix);
			} else {
				if (suffix.length > 0) {
					boolean _jmp = false;
					for (String _suf : suffix) {
						if (f.getName().endsWith(_suf)) {
							_jmp = true;
							break;
						}
					}
					if (_jmp)
						continue;
				}
				String p = f.getAbsolutePath();
				System.out.println(p);
			}
		}
	}

	static void move2(File folder, String dest, final String[] suffix, boolean createFolder) throws IOException {

		File _dest = new File(dest);
		if (!_dest.exists() || _dest.isFile())
			throw new RuntimeException(dest + " not exists or not a folder!");

		for (File f : folder.listFiles()) {
			if (f.isDirectory()) {
				if (createFolder) {
					File _f = new File(dest, f.getName());
					_f.mkdirs();
					move2(f, _f.getAbsolutePath(), suffix, createFolder);
				} else {
					move2(f, dest, suffix, createFolder);
				}
			} else {

				if (suffix.length > 0) {
					boolean _jmp = false;
					for (String _suf : suffix) {
						if (f.getName().endsWith(_suf)) {
							_jmp = true;
							break;
						}
					}
					if (_jmp)
						continue;
				}

				Runtime.getRuntime().exec(String.format(" cmd /c move \"%s\" \"%s\" ", f.getAbsolutePath(), dest));
			}
		}
	}

}
