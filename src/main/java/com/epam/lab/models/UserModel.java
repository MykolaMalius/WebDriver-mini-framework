package com.epam.lab.models;
import javax.xml.bind.annotation.*;

@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserModel {
    @XmlAttribute(name = "id")
    private String id;
    @XmlElement(name = "email")
    private String email;
    @XmlElement(name = "password")
    private String password;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
