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
database.auto.package-name 不填写，则不更新表结构，上线前请删除该配置

```

### 示例代码
```

import cn.lastmiles.database.auto.annotation.Column;
import cn.lastmiles.database.auto.annotation.Id;
import cn.lastmiles.database.auto.annotation.Table;
import cn.lastmiles.database.auto.type.ColumnType;

import java.util.Date;

@Table(tableName = "wechat_fans", comment = "微信用户粉丝表")
public class WechatFans {
    @Column
    @Id
    private Long id;

    @Column(comment = "名称")
    private String name;

    @Column(length = 100)
    private String openId;

    @Column
    private Date createdTime;

    @Column(type = ColumnType.SMALLINT)
    private Integer isDeleted;

    @Column
    private Date lastModifyDate;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Date getLastModifyDate() {
        return lastModifyDate;
    }

    public void setLastModifyDate(Date lastModifyDate) {
        this.lastModifyDate = lastModifyDate;
    }
}
```