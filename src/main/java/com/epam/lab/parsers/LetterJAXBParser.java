package com.epam.lab.parsers;
import com.epam.lab.models.LetterList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class LetterJAXBParser {
    private LetterList letterList;
    public void readLetterXml(){
        try {
            File file = new File("letter.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(LetterList.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            letterList = (LetterList) jaxbUnmarshaller.unmarshal(file);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
    public String getIncorrectAddress(int index){
        readLetterXml();
        return  letterList.getListOfLetters().get(index).getIvalidTo();
    }
    public String getCorrectAdress(int index){
        readLetterXml();
        return letterList.getListOfLetters().get(index).getTo();
    }
    public String getTitleOfMessage(int index){
        readLetterXml();
        return letterList.getListOfLetters().get(index).getTitle();
    }
    public String getContentOfMessage(int index){
        readLetterXml();
        return letterList.getListOfLetters().get(0).getContent();
    }
}

