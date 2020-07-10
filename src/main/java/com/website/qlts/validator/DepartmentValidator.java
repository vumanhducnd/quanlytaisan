package com.website.qlts.validator;

import com.website.qlts.validator.Impl.DepartmentValidatorImpl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DepartmentValidator implements ConstraintValidator<DepartmentValidatorImpl,String> {
    @Override
    public void initialize(DepartmentValidatorImpl constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
            return value != null    && (value.length() > 6) && (value.length() < 255);
    }
}
