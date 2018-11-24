package com.httpclient;

import com.dataaccess.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HttpController {
    /**
     * 将RestTempalte()加入容器，不然取不到。
     * @Bean
     * 	public RestTemplate getRestTemplate(){
     * 		return new RestTemplate();
     * 	}
     */
    @Autowired
    RestTemplate restTemplate;


    @RequestMapping("http")
    public User httpGet(){
        //httpGet
        User user = restTemplate.getForObject("http://localhost:8080/getUser?id=1", User.class);
        System.out.println(user);
        //httpPost
        user = restTemplate.postForObject("http://localhost:8080/getUser?id=1", null,User.class);
        //execute(String url, HttpMethod method, @Nullable RequestCallback requestCallback,
        //			@Nullable ResponseExtractor<T> responseExtractor, Object... uriVariables)
        //restTemplate.execute("http://localhost:8080/getUser?id=1", HttpMethod.GET,null,null,null)
        return user;
    }
}
