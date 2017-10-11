package com.ideal.interceptor;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

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