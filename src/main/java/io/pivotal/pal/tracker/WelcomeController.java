package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    private String cfInstanceIndex;

    // welcome.nessage在不同的启动方式下输入值的方式也不一样
    // 1、直接main函数启动，在run configuration的environment variable设置WELCOME_MESSAGE=asdfg
    // 2、使用bootRun方式启动，在build.gradle中的bootRun.environment设置
    // 3、cf push在manifest.yml文件中设置env
    public WelcomeController(@Value("${welcome.message}") String cfInstanceIndex) {
        this.cfInstanceIndex = cfInstanceIndex;
    }

    @GetMapping("/")
    public String sayHello() {
//         return "hello";
        return this.cfInstanceIndex;
    }
}