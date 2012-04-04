package com.excilys.webapp.flow.state;


import com.excilys.webapp.flow.command.AddressCommand;
import com.excilys.webapp.flow.command.UserInformationCommand;

import java.io.Serializable;

public class SignupFlowState implements Serializable {

    protected UserInformationCommand userInformationCommand = new UserInformationCommand();
    protected AddressCommand addressCommand = new AddressCommand();

    public UserInformationCommand getUserInformationCommand() {
        return userInformationCommand;
    }

    public void setUserInformationCommand(UserInformationCommand userInformationCommand) {
        this.userInformationCommand = userInformationCommand;
    }

    public AddressCommand getAddressCommand() {
        return addressCommand;
    }

    public void setAddressCommand(AddressCommand addressCommand) {
        this.addressCommand = addressCommand;
    }
}
