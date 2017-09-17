package cn.lastmiles.database.auto.sql;

public interface IAutoDataSqlFactory {

	public IConstraintSql getConstraintSql();

	public IAlterColumnSql getAlterColumnSql();

	public IAlterForeignKeySql getAlterForeignKeySql();

	public IAlterPrimaryKeySql getAlterPrimaryKeySql();

	public ICreateTableSql getCreateTableSql();

	public IDropAllConstraintSql getDropAllConstraintSql();

	public IDropPrimaryKeySql getDropPrimaryKeySql();

	public IDropTableSql getDropTableSql();

	public IColumnTypeMap getColumnTypeMap();
}
