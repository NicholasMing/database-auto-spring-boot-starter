package cn.lastmiles.database.auto.sql;

import cn.lastmiles.database.auto.driver.AutoDataSourceParam;
import cn.lastmiles.database.auto.sql.entity.TableEntity;

import java.sql.SQLException;

public interface IAlterTableSql extends IBaseSql {

    /**
     * Initialize SQL statement
     *
     * @param autoDataSourceParam autoDataSourceParam
     * @param tableEntity         tableEntity
     * @throws SQLException SQLException
     */
    public AutoDataSourceParam init(AutoDataSourceParam autoDataSourceParam,
                                    TableEntity tableEntity) throws SQLException;

}
