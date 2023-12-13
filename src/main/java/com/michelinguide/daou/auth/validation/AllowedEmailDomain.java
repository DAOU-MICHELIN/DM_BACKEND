package com.michelinguide.daou.auth.validation;

import jakarta.validation.Constraint;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EmailDomainValidator.class)
public @interface AllowedEmailDomain {

    String message () default "회사 이메일을 사용하세요.";

    Class[] groups () default  {};

    Class[] payload () default {};

    String allowedDomain();

}
