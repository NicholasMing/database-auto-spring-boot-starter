package cn.lastmiles.database.auto.sql.entity;


public class ForeignKeyEntity {

	private String foreignKeyName;

	private String tableName;

	private String columnName;

	private String foreignKeyTableName;

	private String foreignKeyColumnName;

	public String getForeignKeyName() {
		return foreignKeyName;
	}

	public void setForeignKeyName(String foreignKeyName) {
		this.foreignKeyName = foreignKeyName;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getForeignKeyTableName() {
		return foreignKeyTableName;
	}

	public void setForeignKeyTableName(String foreignKeyTableName) {
		this.foreignKeyTableName = foreignKeyTableName;
	}

	public String getForeignKeyColumnName() {
		return foreignKeyColumnName;
	}

	public void setForeignKeyColumnName(String foreignKeyColumnName) {
		this.foreignKeyColumnName = foreignKeyColumnName;
	}

}
