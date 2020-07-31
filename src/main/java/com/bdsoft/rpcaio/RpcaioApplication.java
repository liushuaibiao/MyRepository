package com.bdsoft.rpcaio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.bdsoft.rpcaio")
public class RpcaioApplication {

    public static void main(String[] args) {
        SpringApplication.run(RpcaioApplication.class, args);
    }

}
