package cn.lastmiles.database.auto.sql.entity;

public class ColumnEntity {

    private String columnName;

    private String columnComment;

    private String columnType;

    private boolean hasLength;

    private int columnLength;

    private String columnNullable;

    private boolean isPrimaryKey;

    private String primaryKeyType;

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnComment() {
        return columnComment;
    }

    public void setColumnComment(String columnComment) {
        this.columnComment = columnComment;
    }

    public String getColumnType() {
        return columnType;
    }

    public void setColumnType(String columnType) {
        this.columnType = columnType;
    }

    public boolean isHasLength() {
        return hasLength;
    }

    public void setHasLength(boolean hasLength) {
        this.hasLength = hasLength;
    }

    public int getColumnLength() {
        return columnLength;
    }

    public void setColumnLength(int columnLength) {
        this.columnLength = columnLength;
    }

    public String getColumnNullable() {
        return columnNullable;
    }

    public void setColumnNullable(String columnNullable) {
        this.columnNullable = columnNullable;
    }

    public boolean isPrimaryKey() {
        return isPrimaryKey;
    }

    public void setPrimaryKey(boolean isPrimaryKey) {
        this.isPrimaryKey = isPrimaryKey;
    }

    public String getPrimaryKeyType() {
        return primaryKeyType;
    }

    public void setPrimaryKeyType(String primaryKeyType) {
        this.primaryKeyType = primaryKeyType;
    }

}
