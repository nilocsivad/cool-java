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
	public String comment;
	public List<ColumnDefine> columns = new ArrayList<ColumnDefine>(8);

}
