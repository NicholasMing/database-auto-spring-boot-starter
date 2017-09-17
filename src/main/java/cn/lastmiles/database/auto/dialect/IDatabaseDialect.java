package cn.lastmiles.database.auto.dialect;

import java.sql.SQLException;

public interface IDatabaseDialect {

	/**
	 * 
	 * Invoke SQL statement
	 * 
	 * @throws SQLException
	 *             invoke SQL exception
	 */
	public void invoke() throws SQLException;
}
