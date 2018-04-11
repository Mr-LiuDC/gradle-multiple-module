package cn.alittler.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * RunApplication
 *
 * @author LiuDeCai
 * @date 2018/03/29
 */
@SpringBootApplication
@ComponentScan("cn.alittler")
public class RunApplication {

    public static void main(String[] args) {
        SpringApplication.run(RunApplication.class, args);
    }

}
