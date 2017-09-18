package cn.lastmiles.database.auto.sql.mysql;

import cn.lastmiles.database.auto.driver.AutoDataSourceParam;
import cn.lastmiles.database.auto.sql.BaseSql;
import cn.lastmiles.database.auto.sql.IAlterTableSql;
import cn.lastmiles.database.auto.sql.entity.TableEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * check table has exsit
 */
public class MysqlAlterTableSql extends BaseSql implements
        IAlterTableSql {

    public AutoDataSourceParam init(AutoDataSourceParam autoDataSourceParam,
                                    TableEntity tableEntity) throws SQLException {
        // query primary keys and foreign keys
        StringBuffer queryConstraintSql = new StringBuffer();
        if (autoDataSourceParam.isFormatSql()) {
            queryConstraintSql.append("\n");
        }
        queryConstraintSql.append("SELECT ");
        queryConstraintSql.append("CONSTRAINT_NAME");
        queryConstraintSql.append(",");
        queryConstraintSql.append(" ");
        queryConstraintSql.append("COLUMN_NAME");
        queryConstraintSql.append(",");
        queryConstraintSql.append(" ");
        queryConstraintSql.append("REFERENCED_TABLE_NAME");
        queryConstraintSql.append(" ");
        queryConstraintSql.append("FROM INFORMATION_SCHEMA.KEY_COLUMN_USAGE");
        queryConstraintSql.append(" ");
        queryConstraintSql.append("WHERE TABLE_NAME = '"
                + tableEntity.getTableName() + "'");
        queryConstraintSql.append(" ");
        queryConstraintSql.append("AND");
        queryConstraintSql.append(" ");
        queryConstraintSql.append("TABLE_SCHEMA = ");
        queryConstraintSql.append("'"
                + autoDataSourceParam.getConnection().getCatalog() + "'");
        queryConstraintSql.append(";");
        if (autoDataSourceParam.isShowSql()) {
            logger.info("database auto sql : " + queryConstraintSql.toString());
        }
        ResultSet resultSet = this.executeQuery(autoDataSourceParam,
                queryConstraintSql.toString());

        autoDataSourceParam.setAuto("create");
        while (resultSet.next()) {
            autoDataSourceParam.setAuto("update");
        }
        return autoDataSourceParam;
    }
}
