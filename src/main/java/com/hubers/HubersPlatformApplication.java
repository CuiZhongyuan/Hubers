package com.hubers;

import com.hubers.utils.SpringContextUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * @author lgl
 */
@SpringBootApplication
public class HubersPlatformApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(com.hubers.HubersPlatformApplication.class, args);
        SpringContextUtils.setApplicationContext(context);
    }

}
