package com.example.demo.annotation;

import com.example.demo.annotation.validator.PhoneValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(
        validatedBy = PhoneValidator.class
)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPhone {

    String message() default "Phone number not valid";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
