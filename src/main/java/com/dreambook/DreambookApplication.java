package com.dreambook;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.dreambook.mapper")
@SpringBootApplication
public class DreambookApplication {

    public static void main(String[] args) {
        SpringApplication.run(DreambookApplication.class, args);
}

}
