package cn.lastmiles.database.auto.sql.entity;

import java.util.List;

public class TableEntity {

	private String tableName;

	private String tableComment;

	private String engine;

	private String defaultCharset;

	private List<ColumnEntity> columnEntities;

	private PrimaryKeyEntity primaryKeyEntity;

	private List<ForeignKeyEntity> foreignKeyEntites;

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getTableComment() {
		return tableComment;
	}

	public void setTableComment(String tableComment) {
		this.tableComment = tableComment;
	}

	public String getEngine() {
		return engine;
	}

	public void setEngine(String engine) {
		this.engine = engine;
	}

	public String getDefaultCharset() {
		return defaultCharset;
	}

	public void setDefaultCharset(String defaultCharset) {
		this.defaultCharset = defaultCharset;
	}

	public List<ColumnEntity> getColumnEntities() {
		return columnEntities;
	}

	public void setColumnEntities(List<ColumnEntity> columnEntities) {
		this.columnEntities = columnEntities;
	}

	public PrimaryKeyEntity getPrimaryKeyEntity() {
		return primaryKeyEntity;
	}

	public void setPrimaryKeyEntity(PrimaryKeyEntity primaryKeyEntity) {
		this.primaryKeyEntity = primaryKeyEntity;
	}

	public List<ForeignKeyEntity> getForeignKeyEntites() {
		return foreignKeyEntites;
	}

	public void setForeignKeyEntites(List<ForeignKeyEntity> foreignKeyEntites) {
		this.foreignKeyEntites = foreignKeyEntites;
	}

}
