package com.swagger;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "不知道有什么用", description = "招呼模块")
@ApiModel(value = "apimodel-value")
@RequestMapping("/uu")
@RestController
public class HelloController {
    @ApiImplicitParam(name = "name", value = "被打招呼者的称谓", required = true, paramType = "query", dataType = "String")
    @ApiOperation(value = "找打招呼", notes = "就是输入你的名字，系统会给你打招呼")
    @GetMapping("/hello")
    public String hello(String name) {
        return "hello, " + name;
    }
}