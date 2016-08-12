/**
 * 
 */
package org.cool.java.mysql.export.mybatis;

/**
 * @author Colin
 */
public class ColumnDefine {

	/**
	 * 
	 */
	public ColumnDefine() {
	}

	public String name;
	public int typeInt = 0;
	public String type;
	public boolean isPrimayKey = false;
	public boolean isAutoIncrement = false;
	public boolean isCanBeNull = true;
	public String javaType;
	public int len;

	public String getJavaName(String prefix) {
		char c1 = name.charAt(0);
		return prefix + (c1 + "").toUpperCase() + name.substring(1);
	}

}
