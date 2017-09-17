package cn.lastmiles.database.auto.type;

public enum ColumnType {
    AUTO,
    VARCHAR(255),
    INT,
    BIGINT(20),
    TINYINT(1),
    SMALLINT(2),
    TEXT,
    DATE,
    DATETIME,
    DECIMAL;

    ColumnType() {
        this.length = 0;
    }

    ColumnType(Integer length) {
        this.length = length;
    }

    private Integer length;

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }


}
