package cn.lastmiles.database.auto.sql;

import cn.lastmiles.database.auto.sql.entity.TableEntity;
import cn.lastmiles.database.auto.driver.AutoDataSourceParam;

public interface ICreateTableSql extends IBaseSql {
	
	/**
	 * 
	 * Initialize SQL statement
	 * 
	 * @param autoDataSourceParam
	 *            autoDataSourceParam
	 * @param tableEntity
	 *            tableEntity
	 */
	public void init(AutoDataSourceParam autoDataSourceParam,
                     TableEntity tableEntity);

}
