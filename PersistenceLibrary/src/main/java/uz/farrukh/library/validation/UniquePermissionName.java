package uz.farrukh.library.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = UniquePermissionNameValidator.class)
@Documented
public @interface UniquePermissionName {
    String message() default "Permission name should be unique";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
