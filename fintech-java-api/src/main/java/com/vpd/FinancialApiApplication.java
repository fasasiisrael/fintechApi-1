package com.vpd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Financial API", description = "API for financial transactions")
@SpringBootApplication
public class FinancialApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinancialApiApplication.class, args);
    }
}
