package com.excilys.webapp.flow.facade;


import com.excilys.service.user.UserServiceImpl;
import com.excilys.webapp.flow.command.AddressCommand;
import com.excilys.webapp.flow.command.UserInformationCommand;
import com.excilys.webapp.flow.state.SignupFlowState;
import org.appfuse.service.UserExistsException;
import org.appfuse.service.UserManager;
import org.appfuse.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

@FlowFacade
public class SubscriptionFlowFacade {

    @Autowired
    private UserServiceImpl userService;

    public String performSubscription(SignupFlowState flowState) throws UserExistsException {
        UserInformationCommand u = flowState.getUserInformationCommand();
        AddressCommand a = flowState.getAddressCommand();
        userService.createUser(u.getUsername(), u.getPassword(), u.getPasswordHint(), u.getFirstName(), u.getLastName(),
         u.getPhoneNumber(), u.getWebsite(), a.getAddress(), a.getCity(), a.getState(), a.getPostalCode(), a.getCountry());
        return "success";
    }

}
