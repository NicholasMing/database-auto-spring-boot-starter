package cn.lastmiles.database.auto;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@ConfigurationProperties(prefix = "database.auto")
public class AutoDatabaseProperties {
    private String autoName = "update";
    private boolean showSql;
    private List<String> packageName;
    private String dialectClassName = "cn.lastmiles.database.auto.dialect.MysqlDialect";

    public String getAutoName() {
        return autoName;
    }

    public void setAutoName(String autoName) {
        this.autoName = autoName;
    }

    public boolean isShowSql() {
        return showSql;
    }

    public void setShowSql(boolean showSql) {
        this.showSql = showSql;
    }

    public List<String> getPackageName() {
        return packageName;
    }

    public void setPackageName(List<String> packageName) {
        this.packageName = packageName;
    }

    public String getDialectClassName() {
        return dialectClassName;
    }

    public void setDialectClassName(String dialectClassName) {
        this.dialectClassName = dialectClassName;
    }
}
