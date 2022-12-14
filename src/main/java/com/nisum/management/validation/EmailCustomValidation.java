package com.nisum.management.validation;

import com.nisum.management.annotation.EmailCustom;
import org.springframework.beans.factory.annotation.Value;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailCustomValidation implements ConstraintValidator<EmailCustom, String> {

    @Value("${app.properties.email-pattern}")
    private String emailPattern;


    @Override
    public void initialize(EmailCustom constraintAnnotation) {
    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext constraintValidatorContext) {
        return password.matches(emailPattern);
    }
}
