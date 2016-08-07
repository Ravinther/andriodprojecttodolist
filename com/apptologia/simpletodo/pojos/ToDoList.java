package com.apptologia.simpletodo.pojos;

public class ToDoList {
    public int ID;
    public String created_time;
    public String detail;
    public String title;
    public String type;

    public ToDoList(int ID_, String name_, String detail_, String created_, String type_) {
        this.ID = ID_;
        this.title = name_;
        this.detail = detail_;
        this.created_time = created_;
        this.type = type_;
    }

    public int getID() {
        return this.ID;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDetail() {
        return this.detail;
    }

    public String getCreatedTime() {
        return this.created_time;
    }

    public String getType() {
        return this.type;
    }
}
