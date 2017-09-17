package cn.lastmiles.database.auto.sql;

import cn.lastmiles.database.auto.driver.AutoDataSourceParam;

public interface IConstraintSql extends IBaseSql {

	/**
	 * 
	 * Initialize SQL statement
	 * 
	 * @param autoDataSourceParam
	 *            autoDataSourceParam
	 * @param enable
	 *            enable
	 */
	public void init(AutoDataSourceParam autoDataSourceParam, boolean enable);

}
