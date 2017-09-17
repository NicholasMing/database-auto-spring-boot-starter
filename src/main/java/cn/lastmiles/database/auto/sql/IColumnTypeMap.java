package cn.lastmiles.database.auto.sql;

import cn.lastmiles.database.auto.type.ColumnType;

public interface IColumnTypeMap extends IBaseSql {

	/**
	 * 
	 * Get column type
	 * 
	 * @param clazz
	 *            class
	 * @return ColumnType
	 */
	public ColumnType getColumnType(Class<?> clazz);

}
