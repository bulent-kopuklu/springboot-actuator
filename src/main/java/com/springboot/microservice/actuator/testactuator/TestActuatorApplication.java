package com.springboot.microservice.actuator.testactuator;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestActuatorApplication
{
	@Value("${info.app.name}")
	String name;

	@Value("${info.app.version}")
	String version;

	@Value("${info.app.description}")
	String desc;

	public static void main(String[] args)
	{
		SpringApplication.run(TestActuatorApplication.class, args);
	}

	public void run(String... args) throws Exception
	{
		System.out.println(name + " " + version + " " + desc);
	}
}
