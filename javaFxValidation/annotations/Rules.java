package javaFxValidation.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This annotation is used to bind validation rules with a field.
 * field is the name of the field.
 * rules is the wanted rules to be bound with the field.
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Rules {
	public String field();
	public String rules();
}