package integration.server.response;


import javax.xml.bind.annotation.XmlElement;

public class UserProfileResponse {

    @XmlElement(name = "response")
    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    private String response;



}
