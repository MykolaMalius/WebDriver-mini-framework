package com.epam.lab.parsers;
import com.epam.lab.models.UsersList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class UserJAXBParser {
    public static UsersList usersList;
    public void readUserXml(){

       try {
           File file = new File("user.xml");
           JAXBContext jaxbContext = JAXBContext.newInstance(UsersList.class);
           Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
           usersList = (UsersList) jaxbUnmarshaller.unmarshal(file);

       } catch (JAXBException e) {
           e.printStackTrace();
       }
   }
   public List<String> getAllUsers(){
        readUserXml();
        List<String> logins = new ArrayList<>();
        for (int i = 0;i< usersList.getListOfUsers().size();i++){
            logins.add(usersList.getListOfUsers().get(i).getEmail());
        }
        return logins;
   }
   public String getLogin(int index){
       readUserXml();
       return usersList.getListOfUsers().get(index).getEmail();
   }
   public String getPassword(int index){
       readUserXml();
       return usersList.getListOfUsers().get(index).getPassword();
   }
}

