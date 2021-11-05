package com.intellias.servingwebcontent.config;

import com.intellias.servingwebcontent.repository.DeviceRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
@EnableMongoRepositories(basePackageClasses = DeviceRepository.class)
public class MongoDbConfiguration {
}