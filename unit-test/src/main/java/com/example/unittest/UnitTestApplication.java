package com.example.unittest;

import com.example.unittest.entity.Employee;
import com.example.unittest.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
public class UnitTestApplication {


	public static void main(String[] args) {
		SpringApplication.run(UnitTestApplication.class, args);
	}

}
