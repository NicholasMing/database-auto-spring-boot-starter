package cn.lastmiles.database.auto.annotation;

import cn.lastmiles.database.auto.type.IdType;

import java.lang.annotation.*;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface Id {

	public abstract String primaryKeyName() default "";

	public abstract IdType idType() default IdType.SIMPLE;

	public abstract boolean nullable() default false;

}
