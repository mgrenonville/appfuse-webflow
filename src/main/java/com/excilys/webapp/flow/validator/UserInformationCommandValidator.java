package com.excilys.webapp.flow.validator;

import com.excilys.webapp.flow.command.UserInformationCommand;
import org.appfuse.model.User;
import org.appfuse.service.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;

@Component
public class UserInformationCommandValidator {

    @Autowired
    protected UserManager userManager;

    public void validate(UserInformationCommand userInformationCommand, Errors errors) {

        checkNotEmpty(userInformationCommand.getEmail(), errors, "email");
        checkNotEmpty(userInformationCommand.getPassword(), errors, "password");
        checkNotEmpty(userInformationCommand.getPasswordHint(), errors, "passwordHint");
        checkNotEmpty(userInformationCommand.getFirstName(), errors, "firstName");
        checkNotEmpty(userInformationCommand.getLastName(), errors, "lastName");

        try {
            User user = userManager.getUserByUsername(userInformationCommand.getUsername());
            if (user != null) {
                errors.rejectValue("username", "errors.existing.user", new Object[]{user.getUsername(), user.getEmail()}, "duplicate user");
            }
        } catch (UsernameNotFoundException ex) {

        }


    }

    private void checkNotEmpty(String value, Errors errors, String field) {
        if (!StringUtils.hasLength(value)) {
            errors.rejectValue(field, "errors.required", new Object[]{field}, "required");
        }
    }

}
