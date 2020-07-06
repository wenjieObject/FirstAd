package com.wenjie.adc.pojo;

import java.io.Serializable;

public class Clazz implements Serializable {

    private Integer id;
    private String name;
    private String room;

    public Clazz() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return "Clazz{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", room='" + room + '\'' +
                '}';
    }
}
