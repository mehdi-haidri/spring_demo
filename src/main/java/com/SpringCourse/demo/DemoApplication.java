package com.SpringCourse.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;*/

@SpringBootApplication
public class DemoApplication {



	public static void main(String[] args) {



		SpringApplication.run(DemoApplication.class, args);

	/*	StudentDB student = new StudentDB();
		student.setAge(20);
		student.setGender("male");
		student.setName("mehdi");*/







	/*	var app = new SpringApplication(DemoApplication.class);
		Map<String, Object> properties =new HashMap<>() ;
		ArrayList<String> active = new ArrayList<String>();
		active.add("dev");
		properties.put("spring.profiles.active", active);
		app.setDefaultProperties(properties);
		var ctx = app.run(args);

		MyFirstClass myFirstClass = ctx.getBean(MyFirstClass.class);
		System.out.println(myFirstClass.sayHello());
		System.out.println(myFirstClass.getJavaVersion());
		System.out.println(myFirstClass.getOsName());*/

	}


}
