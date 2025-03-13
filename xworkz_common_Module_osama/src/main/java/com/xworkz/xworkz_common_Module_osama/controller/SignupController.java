package com.xworkz.xworkz_common_Module_osama.controller;

import com.xworkz.xworkz_common_Module_osama.dto.ModuleDto;
import com.xworkz.xworkz_common_Module_osama.enums.LocationEnum;
import com.xworkz.xworkz_common_Module_osama.service.ModuleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/")
public class SignupController {

    @Autowired
    ModuleService moduleService;

    @GetMapping("/signup")
    public String signup(Model model) {
        log.info("Signup page displaying");
        List<LocationEnum> location = new ArrayList<>(Arrays.asList(LocationEnum.values()));
        model.addAttribute("list", location);
        return "Signup.jsp";
    }

    @PostMapping("/signup")
    public String getSignUp(ModuleDto moduleDto, Model model) {
        log.info("SignUp Response is displaying");

        boolean isValid = moduleService.validateAndSave(moduleDto, model);
        if (isValid) {
            return "SignupSuccess.jsp";
        }
        model.addAttribute("dto", moduleDto);
        return "Signup.jsp";
    }
}
