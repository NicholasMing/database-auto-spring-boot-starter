package cn.lastmiles.database.auto.sql.mysql;

import cn.lastmiles.database.auto.sql.BaseSql;
import cn.lastmiles.database.auto.sql.IAlterPrimaryKeySql;
import cn.lastmiles.database.auto.sql.entity.ColumnEntity;
import cn.lastmiles.database.auto.sql.entity.TableEntity;
import cn.lastmiles.database.auto.type.ColumnType;
import cn.lastmiles.database.auto.type.IdType;
import cn.lastmiles.database.auto.driver.AutoDataSourceParam;

import java.util.ArrayList;
import java.util.List;

public class MysqlAlterPrimaryKeySql extends BaseSql implements
        IAlterPrimaryKeySql {

    @Override
    public void init(AutoDataSourceParam autoDataSourceParam,
                     TableEntity tableEntity) {
        if (tableEntity.getPrimaryKeyEntity() == null
                || tableEntity.getPrimaryKeyEntity().getTableName() == null
                || "".equals(tableEntity.getPrimaryKeyEntity().getTableName())) {
            return;
        }
        StringBuffer sql = new StringBuffer();
        List<String> columnModifySqls = new ArrayList<String>();
        if (autoDataSourceParam.isFormatSql()) {
            sql.append("\n");
        }
        sql.append("ALTER TABLE");
        sql.append(" ");
        sql.append(tableEntity.getTableName());
        sql.append(" ");
        sql.append("ADD PRIMARY KEY");
        sql.append(" ");
        sql.append("(");
        for (ColumnEntity columnEntity : tableEntity.getPrimaryKeyEntity()
                .getPrimaryKeyColumns()) {
            sql.append(columnEntity.getColumnName() + ",");
            if (columnEntity.getPrimaryKeyType() != null
                    && !"".equals(columnEntity.getPrimaryKeyType())) {
                StringBuffer columnChangeSql = new StringBuffer();
                if (autoDataSourceParam.isFormatSql()) {
                    columnChangeSql.append("\n");
                }
                columnChangeSql.append("ALTER TABLE");
                columnChangeSql.append(" ");
                columnChangeSql.append(tableEntity.getTableName());
                columnChangeSql.append(" ");
                columnChangeSql.append("MODIFY");
                columnChangeSql.append(" ");
                columnChangeSql.append(columnEntity.getColumnName());
                columnChangeSql.append(" ");
                if (columnEntity.getPrimaryKeyType().equalsIgnoreCase(
                        IdType.AUTO_INCREMENT.toString())) {
                    columnChangeSql.append(ColumnType.INT.toString());
                    columnChangeSql.append("(11)");
                } else {
                    columnChangeSql.append(columnEntity.getColumnType());
                    if (columnEntity.isHasLength()) {
                        columnChangeSql.append("(" + columnEntity.getColumnLength() + ")");
                    }
                }
                columnChangeSql.append(" ");
                columnChangeSql.append(columnEntity.getPrimaryKeyType());
                columnChangeSql.append(";");
                columnModifySqls.add(columnChangeSql.toString());
            }
        }
        sql.deleteCharAt(sql.lastIndexOf(","));
        sql.append(");");
        this.sqls.add(sql.toString());
        this.sqls.addAll(columnModifySqls);
    }
}
