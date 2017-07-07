package com.example.junoo.fierbase;

/**
 * Created by JUNOO on 2017-07-07.
 */

public class DTO {

    private String name;
    private long now;
    private int flag;
    private String duration;
    private String date;

    public DTO(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int isFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
