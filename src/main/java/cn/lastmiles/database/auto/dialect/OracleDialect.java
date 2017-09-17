package cn.lastmiles.database.auto.dialect;

import cn.lastmiles.database.auto.driver.AutoDataSourceParam;

import java.sql.SQLException;

public class OracleDialect extends DatabaseDialect {

	public OracleDialect(AutoDataSourceParam autoDataSourceParam) {
		super(autoDataSourceParam);
		// TODO Auto-generated method stub
		
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
