# spring boot 自动建表
>根据entity自动建表，目前仅支持mysql 
## 一、添加依赖
```
   <dependency>
            <groupId>cn.lastmiles</groupId>
            <artifactId>database.auto</artifactId>
            <version>1.0</version>
   </dependency>
```
## 二、在application.properties中添加配置
database.auto.package-name=com.ming.weapp
>实体类所在的包名（必填）

database.auto.show-sql=true
>是否显示sql语句，默认不显示

## 说明
```
database.auto.package-name 不填写，则不更新表结构，上线前请删除改配置

```