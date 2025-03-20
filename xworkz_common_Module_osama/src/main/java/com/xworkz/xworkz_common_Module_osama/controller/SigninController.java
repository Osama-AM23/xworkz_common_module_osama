package com.xworkz.xworkz_common_Module_osama.controller;

import com.xworkz.xworkz_common_Module_osama.dto.ModuleDto;
import com.xworkz.xworkz_common_Module_osama.entity.ModuleEntity;
import com.xworkz.xworkz_common_Module_osama.constant.LocationConstant;
import com.xworkz.xworkz_common_Module_osama.service.ModuleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Slf4j
@Controller
@RequestMapping("/")
public class SigninController {

    @Autowired
    ModuleService moduleService;


    @GetMapping("/signin")
    public String signin() {
        log.info("Signin page displaying");
        return "Signin";
    }

    @PostMapping("/signin")
    public String onSignin(@RequestParam String email, @RequestParam String password, Model model) {
        log.info("Signin response is displaying");
        ModuleDto moduleDto = new ModuleDto();
        ModuleEntity moduleEntity = moduleService.onSignin(email, password, model);

        if (moduleEntity == null) {
            model.addAttribute("error", "Invalid email or password");
            return "Signin";
        }
        if (moduleEntity.getSigninCount() == 0) {
            model.addAttribute("email", email);
            return "SigninSuccess";
        }
        if (moduleEntity.getSigninCount() == -1) {
            return "SetPassword";
        }
        if (moduleEntity.getSigninCount() >= 3) {
            return "Signin";
        }
        return "Signin";
    }
    @GetMapping("/deleteData")
    public String deleteUser(@RequestParam("email") String email){
        moduleService.deleteUserByEmail(email);
        log.info(email +"Account is deleted");
        return "DeleteData";
    }

    @PostMapping("/setPassword")
    public String setPassword(@RequestParam String email, @RequestParam String password, @RequestParam String confirmPassword) {

        if (moduleService.forgetPasswordUpdate(email, password, confirmPassword)) {
            return "SetPasswordSuccess";
        }
        return "SetPassword";
    }

    @GetMapping("/onUpdate")
    public String update(@RequestParam String email, Model model) {
        log.info("Email Controller:" + email);
        log.info("Update page display with email");
        model.addAttribute("email", email);
        return "Update";
    }

    @GetMapping("/updateDetails")
    public String updateDetails(@RequestParam String email, Model model) {
        ModuleDto moduleDto = moduleService.findByEmail(email);
        List<LocationConstant> location = new ArrayList<>(Arrays.asList(LocationConstant.values()));
        System.out.println(location);
        model.addAttribute("list", location);
        model.addAttribute("dto", moduleDto);
        log.info("Update Details page Display");
        return "UpdateDetails";
    }

    @PostMapping("/updateDetails")
    public String updateDetails(ModuleDto moduleDto, Model model) {
        moduleService.updatebyEmail(moduleDto, model);
        model.addAttribute("email", moduleDto.getEmail());
        return "UpdateSuccess";
    }
}
