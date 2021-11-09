package com.intellias.servingwebcontent.repository;

import com.intellias.servingwebcontent.model.Device;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeviceRepository extends MongoRepository<Device, String> {

    public Device findByName(String name);
    public List<Device> findByOwner(String owner);
    public void deleteDeviceById(String id);
}