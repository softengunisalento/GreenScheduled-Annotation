package com.example.Tesi;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class TesiApplication{
    public static void main(String[] args) throws Exception {
        var ctx = new SpringApplicationBuilder(TesiApplication.class)
                .headless(false).run(args);
    }
}
