package com.epam.lab.models;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "letters")
@XmlAccessorType(XmlAccessType.FIELD)
public class LetterList {
  @XmlElement(name = "letter")
  public static List<LetterModel> listOfLetters = new ArrayList<>();
    public List<LetterModel> getListOfLetters() {
        return listOfLetters;
    }
    public void setListOfLetters(List<LetterModel> listOfLetters) {
        this.listOfLetters = listOfLetters;
    }
}
