package cn.lastmiles.database.auto.annotation;

import cn.lastmiles.database.auto.type.ColumnType;

import java.lang.annotation.*;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface Column {
	public abstract String columnName() default "";

	public abstract ForeignKey[] fKey() default {};

	public abstract ColumnType type() default ColumnType.AUTO;

	public abstract int length() default 255;

	public abstract boolean nullable() default true;

	public abstract String comment() default "";

}
