package edu.ualr.recyclerviewassignment.model;


public class Header extends Item {

    private String title;
    HeaderType headerType;


    public Header(String name , HeaderType type){
        this.title = name;
        this.header = true;
        this.headerType = type;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle(){
        return title;
    }

    public void setHeaderType(HeaderType type){
        this.headerType = type;
    }

    public HeaderType getHeaderType(){
        return this.headerType;
    }

    public enum HeaderType {
        Connected,
        Ready,
        Linked
    }
}
