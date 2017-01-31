package integration.server.response;


import integration.server.model.User;

import javax.xml.bind.annotation.XmlElement;

public class UserDevicesResponse {

    private User response;

    @XmlElement(name = "response")
    public User getResponse() {
        return response;
    }

    public void setResponse(User response) {
        this.response = response;
    }

}
