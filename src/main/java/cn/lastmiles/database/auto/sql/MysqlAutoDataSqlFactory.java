package cn.lastmiles.database.auto.sql;

import cn.lastmiles.database.auto.sql.mysql.*;


public class MysqlAutoDataSqlFactory implements IAutoDataSqlFactory {

	@Override
	public IAlterColumnSql getAlterColumnSql() {
		return new MysqlAlterColumnSql();
	}

	@Override
	public IAlterForeignKeySql getAlterForeignKeySql() {
		return new MysqlAlterForeignKeySql();
	}

	@Override
	public IAlterPrimaryKeySql getAlterPrimaryKeySql() {
		return new MysqlAlterPrimaryKeySql();
	}

	@Override
	public IConstraintSql getConstraintSql() {
		return new MysqlConstraintSql();
	}

	@Override
	public ICreateTableSql getCreateTableSql() {
		return new MysqlCreateTableSql();
	}

	@Override
	public IDropAllConstraintSql getDropAllConstraintSql() {
		return new MysqlDropAllConstraintSql();
	}

	@Override
	public IDropPrimaryKeySql getDropPrimaryKeySql() {
		return new MysqlDropPrimaryKeySql();
	}

	@Override
	public IDropTableSql getDropTableSql() {
		return new MysqlDropTableSql();
	}

	@Override
	public IColumnTypeMap getColumnTypeMap() {
		return new MysqlColumnTypeMap();
	}

}
