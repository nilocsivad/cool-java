/**
 * 
 */
package org.cool.java.mysql.export.mybatis;

import java.util.Properties;

import org.apache.velocity.app.Velocity;

/**
 * @author Colin
 *
 */
public class ExportMYSQL2Mybatis {

	/**
	 * 
	 */
	public ExportMYSQL2Mybatis() {
	}




	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		PropertiesFolder first = new PropertiesFolder();

		String tempDir = System.getProperty("java.io.tmpdir");
		Properties properties = new Properties();
		properties.setProperty(Velocity.FILE_RESOURCE_LOADER_PATH, tempDir);
		Velocity.init(properties);

		/// 读取配置文件 ///
		first.initProperties();
		// instance.printProperties();
		/// 创建文件夹 ///
		first.initFolders();
		/// 复制模版文件 ///
		first.cpTemplate();


		// String folder =
		// "E:/javadb/space-java/cool-java/src/main/java/org/cool/java/mysql/export/mybatis";
		// File[] files = new File(folder).listFiles(new FileFilter() {
		// @Override
		// public boolean accept(File pathname) {
		// return pathname.getName().contains("Util.java");
		// }
		// });
		// String format = "TEMPLATE_%s_TO = PATH_PACKAGE_UTIL";
		// for (File file : files) {
		// System.out.println(String.format(format, file.getName().substring(0,
		// file.getName().lastIndexOf("."))));
		// }

	}



























}
