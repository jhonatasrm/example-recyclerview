package com.jhonatasrm.example_recyclerview;

// item
public class Item {

    // id + name of the item
    private int id;
    private String name;

    // constructor method
    public Item (int id, String name){
        this.id = id;
        this.name = name;
    }

    // get and set methods
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
