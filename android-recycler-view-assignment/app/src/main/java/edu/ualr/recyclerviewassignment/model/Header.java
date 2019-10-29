package edu.ualr.recyclerviewassignment.model;


public class Header extends Item {

    private String title;

    public Header(String name){
        this.title = name;
        this.header = true;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle(){
        return title;
    }
}
