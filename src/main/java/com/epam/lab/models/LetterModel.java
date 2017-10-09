package com.epam.lab.models;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "letter")
@XmlAccessorType(XmlAccessType.FIELD)
public class LetterModel {
    @XmlAttribute(name = "id")
    private String id;
    @XmlElement(name = "invalidto")
    private String ivalidTo;
    @XmlElement(name = "to")
    private String to;
    @XmlElement(name = "title")
    private String title;
    @XmlElement(name = "content")
    private String content;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getIvalidTo() {
        return ivalidTo;
    }
    public void setIvalidTo(String ivalidTo) {
        this.ivalidTo = ivalidTo;
    }
    public String getTo() {
        return to;
    }
    public void setTo(String to) {
        this.to = to;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
}
