package com.beantoxmljson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import lombok.Data;

import java.io.IOException;


//lombok教程  https://blog.csdn.net/u011719271/article/details/53842420#log4j
@Data
@XStreamAlias("User")//制定别名
public class User {

    @XStreamAlias("myage")
    int age=10;

    @XStreamAsAttribute //作为属性
    String name = "feng";

    public static void main(String[] args) throws IOException {
        beanXml();
        var a = 1;
        System.out.println(a);
        beanJson();

    }

    private static void beanJson() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writeValueAsString(new User());
        System.out.println(s);
        User user = mapper.readValue(s, User.class);
        System.out.println(user);
    }

    //bean 和 xml互转
    private static void beanXml() {
        XStream x = new XStream();
        x.processAnnotations(User.class); //处理注解
        String s = x.toXML(new User());
        System.out.println(s);
        User user = (User)x.fromXML(s);//转对象
        System.out.println(user);
    }

}
