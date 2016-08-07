package com.apptologia.simpletodo.pojos;

public class Items {
    public int ID;
    public int alarm;
    public int check;
    public String created_time;
    public int listID;
    public int sortid;
    public String title;

    public Items(int ID_, int listid_, String title_, int sortid_, String created_, int check_, int alarm_) {
        this.ID = ID_;
        this.listID = listid_;
        this.title = title_;
        this.sortid = sortid_;
        this.created_time = created_;
        this.check = check_;
        this.alarm = alarm_;
    }

    public int getID() {
        return this.ID;
    }

    public int getListID() {
        return this.listID;
    }

    public String getTitle() {
        return this.title;
    }

    public int getSortID() {
        return this.sortid;
    }

    public String getCreatedTime() {
        return this.created_time;
    }

    public int getChecked() {
        return this.check;
    }

    public int getAlarm() {
        return this.alarm;
    }
}
