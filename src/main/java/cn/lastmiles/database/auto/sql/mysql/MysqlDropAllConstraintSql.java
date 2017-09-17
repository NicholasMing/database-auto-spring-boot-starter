package cn.lastmiles.database.auto.sql.mysql;

import cn.lastmiles.database.auto.driver.AutoDataSourceParam;
import cn.lastmiles.database.auto.sql.BaseSql;
import cn.lastmiles.database.auto.sql.IDropAllConstraintSql;
import cn.lastmiles.database.auto.sql.entity.TableEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MysqlDropAllConstraintSql extends BaseSql implements
		IDropAllConstraintSql {

	@Override
	public void init(AutoDataSourceParam autoDataSourceParam,
			TableEntity tableEntity) throws SQLException {
		List<String> primaryKeySqls = new ArrayList<String>();
		List<String> foreignKeySqls = new ArrayList<String>();
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
			logger.info("mybatiSql : " + queryConstraintSql.toString());
		}
		boolean isExsitPrimaryKey = false;
		ResultSet resultSet = this.executeQuery(autoDataSourceParam,
				queryConstraintSql.toString());
		while (resultSet.next()) {
			// drop all foreign keys + drop indexes for foreign keys
			if (resultSet.getString("REFERENCED_TABLE_NAME") != null
					&& !"".equals(resultSet.getString("REFERENCED_TABLE_NAME"))) {
				System.out.println("================="
						+ resultSet.getString("REFERENCED_TABLE_NAME"));
				StringBuffer dropForeignKeySql = new StringBuffer();
				if (autoDataSourceParam.isFormatSql()) {
					dropForeignKeySql.append("\n");
				}
				dropForeignKeySql.append("ALTER TABLE");
				dropForeignKeySql.append(" ");
				dropForeignKeySql.append(tableEntity.getTableName());
				dropForeignKeySql.append(" ");
				dropForeignKeySql.append("DROP FOREIGN KEY");
				dropForeignKeySql.append(" ");
				dropForeignKeySql
						.append(resultSet.getString("CONSTRAINT_NAME"));
				dropForeignKeySql.append(";");
				foreignKeySqls.add(dropForeignKeySql.toString());
				StringBuffer dropIndexSql = new StringBuffer();
				if (autoDataSourceParam.isFormatSql()) {
					dropIndexSql.append("\n");
				}
				dropIndexSql.append("ALTER TABLE");
				dropIndexSql.append(" ");
				dropIndexSql.append(tableEntity.getTableName());
				dropIndexSql.append(" ");
				dropIndexSql.append("DROP INDEX");
				dropIndexSql.append(" ");
				dropIndexSql.append(resultSet.getString("CONSTRAINT_NAME"));
				dropIndexSql.append(";");
				foreignKeySqls.add(dropIndexSql.toString());
			} else
			// alter primary keys
			{
				StringBuffer alterPrimaryKeySql = new StringBuffer();
				if (autoDataSourceParam.isFormatSql()) {
					alterPrimaryKeySql.append("\n");
				}
				alterPrimaryKeySql.append("ALTER TABLE");
				alterPrimaryKeySql.append(" ");
				alterPrimaryKeySql.append(tableEntity.getTableName());
				alterPrimaryKeySql.append(" ");
				alterPrimaryKeySql.append("MODIFY");
				alterPrimaryKeySql.append(" ");
				alterPrimaryKeySql.append(resultSet.getString("COLUMN_NAME"));
				alterPrimaryKeySql.append(" ");
				alterPrimaryKeySql.append("VARCHAR(255)");
				alterPrimaryKeySql.append(" ");
				alterPrimaryKeySql.append("NOT NULL");
				alterPrimaryKeySql.append(";");
				primaryKeySqls.add(alterPrimaryKeySql.toString());
				isExsitPrimaryKey = true;
			}
		}
		// drop all primary key
		if (isExsitPrimaryKey) {
			StringBuffer dropPrimaryKeySql = new StringBuffer();
			if (autoDataSourceParam.isFormatSql()) {
				dropPrimaryKeySql.append("\n");
			}
			dropPrimaryKeySql.append("ALTER TABLE");
			dropPrimaryKeySql.append(" ");
			dropPrimaryKeySql.append(tableEntity.getTableName());
			dropPrimaryKeySql.append(" ");
			dropPrimaryKeySql.append("DROP PRIMARY KEY");
			dropPrimaryKeySql.append(";");
			primaryKeySqls.add(dropPrimaryKeySql.toString());
		}
		this.sqls.addAll(foreignKeySqls);
		this.sqls.addAll(primaryKeySqls);
	}
}
