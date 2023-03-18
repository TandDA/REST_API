package org.rest.model;

public class File {
    private Integer id;
    private String name;
    private String filePath;
    public File(Integer id, String name, String filePath){
        this.id = id;
        this.name = name;

        this.filePath = filePath;
    }
    public File(){

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

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
