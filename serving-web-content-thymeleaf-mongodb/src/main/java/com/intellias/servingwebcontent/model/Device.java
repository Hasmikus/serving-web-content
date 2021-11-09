package com.intellias.servingwebcontent.model;
import org.springframework.data.annotation.Id;

public class Device {
    @Id
    private String id;

    private String name;
    private String owner;

    public Device() {}

    public Device(String name, String owner) {
        this.name = name;
        this.owner = owner;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getOwner() {
        return owner;
    }

    @Override
    public String toString() {
        return String.format(
                "Device[id=%s, name='%s', owner='%s']",
                id, name, owner);
    }
}