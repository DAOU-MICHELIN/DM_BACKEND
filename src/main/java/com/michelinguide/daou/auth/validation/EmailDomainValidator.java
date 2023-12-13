package com.michelinguide.daou.auth.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EmailDomainValidator implements ConstraintValidator<AllowedEmailDomain, String > {

    private String allowedDomain;

    @Override
    public void initialize(AllowedEmailDomain allowedEmailDomain) {
        this.allowedDomain = allowedEmailDomain.allowedDomain();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(value == null || value.isBlank()) return false;
        String [] parts = value.split("@");
        return parts.length == 2 && parts[1].equals(allowedDomain);
    }
}
