/**
 * 
 */
package org.cool.java.mysql.export.mybatis;

import java.io.File;
import java.io.InputStream;
import java.util.List;

import org.cool.java.mysql.export.mybatis.TableDefine.ITableBeanName;

import com.google.gson.Gson;

/**
 * @author Colin
 */
public class Table2Mybatis {

	/**
	 * 
	 */
	public Table2Mybatis() {
	}


	public static void main3s(String[] args) {

		String ttt = "sdfaodifjqopig";
		System.out.println(ttt.substring(0, 50));

	}


	public static void mainw(String[] args) {
		File folder = new File("E:/javadb/space-java2", "/cool-java/src/main/resources/template");
		for (File f : folder.listFiles()) {
			String p = f.getParent();
			String name = f.getName().replace(".bin", ".vm");
			f.renameTo(new File(p, name));
		}
	}


	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		Table2Mybatis run = new Table2Mybatis();

		// ClassLoader cl = run.getClass().getClassLoader();
		// URL url = cl.getResource("template/IAPP.java.bin");
		// System.out.println(url.getFile());
		// File f = new File(url.getFile());
		// System.out.println(f.getAbsolutePath());
		// System.out.format("length of file is %d \r\n", f.length());
		// System.out.printf("length of file is %d \r\n", f.length());


		PropertiesWithFolder first = new PropertiesWithFolder();

		// String tempDir = System.getProperty("java.io.tmpdir");
		// Properties properties = new Properties();
		// properties.setProperty(Velocity.FILE_RESOURCE_LOADER_PATH, tempDir);
		// Velocity.init(properties);

		/// 读取配置文件并初始化 ///
		InputStream in = run.getClass().getClassLoader().getResourceAsStream("table2.properties");
		first.initProperties(in);
		in.close();

		// first.printProperties();
		/// 创建文件夹 ///
		first.initFolders();
		/// 复制模版文件 ///
		first.cpTemplate();




		Gson gson = new Gson();

		DBAndTable dbt = new DBAndTable(first);
		// dbt.printTypeMap();



		ITableBeanName rule = run.new NameRuleNoUnderline();
		List<TableDefine> list = dbt.getTables("sale_detail", "group_man");
		// ITableBeanName rule = run.new NameRuleHTUnderline();
		// List<TableDefine> list = dbt.getTables("ht_sale_number");



		/// 生成 Bean ///
		first.toModel(list, rule);
		/// 生成 DB 接口 ///
		first.toIDB(list, rule);
		/// 生成业务逻辑接口 ///
		first.toInterface(list, rule);
		/// 生成逻辑实现 ///
		first.toImplement(list, rule);
		/// 生成 XML 文件 ///
		first.toXML(list, rule);



		list.forEach(tb -> {
			System.out.println(gson.toJson(tb));
		});




	}



	class NameRuleNoUnderline implements ITableBeanName {

		private String zeroToUpper(String str) {
			return (str.charAt(0) + "").toUpperCase() + str.substring(1).toLowerCase();
		}

		/*
		 * (non-Javadoc)
		 * @see org.cool.java.mysql.export.mybatis.TableDefine.ITableBeanName#translateIt(java.lang.String)
		 */
		@Override
		public String translateIt(String tableName) {
			String[] arr = tableName.split("_");
			StringBuffer buf = new StringBuffer(tableName.length() + 8);
			for (String str : arr) {
				buf.append(zeroToUpper(str));
			}
			return buf.toString();
		}

	}

	class NameRuleHTNoUnderline implements ITableBeanName {

		private String zeroToUpper(String str) {
			return (str.charAt(0) + "").toUpperCase() + str.substring(1).toLowerCase();
		}

		/*
		 * (non-Javadoc)
		 * @see org.cool.java.mysql.export.mybatis.TableDefine.ITableBeanName#translateIt(java.lang.String)
		 */
		@Override
		public String translateIt(String tableName) {
			tableName = tableName.replace("ht_", "");
			String[] arr = tableName.split("_");
			StringBuffer buf = new StringBuffer(tableName.length() + 8);
			for (String str : arr) {
				buf.append(zeroToUpper(str));
			}
			return buf.toString();
		}

	}













	// String folder = "E:/javadb/space-java/cool-java/src/main/java/org/cool/java/mysql/export/mybatis";
	// File[] files = new File(folder).listFiles(new FileFilter() {
	// @Override
	// public boolean accept(File pathname) {
	// return pathname.getName().contains("Util.java");
	// }
	// });
	// String format = "TEMPLATE_%s_TO = PATH_PACKAGE_UTIL";
	// for (File file : files) {
	// System.out.println(String.format(format, file.getName().substring(0, file.getName().lastIndexOf("."))));
	// }












}
