package com.project.roku;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RokuApplication {

	public static void main(String[] args) {
		SpringApplication.run(RokuApplication.class, args);
	}

	/*
	@Bean
	Pharmacy getPharmacyName(){return new Pharmacy();}


	@Bean(name = "application")
	EmployeeRepoService getEmployeeService(){return new EmployeeRepoService() {
	}}

	@Bean(name = "employeeDao")
	EmployeeRepoServiceImpl getEmployeeRepo(){return new EmployeeRepoServiceImpl();}

	 */

}
