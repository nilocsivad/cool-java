/**
 * 
 */
package org.cool.java.mysql.data;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author Colin
 */
public class GenerateMYSqlData {

	/**
	 * 
	 */
	public GenerateMYSqlData() {
	}

	public Properties P;

	public void initProperties() throws IOException {

		P = P == null ? new Properties() : P;

		InputStream inputStream = GenerateMYSqlData.class.getClassLoader().getResourceAsStream("org/cool/java/mysql/data/dataformat.properties");
		P.load(inputStream);
		inputStream.close();
	}

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		GenerateMYSqlData instance = new GenerateMYSqlData();


		instance.initProperties();




		String format = instance.P.getProperty("FORMAT");

		for (int i = 0; i < 10; ++i) {
			System.out.println(String.format(format, i));
		}

	}

}
