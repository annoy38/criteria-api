package com.criteriaApi.precticecriteriaapi;

import com.criteriaApi.precticecriteriaapi.model.ItemClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;

@SpringBootApplication
public class PrecticeCriteriaApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(PrecticeCriteriaApiApplication.class, args);
	}
}
