package com.bobocode.app;

import com.bobocode.app.service.SomeService;
import com.bobocode.trimmer.annotation.EnableStringTrimming;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableStringTrimming
public class SpringTrimmingMagicApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringTrimmingMagicApplication.class, args);
        SomeService bean = context.getBean(SomeService.class);
        String result = bean.processStrings("   first string   ", "   second string   ");
        System.out.println("result = \"" + result + "\"");
    }

}
