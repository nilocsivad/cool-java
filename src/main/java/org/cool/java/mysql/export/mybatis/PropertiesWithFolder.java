/**
 * 
 */
package org.cool.java.mysql.export.mybatis;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

/**
 * @author Colin
 */
public class PropertiesWithFolder {

	/**
	 * 
	 */
	public PropertiesWithFolder() {
	}

	String[] PKG_PROP = { "package_c", "package_request_base", "package_model", "package_api", "package_database", "package_iapi", "package_ref", "package_adapter", "package_util" };
	String[] KEY_PROP = { "PATH_PACKAGE_C", "PATH_PACKAGE_REQUEST", "PATH_PACKAGE_MODEL", "PATH_PACKAGE_API", "PATH_PACKAGE_DATABASE", "PATH_PACKAGE_IAPI", "PATH_PACKAGE_REF", "PATH_PACKAGE_ADAPTER", "PATH_PACKAGE_UTIL" };
	String[] FOLDERS = new String[PKG_PROP.length];
	String[] PKGS = new String[FOLDERS.length];

	Properties prop;

	String ROOT, PACKAGE, PACKAGE_FOLDER;

	String PKG_FMT = "%s.%s";

	public String get(String key) {
		return prop.getProperty(key);
	}

	private void validFolder(File... folders) {
		for (File folder : folders) {
			if (!folder.exists() || folder.isFile()) {
				folder.mkdirs();
			}
		}
	}

	private int findIt(String[] arr, String it) {
		int index = 0;
		for (int i = 0; i < arr.length; i++) {
			if (it.equals(arr[i])) {
				index = i;
				break;
			}
		}
		return index;
	}

	private Properties getProp() throws IOException {

		if (prop == null) {

			prop = new Properties();

			InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("org/cool/java/mysql/export/mybatis/mysql2.properties");
			prop.load(inputStream);
			inputStream.close();
		}

		return prop;
	}

	public void initProperties() throws IOException {

		this.getProp();

		ROOT = prop.getProperty("ROOT_PATH", "E:\\tmp");
		PACKAGE = prop.getProperty("PATH_PACKAGE", "com.iamVip.it.v1");

		File packFile = new File(ROOT, PACKAGE.replace(".", File.separator));
		PACKAGE_FOLDER = packFile.getAbsolutePath();

		validFolder(new File(ROOT), packFile);

	}

	public void printProperties() throws IOException {
		prop.forEach((key, val) -> {
			System.out.println(key + " --> " + val);
		});
	}

	public void initFolders() throws IOException {

		File[] folders = new File[KEY_PROP.length];

		for (int i = 0; i < KEY_PROP.length; ++i) {
			String val = prop.getProperty(KEY_PROP[i]);
			String pk = String.format(PKG_FMT, PACKAGE, val);
			PKGS[i] = pk;
			FOLDERS[i] = ROOT + File.separator + pk.replace(".", File.separator);
			folders[i] = new File(FOLDERS[i]);
		}

		validFolder(folders);



		String PREFIX = "PATH_PACKAGE_";

		prop.keySet().forEach(okey -> {
			String key = okey.toString();

			if (key.startsWith(PREFIX)) {
				String val = prop.getProperty(key, "");
				validFolder(new File(PACKAGE_FOLDER, val.replace(".", File.separator)));
			}
		});
	}


	private String resource2temp(String res) throws IOException {
		InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(res);

		File tmp = File.createTempFile("Resource", ".vm");
		FileOutputStream outputStream = new FileOutputStream(tmp);

		byte[] buf = new byte[1024 * 100];
		int len = 0;
		while ((len = inputStream.read(buf)) > 0) {
			outputStream.write(buf, 0, len);
		}
		inputStream.close();
		outputStream.close();

		return tmp.getName();
	}

	public void cpTemplate() throws Exception {

		VelocityContext context = new VelocityContext();

		for (int i = 0; i < PKG_PROP.length; i++) {
			context.put(PKG_PROP[i], PKGS[i]);
		}

		String pkg = this.getClass().getName();
		pkg = pkg.substring(0, pkg.lastIndexOf("."));


		String PREFIX = "TEMPLATE_", SUFFIX = "_TO";

		for (Object okey : prop.keySet()) {
			String key = okey.toString();

			if (key.startsWith(PREFIX) && key.endsWith(SUFFIX)) {
				String toName = key.substring(PREFIX.length(), key.lastIndexOf(SUFFIX));

				String valKey = prop.getProperty(key);
				int index = findIt(KEY_PROP, valKey);
				String toFolder = FOLDERS[index];

				String templatePath = resource2temp(pkg.replace(".", "/") + "/" + toName + ".bin");
				Template template = Velocity.getTemplate(templatePath, "UTF-8");

				File toFile = new File(toFolder, toName);
				FileWriter writer = new FileWriter(toFile);

				template.merge(context, writer);

				writer.close();

			}
		}
	}

}
