package com.nisum.management.annotation;

import com.nisum.management.validation.PasswordValidation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER,
        ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordValidation.class)
@Documented
public @interface Password {

    String message() default "must be a valid password";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
