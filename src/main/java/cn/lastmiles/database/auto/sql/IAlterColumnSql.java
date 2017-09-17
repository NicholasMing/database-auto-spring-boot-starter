package cn.lastmiles.database.auto.sql;

import cn.lastmiles.database.auto.driver.AutoDataSourceParam;
import cn.lastmiles.database.auto.sql.entity.TableEntity;

import java.sql.SQLException;

public interface IAlterColumnSql extends IBaseSql {

	/**
	 * 
	 * Initialize SQL statement
	 * 
	 * @param autoDataSourceParam
	 *            autoDataSourceParam
	 * @param tableEntity
	 *            tableEntity
	 * @throws SQLException
	 *             SQLException
	 */
	public void init(AutoDataSourceParam autoDataSourceParam,
                     TableEntity tableEntity) throws SQLException;

}
