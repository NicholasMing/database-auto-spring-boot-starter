package cn.lastmiles.database.auto.annotation;

import java.lang.annotation.*;

@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface Table {

	public abstract String tableName() default "";

	public abstract String comment() default "";

	public abstract String engine() default "InnoDB";

	public abstract String defaultCharset() default "utf8";
}
