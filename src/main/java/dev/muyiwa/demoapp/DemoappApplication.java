package dev.muyiwa.demoapp;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class DemoappApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(DemoappApplication.class);
//        application.setBannerMode(Banner.Mode.OFF);
        application.run(args);
    }

}
