package cn.lastmiles.database.auto.driver;

import java.sql.Connection;
import java.util.List;

public class AutoDataSourceParam {

	private Connection connection;

	private boolean isShowSql;

	private boolean isFormatSql;

	private String auto;

	private List<Class<?>> clazzes;

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public boolean isShowSql() {
		return isShowSql;
	}

	public void setShowSql(boolean isShowSql) {
		this.isShowSql = isShowSql;
	}

	public boolean isFormatSql() {
		return isFormatSql;
	}

	public void setFormatSql(boolean isFormatSql) {
		this.isFormatSql = isFormatSql;
	}

	public String getAuto() {
		return auto;
	}

	public void setAuto(String auto) {
		this.auto = auto;
	}

	public List<Class<?>> getClazzes() {
		return clazzes;
	}

	public void setClazzes(List<Class<?>> clazzes) {
		this.clazzes = clazzes;
	}

	/**
	 * 
	 * Constructor
	 * 
	 * @param connection
	 *            connection
	 * @param isShowSql
	 *            isShowSql
	 * @param isFormatSql
	 *            isFormatSql
	 * @param auto
	 *            org.mybatis.extension.auto type
	 * @param clazzes
	 *            pojo classes
	 */
	public AutoDataSourceParam(Connection connection, boolean isShowSql,
			boolean isFormatSql, String auto, List<Class<?>> clazzes) {
		this.connection = connection;
		this.isShowSql = isShowSql;
		this.isFormatSql = isFormatSql;
		this.auto = auto;
		this.clazzes = clazzes;
	}
}
