/**
 * 
 */
package org.cool.java.mysql.export.mybatis;

import java.util.List;
import java.util.Properties;

import org.apache.velocity.app.Velocity;
import org.cool.java.mysql.export.mybatis.TableDefine.ITableBeanName;

import com.google.gson.Gson;

/**
 * @author Colin
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
		ExportMYSQL2Mybatis run = new ExportMYSQL2Mybatis();




		PropertiesWithFolder first = new PropertiesWithFolder();

		String tempDir = System.getProperty("java.io.tmpdir");
		Properties properties = new Properties();
		properties.setProperty(Velocity.FILE_RESOURCE_LOADER_PATH, tempDir);
		Velocity.init(properties);

		/// 读取配置文件 ///
		first.initProperties();
		// first.printProperties();
		/// 创建文件夹 ///
		first.initFolders();
		/// 复制模版文件 ///
		first.cpTemplate();




		Gson gson = new Gson();

		DBAndTable dbt = new DBAndTable(first);
		// dbt.printTypeMap();



		List<TableDefine> list = dbt.getTables("sale_detail", "group_man");
		/// 生成 Bean ///
		first.toModel(list, run.new NameRuleQTUnderline());

		// List<TableDefine> list = dbt.getTables("ht_sale_number");
		// /// 生成 Bean ///
		// first.toModel(list, run.new NameRuleHTUnderline());


		list.forEach(tb -> {
			System.out.println(gson.toJson(tb));
		});




	}



	class NameRuleUnderline implements ITableBeanName {

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
			buf.append("Model");
			return buf.toString();
		}

	}

	class NameRuleQTUnderline implements ITableBeanName {

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
			buf.append("$");
			for (String str : arr) {
				buf.append(zeroToUpper(str));
			}
			buf.append("Model");
			return buf.toString();
		}

	}

	class NameRuleHTUnderline implements ITableBeanName {

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
			buf.append("_");
			for (String str : arr) {
				buf.append(zeroToUpper(str));
			}
			buf.append("Model");
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
