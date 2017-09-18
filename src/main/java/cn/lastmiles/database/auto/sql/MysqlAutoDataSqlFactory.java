package cn.lastmiles.database.auto.sql;

import cn.lastmiles.database.auto.sql.mysql.*;


public class MysqlAutoDataSqlFactory implements IAutoDataSqlFactory {

    public IAlterColumnSql getAlterColumnSql() {
        return new MysqlAlterColumnSql();
    }

    public IAlterForeignKeySql getAlterForeignKeySql() {
        return new MysqlAlterForeignKeySql();
    }

    public IAlterPrimaryKeySql getAlterPrimaryKeySql() {
        return new MysqlAlterPrimaryKeySql();
    }

    public IAlterTableSql getAlterTableSql() {
        return new MysqlAlterTableSql();
    }

    public IConstraintSql getConstraintSql() {
        return new MysqlConstraintSql();
    }

    public ICreateTableSql getCreateTableSql() {
        return new MysqlCreateTableSql();
    }

    public IDropAllConstraintSql getDropAllConstraintSql() {
        return new MysqlDropAllConstraintSql();
    }

    public IDropPrimaryKeySql getDropPrimaryKeySql() {
        return new MysqlDropPrimaryKeySql();
    }

    public IDropTableSql getDropTableSql() {
        return new MysqlDropTableSql();
    }

    public IColumnTypeMap getColumnTypeMap() {
        return new MysqlColumnTypeMap();
    }

}
