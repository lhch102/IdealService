package com.ideal.interceptor;

/**
 * dao注解
 */
//@Retention(RetentionPolicy.RUNTIME)
//@Target(ElementType.TYPE)
//@Documented
//@Component
public @interface Mapper {
	
	String value() default "";

}