package uz.farrukh.library.validation;

import lombok.RequiredArgsConstructor;
import uz.farrukh.library.repositories.PermissionRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
public class UniquePermissionNameValidator implements ConstraintValidator<UniquePermissionName, String> {

    private final PermissionRepository permissionRepository;

    @Override
    public boolean isValid(String permissionName, ConstraintValidatorContext constraintValidatorContext) {

        System.out.println(permissionName);

        boolean existsByName = permissionRepository.existsByName(permissionName);

        System.out.println(existsByName);

        return !existsByName;
    }
}
