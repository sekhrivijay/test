package com.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com"})
public class Test3 implements CommandLineRunner {
    public static void main(String[] args)  throws Exception {
        SpringApplication.run(Test3.class, args);
    }

    @Autowired
    private SoapClient soapClient;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Running ......");
        soapClient.call();
    }

}
