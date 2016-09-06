/**
 * 
 */
package org.cool.java.mysql.export.ibatis;

import java.io.File;
import java.io.InputStream;
import java.util.List;

import org.cool.java.mysql.export.DBAndTable;
import org.cool.java.mysql.export.TableDefine;
import org.cool.java.mysql.export.TableDefine.ITableBeanName;
import org.cool.java.mysql.export.ibatis.IbatisPropertiesWithFolder;

import com.google.gson.Gson;

/**
 * @author Colin
 */
public class Table2Ibatis {

	/**
	 * 
	 */
	public Table2Ibatis() {
	}


	public static void main3s(String[] args) {

		String ttt = "sdfaodifjqopig";
		System.out.println(ttt.substring(0, 50));

	}


	public static void main22(String[] args) {
		File folder = new File("E:/javadb/space-java2", "/cool-java/src/main/resources/template/ibatis");
		for (File f : folder.listFiles()) {
			String fn = f.getName();
			// if (fn.endsWith(".vm") && !fn.endsWith(".java.vm")) {
			// String name = fn.replace(".vm", ".java.vm");
			// f.renameTo(new File(folder, name));
			// }
			if (fn.endsWith(".java")) {
				String name = fn.replace(".java", ".java.vm");
				f.renameTo(new File(folder, name));
			}
		}
	}


	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		Table2Ibatis run = new Table2Ibatis();

		// ClassLoader cl = run.getClass().getClassLoader();
		// URL url = cl.getResource("template/IAPP.java.bin");
		// System.out.println(url.getFile());
		// File f = new File(url.getFile());
		// System.out.println(f.getAbsolutePath());
		// System.out.format("length of file is %d \r\n", f.length());
		// System.out.printf("length of file is %d \r\n", f.length());


		IbatisPropertiesWithFolder first = new IbatisPropertiesWithFolder();

		// String tempDir = System.getProperty("java.io.tmpdir");
		// Properties properties = new Properties();
		// properties.setProperty(Velocity.FILE_RESOURCE_LOADER_PATH, tempDir);
		// Velocity.init(properties);

		/// 读取配置文件并初始化 ///
		InputStream in = run.getClass().getClassLoader().getResourceAsStream("table2-ibatis.properties");
		first.initProperties(in);
		in.close();

		// first.printProperties();
		/// 创建文件夹 ///
		first.initFolders();
		// /// 复制模版文件 ///
		// first.cpTemplate();




		Gson gson = new Gson();

		DBAndTable dbt = new DBAndTable(first);
		// dbt.printTypeMap();



		ITableBeanName rule = run.new NameRuleNoUnderline();
		List<TableDefine> list = dbt.getTables("news", "manager", "manager_code", "contacts", "remote_care", "target", "versions", "feedback", "manager_heartrate", "manager_sleep", "manager_motion", "manager_position");
		// ITableBeanName rule = run.new NameRuleHTUnderline();
		// List<TableDefine> list = dbt.getTables("ht_sale_number");



		/// 生成 Bean ///
		first.toModel(list, rule);
		/// 生成业务逻辑接口 ///
		first.toInterface(list, rule);
		/// 生成逻辑实现 ///
		first.toImplement(list, rule);
		/// 生成 XML 文件 ///
		first.toXML(list, rule);
		// ///
		first.toPhoneRequest(list, rule);



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
