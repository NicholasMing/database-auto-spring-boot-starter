package cn.lastmiles.database.auto.sql.mysql;

import cn.lastmiles.database.auto.sql.IColumnTypeMap;
import cn.lastmiles.database.auto.type.ColumnType;
import cn.lastmiles.database.auto.sql.BaseSql;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MysqlColumnTypeMap extends BaseSql implements IColumnTypeMap {

    private Map<Class<?>, ColumnType> columnTypeMap;

    public MysqlColumnTypeMap() {
        columnTypeMap = new HashMap<Class<?>, ColumnType>();
        columnTypeMap.put(String.class, ColumnType.VARCHAR);
        columnTypeMap.put(Long.class, ColumnType.BIGINT);
        columnTypeMap.put(BigDecimal.class, ColumnType.DECIMAL);
        columnTypeMap.put(Date.class, ColumnType.DATETIME);
    }

    public ColumnType getColumnType(Class<?> clazz) {
        return columnTypeMap.get(clazz);
    }

}
