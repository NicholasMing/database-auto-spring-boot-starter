package cn.lastmiles.database.auto.sql;

import java.util.List;

public interface IBaseSql {

	/**
	 * 
	 * Get SQL statements
	 * 
	 * @return SQL statements
	 */
	public List<String> getSqls();
}
