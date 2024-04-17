package com.example.springproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
@SpringBootApplication
public class SpringProjectApplication {

	public static void main(String[] args) {
		//SpringApplication.run(SpringProjectApplication.class, args);
		System.out.println("Hello, Group Project is running!");

		System.out.println("Bug-fix example");

		System.out.println("Bug-fix second example");
	}

}
public class ServletInitializer extends SpringBootServletInitializer {

      @Override
      protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
              return application.sources(DemoApplication.class); // Replace DemoApplication with your main class
      }

}
