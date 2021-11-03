package com.intellias.servingwebcontent.repository;

import com.intellias.servingwebcontent.model.Device;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface DeviceRepository extends MongoRepository<Device, String> {

    public Device findByName(String name);
    public List<Device> findByOwner(String owner);
}