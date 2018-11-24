package com.view;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

    //jsp视图
    @RequestMapping("/hello")
    public String hello(String name, Model model){
        model.addAttribute("name",name);
        return "jsp/hello";
    }

    //thymeleaf 视图
    @RequestMapping("/")
    public String index(Model m){
        m.addAttribute("name","hello feng");
        return "templates/index";
    }

}
