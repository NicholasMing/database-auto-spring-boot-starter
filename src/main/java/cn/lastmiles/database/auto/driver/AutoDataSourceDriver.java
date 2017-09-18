package cn.lastmiles.database.auto.driver;

import cn.lastmiles.database.auto.dialect.IDatabaseDialect;
import cn.lastmiles.database.auto.parse.EntityParseScanPackage;
import cn.lastmiles.database.auto.type.AutoType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.lang.reflect.Constructor;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AutoDataSourceDriver {
    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * Automatically create table type, optional values: 'create' or 'update' or
     * 'none'
     */
    private String auto;

    /**
     * Whether to print the SQL statement, optional values: 'true' or 'false'
     */
    private boolean showSql;
    /**
     * Whether to format the SQL statement, optional values: 'true' or 'false'
     * TODO
     */
    private boolean formatSql;

    /**
     * Test the SQL statement。
     */
    private String testSql;

    /**
     * Automatically create table scan package.<b>required</b>
     */
    private String[] autoPackages;

    /**
     * According to the different database dialect, generate relational database
     * table SQL, and executed。<b>required</b>
     */
    private String dialectClassName;

    /**
     * DataSource object.<b>required</b>
     */
    private DataSource dataSource;

    public String getAuto() {
        return auto;
    }

    public void setAuto(String auto) {
        this.auto = auto;
    }

    public boolean isShowSql() {
        return showSql;
    }

    public void setShowSql(boolean showSql) {
        this.showSql = showSql;
    }

    public boolean isFormatSql() {
        return formatSql;
    }

    public void setFormatSql(boolean formatSql) {
        this.formatSql = formatSql;
    }

    public String getTestSql() {
        return testSql;
    }

    public void setTestSql(String testSql) {
        this.testSql = testSql;
    }

    public String[] getAutoPackages() {
        return autoPackages;
    }

    public void setAutoPackages(String[] autoPackages) {
        this.autoPackages = autoPackages;
    }

    public String getDialectClassName() {
        return dialectClassName;
    }

    public void setDialectClassName(String dialectClassName) {
        this.dialectClassName = dialectClassName;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * AutoDataSourceDriver initialize function. By listener calls.
     *
     * @throws SQLException           SQLException
     * @throws ClassNotFoundException ClassNotFoundException
     * @throws InstantiationException InstantiationException
     * @throws IllegalAccessException IllegalAccessException
     * @throws Exception              Exception
     */
    public void initialization() throws Exception {
        this.testSql();
        if (this.getAuto().equalsIgnoreCase(AutoType.NONE.toString())) {
            return;
        }

        List<Class<?>> clazzes = new ArrayList<Class<?>>();
        for (String autoPackage : this.getAutoPackages()) {
            logger.info("EntityParseScanPackage : " + autoPackage);
            logger.info("EntityParseScanPackage size : "
                    + EntityParseScanPackage.getClassName(autoPackage));
            clazzes.addAll(EntityParseScanPackage.getClassName(autoPackage));
        }
        logger.info("EntityParseScanPackage clazzes size : " + clazzes.size());
        for (Class<?> clazz : clazzes) {
            logger.info("EntityParseScanPackage clazzes : " + clazz.getName());
        }
        Class<?> dialectClass = Class.forName(this.getDialectClassName());
        AutoDataSourceParam autoDataSourceParam = new AutoDataSourceParam(this
                .getDataSource().getConnection(), this.isShowSql(),
                this.isFormatSql(), this.getAuto(), clazzes);
        Constructor<?> constructor = dialectClass
                .getConstructor(AutoDataSourceParam.class);
        IDatabaseDialect databaseDialect = (IDatabaseDialect) constructor
                .newInstance(autoDataSourceParam);
        databaseDialect.invoke();
    }

    /**
     * Execute the test SQL statement.
     *
     * @throws SQLException
     */
    private void testSql() throws SQLException {
        Connection connection = this.getDataSource().getConnection();
        Statement statement = connection.createStatement();
        if (this.getTestSql() == null) {
            return;
        }
        ResultSet resultSet = statement.executeQuery(this.getTestSql());
        resultSet.last();
        if (resultSet.getRow() == 0) {
            return;
        }
        if (this.isShowSql()) {
            logger.info("test database success:" + this.getTestSql());
        } else {
            logger.info("test database success");
        }
    }
}
