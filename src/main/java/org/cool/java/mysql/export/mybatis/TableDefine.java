/**
 * 
 */
package org.cool.java.mysql.export.mybatis;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Colin
 */
public class TableDefine {

	private ITableBeanName tr;

	public interface ITableBeanName {
		String translateIt(String tableName);
	}

	/**
	 * 
	 */
	public TableDefine() {
	}

	public String name;
	public String primaryKey;
	public List<ColumnDefine> columns = new ArrayList<ColumnDefine>(8);

	public String getBeanName() {
		if (tr == null) {
			return name;
		}
		else {
			return tr.translateIt(name);
		}
	}

}
