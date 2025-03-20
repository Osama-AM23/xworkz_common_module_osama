package com.xworkz.xworkz_common_Module_osama.controller;

import com.xworkz.xworkz_common_Module_osama.dto.ModuleDto;
import com.xworkz.xworkz_common_Module_osama.service.ModuleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Slf4j
@Controller
@RequestMapping("/")
public class ForgetPasswordController {

    @Autowired
    ModuleService moduleService;

    @GetMapping("/forgetPassword")
    public String onForgetPassword(String email) {
        log.info("Displaying the forget password page");
        return "ForgetPassword";
    }

    @PostMapping("/forgetPassword")
    public String getByEmail(String email, String password, String confirmPassword) {
        if (moduleService.forgetPasswordUpdate(email, password, confirmPassword)) {
            return "Signin";
        }
        return "ForgetPassword";
    }
}
