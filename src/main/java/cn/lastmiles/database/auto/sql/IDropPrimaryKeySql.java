package cn.lastmiles.database.auto.sql;

import cn.lastmiles.database.auto.driver.AutoDataSourceParam;
import cn.lastmiles.database.auto.sql.entity.TableEntity;

public interface IDropPrimaryKeySql extends IBaseSql {
	
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
