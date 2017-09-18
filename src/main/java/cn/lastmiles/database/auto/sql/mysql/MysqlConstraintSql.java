package cn.lastmiles.database.auto.sql.mysql;

import cn.lastmiles.database.auto.driver.AutoDataSourceParam;
import cn.lastmiles.database.auto.sql.BaseSql;
import cn.lastmiles.database.auto.sql.IConstraintSql;

public class MysqlConstraintSql extends BaseSql implements IConstraintSql {

	public void init(AutoDataSourceParam autoDataSourceParam, boolean enable) {
		StringBuffer sql = new StringBuffer();
		if (autoDataSourceParam.isFormatSql()) {
			sql.append("\n");
		}
		sql.append("SET FOREIGN_KEY_CHECKS = ");
		sql.append(enable ? "1" : "0");
		sql.append(";");
		this.sqls.add(sql.toString());
	}
}
