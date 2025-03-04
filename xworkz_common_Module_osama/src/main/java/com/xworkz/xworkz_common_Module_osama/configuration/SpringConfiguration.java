package com.xworkz.xworkz_common_Module_osama.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.xworkz.xworkz_common_Module_osama")
public class SpringConfiguration {

    public SpringConfiguration(){
        System.out.println("SpringConfiguration Created");
    }
}
