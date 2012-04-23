package com.excilys.service.user;


import org.appfuse.Constants;
import org.appfuse.model.Address;
import org.appfuse.model.User;
import org.appfuse.service.RoleManager;
import org.appfuse.service.UserExistsException;
import org.appfuse.service.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tuckey.web.filters.urlrewrite.functions.StringFunctions;

@Service
public class UserServiceImpl {

    @Autowired
    private UserManager userManager;

    @Autowired
    private RoleManager roleManager;

    public boolean createUser(String username, String password, String passwordHint, String firstName, String lastName,
                              String phoneNumber, String website, String address, String city, String state,
                              String postalCode, String country) throws UserExistsException {
        Address a = new Address();
        a.setAddress(address);
        a.setCity(city);
        a.setCountry(country);
        a.setProvince(state);
        a.setPostalCode(postalCode);


        //Consider builder creation...
        User user = new User();
        user.setUsername(username);
        user.setEmail(username);
        user.setPassword(password);
        user.setPasswordHint(passwordHint);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPhoneNumber(phoneNumber);
        user.setWebsite(website);

        user.setEnabled(true);
        user.setAddress(a);
        // Set the default user role on this new user
        user.addRole(roleManager.getRole(Constants.USER_ROLE));

        userManager.saveUser(user);

        return true;
    }
}
