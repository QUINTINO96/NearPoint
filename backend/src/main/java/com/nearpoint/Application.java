package com.nearpoint;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.nearpoint.controller.PostController;
import com.nearpoint.model.Post;
import com.nearpoint.model.Usuario;
import com.nearpoint.repository.PostRepository;
import com.nearpoint.repository.UsuarioRepository;
import com.nearpoint.service.PostService;
import com.nearpoint.service.PostServiceImpl;
@SpringBootApplication

  @EnableTransactionManagement
  
  @ComponentScan(basePackageClasses= {PostController.class, PostService.class,PostServiceImpl.class,PostRepository.class,Post.class})
  @ComponentScan(basePackages = {"com.nearpoint.controller"})
  @EntityScan(basePackages = { "com.nearpoint.model" })
  @EnableJpaRepositories(basePackages = { "com.nearpoint.repository" })
 
public class Application implements CommandLineRunner {

	@Bean
	
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}
	
  
    @Override
    
    public void run(String...args) throws Exception {

//        // Create an employee
//        Employee employee = new Employee();
//        employee.setFirstName("Ramesh");
//        employee.setLastName("Fadatare");
//        employee.setEmailId("ramesh@gmail.com");
//        employeeRepository.save(employee);
//        // Create an employee
//        Employee employee1 = new Employee();
//        employee1.setFirstName("Tom");
//        employee1.setLastName("Cruise");
//        employee1.setEmailId("tom@gmail.com");
//        employeeRepository.save(employee1);
//     // Create an employee
//        Employee employee2 = new Employee();
//        employee2.setFirstName("Tony");
//        employee2.setLastName("Stark");
//        employee2.setEmailId("tony@gmail.com");
//        employeeRepository.save(employee2);
    }

   
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}