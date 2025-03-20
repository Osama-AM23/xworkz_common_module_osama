package com.xworkz.xworkz_common_Module_osama.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping("/")
public class ModuleController {

    @GetMapping("/index")
    public String index() {
        log.info("Home page is displaying");
        return "index";
    }

}
