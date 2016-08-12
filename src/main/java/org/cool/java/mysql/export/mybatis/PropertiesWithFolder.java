/**
 * 
 */
package org.cool.java.mysql.export.mybatis;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.cool.java.mysql.export.mybatis.TableDefine.ITableBeanName;

/**
 * @author Colin
 */
public class PropertiesWithFolder {

	private static final String BASE_PACKAGE_CHILD_FMT = "%s.%s";

	/**
	 * 
	 */
	public PropertiesWithFolder() {
	}

	private String[] KEY_VELOCITY = { "package_c", "package_request_base", "package_model", "package_api", "package_database", "package_iapi", "package_ref", "package_adapter", "package_util" };
	private String[] KEY_PROP = { "PATH_PACKAGE_C", "PATH_PACKAGE_REQUEST", "PATH_PACKAGE_MODEL", "PATH_PACKAGE_API", "PATH_PACKAGE_DATABASE", "PATH_PACKAGE_IAPI", "PATH_PACKAGE_REF", "PATH_PACKAGE_ADAPTER", "PATH_PACKAGE_UTIL" };
	private String[] PKG_FOLDER = new String[KEY_VELOCITY.length];
	private String[] PKG_CLASS = new String[PKG_FOLDER.length];



	private Properties prop;

	private String PROJ_ROOT, BASE_PACKAGE, PACKAGE_FOLDER, CONFIG_FOLDER;
	private String XML_PREFIX;



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



		XML_PREFIX = prop.getProperty("XML_PREFIX", "mysql-");



		PROJ_ROOT = prop.getProperty("ROOT_PATH", "E:\\tmp");
		BASE_PACKAGE = prop.getProperty("PATH_PACKAGE", "com.iamVip.it.v1");



		File packFile = new File(PROJ_ROOT, BASE_PACKAGE.replace(".", File.separator));
		PACKAGE_FOLDER = packFile.getAbsolutePath();



		String config = prop.getProperty("FOLDER_CONFIG", "config");
		File configFile = new File(PROJ_ROOT, config);
		CONFIG_FOLDER = configFile.getAbsolutePath();



		validFolder(new File(PROJ_ROOT), packFile, configFile);

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
			String pk = String.format(BASE_PACKAGE_CHILD_FMT, BASE_PACKAGE, val);
			PKG_CLASS[i] = pk;
			PKG_FOLDER[i] = PROJ_ROOT + File.separator + pk.replace(".", File.separator);
			folders[i] = new File(PKG_FOLDER[i]);
		}

		validFolder(folders);



		final String PATH_PREFIX = "PATH_PACKAGE_";

		prop.keySet().forEach(okey -> {
			String key = okey.toString();

			if (key.startsWith(PATH_PREFIX)) {
				String val = prop.getProperty(key, "");
				validFolder(new File(PACKAGE_FOLDER, val.replace(".", File.separator)));
			}
		});



		final String FOLDER_PREFIX = "FOLDER_CONFIG_";

		prop.keySet().forEach(okey -> {
			String key = okey.toString();

			if (key.startsWith(FOLDER_PREFIX)) {
				String val = prop.getProperty(key, "");
				validFolder(new File(CONFIG_FOLDER, val));
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

		for (int i = 0; i < KEY_VELOCITY.length; i++) {
			context.put(KEY_VELOCITY[i], PKG_CLASS[i]);
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
				String toFolder = PKG_FOLDER[index];

				String templatePath = resource2temp(pkg.replace(".", "/") + "/" + toName + ".bin");
				Template template = Velocity.getTemplate(templatePath, "UTF-8");

				File toFile = new File(toFolder, toName);
				FileWriter writer = new FileWriter(toFile);

				template.merge(context, writer);

				writer.close();

			}
		}
	}

	/**
	 * @param list
	 * @param rule
	 * @throws Exception
	 */
	public void toModel(List<TableDefine> list, ITableBeanName rule) throws Exception {

		int index = findIt(KEY_PROP, "PATH_PACKAGE_MODEL");
		String toFolder = PKG_FOLDER[index];
		String package_model = PKG_CLASS[index];




		VelocityContext context = new VelocityContext();
		context.put("package_model", package_model);

		String pkg = this.getClass().getName();
		pkg = pkg.substring(0, pkg.lastIndexOf("."));

		String templatePath = resource2temp(pkg.replace(".", "/") + "/__Bean.java.bin");
		Template template = Velocity.getTemplate(templatePath, "UTF-8");




		for (TableDefine td : list) {

			String bean = rule != null ? rule.translateIt(td.name) : td.name;
			File toFile = new File(toFolder, bean + ".java");

			context.put("comment", td.comment == null ? "" : td.comment);
			context.put("table", td.name);
			context.put("bean", bean);
			context.put("cols", td.columns);

			FileWriter writer = new FileWriter(toFile);

			template.merge(context, writer);

			writer.close();

		}

	}

}
