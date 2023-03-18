package org.rest.model;

import java.util.List;

public class User {
    private Integer id;
    private String name;
    private List<Event> events;

    public User(Integer id, String name, List<Event> events) {
        this.id = id;
        this.name = name;
        this.events = events;
    }
    public User(){

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

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
}
