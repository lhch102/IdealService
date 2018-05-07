package com.ideal.interceptor;

<<<<<<< HEAD
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

=======
>>>>>>> 0f20d1b658da6a3bb0fdbefd72e57e05a22705ce
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