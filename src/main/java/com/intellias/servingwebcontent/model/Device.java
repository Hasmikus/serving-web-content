package com.intellias.servingwebcontent.model;
import org.springframework.data.annotation.Id;

public class Device {
    @Id
    public String id;

    public String name;
    public String owner;
    public String description;

    public Device() {}

    public Device(String name, String owner) {
        this.name = name;
        this.owner = owner;
    }

    @Override
    public String toString() {
        return String.format(
                "Device[id=%s, name='%s', owner='%s', description='%s']",
                id, name, owner, description);
    }
}