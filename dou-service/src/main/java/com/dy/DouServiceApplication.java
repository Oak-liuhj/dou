package com.dy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 抖友项目启动类
 *
 * @author: liuhj
 * @date: 2021/8/9 15:35
 */
@SpringBootApplication
public class DouServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DouServiceApplication.class, args);
        System.out.println("=======DouServiceApplication running success!=======");
    }

}
