package com.luuren.meitulu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


/**
 * 要打成war包在tomcat下运行，得继承SpringBootServletInitializer，重载configure函数
 */
@SpringBootApplication
public class MeituluApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(MeituluApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return super.configure(builder);
    }
}
