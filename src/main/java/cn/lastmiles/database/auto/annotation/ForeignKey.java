package cn.lastmiles.database.auto.annotation;

import java.lang.annotation.*;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface ForeignKey {

	public abstract String foreignKeyName() default "";

	public abstract String tableName();

	public abstract String columnName();
}
