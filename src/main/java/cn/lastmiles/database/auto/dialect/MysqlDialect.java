package cn.lastmiles.database.auto.dialect;

import cn.lastmiles.database.auto.sql.MysqlAutoDataSqlFactory;
import cn.lastmiles.database.auto.driver.AutoDataSourceParam;

import java.sql.SQLException;


public class MysqlDialect extends DatabaseDialect {

	public MysqlDialect(AutoDataSourceParam autoDataSourceParam) {
		super(autoDataSourceParam);
		this.autoDataSqlFactory = new MysqlAutoDataSqlFactory();
	}

	@Override
	protected void create() throws SQLException {
		super.create();
	}

	@Override
	protected void update() throws SQLException {
		super.update();
	}

}
