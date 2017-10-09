package com.epam.lab.models;
import com.epam.lab.parsers.UserJAXBParser;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UsersList {
  @XmlElement(name = "user")
  public  static List<UserModel> listOfUsers = new ArrayList<>();

  public List<UserModel> getListOfUsers() {
    return listOfUsers;
  }
  public void setListOfUsers(List<UserModel> listOfUsers) {
    this.listOfUsers = listOfUsers;
  }
}
