package org.rest.model;

public class Event {
    private Integer id;
    private User user;
    private File file;


    public Event(Integer id, User user, File file) {
        this.id = id;
        this.user = user;
        this.file = file;
    }

    public Event(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}
