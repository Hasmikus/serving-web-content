package com.intellias.servingwebcontent;

import com.intellias.servingwebcontent.model.Device;
import com.intellias.servingwebcontent.repository.DeviceRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Testcontainers
@DataMongoTest(excludeAutoConfiguration = EmbeddedMongoAutoConfiguration.class)
public class DeviceRepositoryTests {
    @Container
    static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:4.4.2");

    @DynamicPropertySource
    static void setProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.data.mongodb.uri", mongoDBContainer::getReplicaSetUrl);
    }

    @Autowired
    private DeviceRepository deviceRepository;

    @AfterEach
    void cleanUp() {
        this.deviceRepository.deleteAll();
    }

    @Test
    void shouldReturnListOfDevicesWithOwner() {
        this.deviceRepository.save(new Device("Bob-nout-1", "Bob"));
        this.deviceRepository.save(new Device("Bob-mobile-1", "Bob"));
        this.deviceRepository.save(new Device("Bob-nout-2", "Bob"));
        this.deviceRepository.save(new Device("John-mobile-1", "JohnJ"));


        List<Device> devices = deviceRepository.findByOwner("Bob");
        System.out.println(devices.size());
        assertEquals(3, devices.size());
    }

}