package com.xworkz.xworkz_common_Module_osama.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.xworkz.xworkz_common_Module_osama")
@Slf4j
public class SpringConfiguration {

    public SpringConfiguration(){
        System.out.println();
        log.info("SpringConfiguration Created osama");
    }
}
