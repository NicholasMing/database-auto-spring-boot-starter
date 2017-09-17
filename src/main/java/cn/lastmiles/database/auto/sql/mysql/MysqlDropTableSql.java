package cn.lastmiles.database.auto.sql.mysql;

import cn.lastmiles.database.auto.sql.BaseSql;
import cn.lastmiles.database.auto.sql.IDropTableSql;
import cn.lastmiles.database.auto.sql.entity.TableEntity;
import cn.lastmiles.database.auto.driver.AutoDataSourceParam;

public class MysqlDropTableSql extends BaseSql implements IDropTableSql {

	@Override
	public void init(AutoDataSourceParam autoDataSourceParam,
			TableEntity tableEntity) {
		StringBuffer sql = new StringBuffer();
		if (autoDataSourceParam.isFormatSql()) {
			sql.append("\n");
		}
		sql.append("DROP TABLE IF EXISTS ");
		sql.append(tableEntity.getTableName());
		sql.append(";");
		sqls.add(sql.toString());
	}

}
