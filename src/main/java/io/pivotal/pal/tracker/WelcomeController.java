package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

private String cfInstanceIndex;

    public WelcomeController(@Value("${welcome.message}")
                                     String cfInstanceIndex) {
         this.cfInstanceIndex = cfInstanceIndex;
    }

    @GetMapping("/")
    public String sayHello() {
       // return "hello";
    return this.cfInstanceIndex;
    }
}