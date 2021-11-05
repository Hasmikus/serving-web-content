package com.intellias.servingwebcontent;

import com.intellias.servingwebcontent.model.Device;
import com.intellias.servingwebcontent.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = DeviceRepository.class)
public class ServingWebContentApplication implements CommandLineRunner {

	@Autowired
	private DeviceRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(ServingWebContentApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		repository.deleteAll();

		// save devices
		repository.save(new Device("Hasmik-nout-1", "HasmikK"));
		repository.save(new Device("Hasmik-mobile-1", "HasmikK"));

		// fetch devices
		System.out.println("-------------------------------");
		for (Device device : repository.findAll()) {
			System.out.println(device);
		}
		System.out.println();

		// fetch a device
		System.out.println("Device found by name:");
		System.out.println(repository.findByName("Hasmik-nout-1"));

		System.out.println("Devices found by owner:");
		System.out.println("--------------------------------");
		for (Device device : repository.findByOwner("HasmikK")) {
			System.out.println(device);
		}
//		repository.deleteAll();
	}
}
