package kr.co.goodee39.date1110;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;

import java.lang.annotation.Target;

@Target({ TYPE, FIELD, METHOD })
public @interface AnnotationExample2 {
	String value() default "";
	int elementValue() default 1;
}
