package com.nisum.management.validation;

import com.nisum.management.annotation.Password;
import org.springframework.beans.factory.annotation.Value;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidation  implements ConstraintValidator<Password, String> {


    @Value("${app.properties.password-pattern}")
    private String passwordPattern;


    @Override
    public void initialize(Password constraintAnnotation) {
    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext constraintValidatorContext) {
        return password.matches(passwordPattern);
    }
}
