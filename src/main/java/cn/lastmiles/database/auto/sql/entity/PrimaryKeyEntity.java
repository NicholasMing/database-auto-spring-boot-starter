package cn.lastmiles.database.auto.sql.entity;

import java.util.ArrayList;
import java.util.List;

public class PrimaryKeyEntity {

	private String tableName;

	private String primaryKeyName;

	private List<ColumnEntity> primaryKeyColumns;

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getPrimaryKeyName() {
		return primaryKeyName;
	}

	public void setPrimaryKeyName(String primaryKeyName) {
		this.primaryKeyName = primaryKeyName;
	}

	public List<ColumnEntity> getPrimaryKeyColumns() {
		return primaryKeyColumns;
	}

	public void setPrimaryKeyColumns(List<ColumnEntity> primaryKeyColumns) {
		this.primaryKeyColumns = primaryKeyColumns;
	}

	public void addPrimaryKeyColumn(ColumnEntity columnEntity) {
		if (this.primaryKeyColumns == null) {
			this.primaryKeyColumns = new ArrayList<ColumnEntity>();
			this.primaryKeyColumns.add(columnEntity);
		} else {
			this.primaryKeyColumns.add(columnEntity);
		}
	}
}
