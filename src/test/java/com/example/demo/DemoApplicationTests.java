package com.example.demo;

import com.dataaccess.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	RestTemplate restTemplate;


	@Test
	public void contextLoads() {
		User forObject = restTemplate.getForObject("http://localhost:8080/getUser?id=1", User.class);
		System.out.println(forObject);
	}

}
