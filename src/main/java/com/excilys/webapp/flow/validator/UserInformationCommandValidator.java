package com.excilys.webapp.flow.validator;

import com.excilys.webapp.flow.command.UserInformationCommand;
import org.springframework.binding.validation.ValidationContext;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@Component
public class UserInformationCommandValidator {

    public void validate(UserInformationCommand userInformationCommand, Errors errors) {
        errors.reject("All");

    }

}
