package com.example.demo.model;

public class Item {
    private long ID;
    private String Name;
    private String Code;

    public Item() {
    }

    public Item(int ID, String Name, String Code) {
        this.ID = ID;
        this.Name = Name;
        this.Code = Code;
    }
    public Long getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }
}
