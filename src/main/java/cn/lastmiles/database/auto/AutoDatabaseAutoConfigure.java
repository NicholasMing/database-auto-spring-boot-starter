package cn.lastmiles.database.auto;

import cn.lastmiles.database.auto.driver.AutoDataSourceDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableConfigurationProperties(AutoDatabaseProperties.class)
@ConditionalOnProperty(prefix="database.auto",value = "package-name",matchIfMissing = false)
public class AutoDatabaseAutoConfigure {
    private Logger logger = LoggerFactory.getLogger(getClass());


    @Autowired
    private AutoDatabaseProperties autoDatabaseProperties;

    @Bean
    public AutoDataSourceDriver getAutoDataSourceDriver(DataSource dataSource) {
        AutoDataSourceDriver autoDataSourceDriver = new AutoDataSourceDriver();
        autoDataSourceDriver.setAuto(autoDatabaseProperties.getAutoName());
        autoDataSourceDriver.setShowSql(autoDatabaseProperties.isShowSql());
        autoDataSourceDriver.setFormatSql(true);
        autoDataSourceDriver.setTestSql("select 1 from dual;");
        List<String> list = new ArrayList();
        list.addAll(autoDatabaseProperties.getPackageName());
        autoDataSourceDriver.setAutoPackages(list.toArray(new String[list.size()]));
        autoDataSourceDriver.setDataSource(dataSource);
        autoDataSourceDriver.setDialectClassName(autoDatabaseProperties.getDialectClassName());

        try {
            autoDataSourceDriver.initialization();
            logger.info("cn.lastmiles.database.auto initialize database success");
        } catch (IllegalAccessException e) {
            logger.error("IllegalAccessException", e.getCause());
        } catch (IllegalArgumentException e) {
            logger.error("IllegalArgumentException", e.getCause());
        } catch (InvocationTargetException e) {
            logger.error("InvocationTargetException", e.getCause());
        } catch (NoSuchMethodException e) {
            logger.error("NoSuchMethodException", e.getCause());
        } catch (SecurityException e) {
            logger.error("SecurityException", e.getCause());
        } catch (Exception e) {
            logger.error(e.getMessage(), e.getCause());
        }

        return autoDataSourceDriver;
    }
}
