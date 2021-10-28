package eccomerce.spring.admin.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Target((ElementType.TYPE))
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = SenhasIguaisValidation.class)
public @interface SenhasIguais {

	String message() default "As senhas devem ser iguais!";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};
}