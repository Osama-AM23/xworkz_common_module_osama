package com.xworkz.xworkz_common_Module_osama.controller;

import com.xworkz.xworkz_common_Module_osama.dto.ModuleDto;
import com.xworkz.xworkz_common_Module_osama.enums.LocationEnum;
import com.xworkz.xworkz_common_Module_osama.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping
public class ModuleController {
    @Autowired
    ModuleService moduleService;

    public ModuleController() {
        System.out.println("ModuleController is Created");
    }

    @GetMapping("/signup")
    public String signup(Model model) {
        System.out.println("Signup page displaying");
        List<LocationEnum> location = new ArrayList<>(Arrays.asList(LocationEnum.values()));
        System.out.println(location);
        model.addAttribute("list", location);
        return "Signup.jsp";
    }

    @GetMapping("/index")
    public String index() {
        System.out.println("Home page is displaying");
        return "index.jsp";
    }

    @PostMapping("/signup")
    public String getSignUp(ModuleDto moduleDto, Model model) {
        System.out.println("SignUp Response is displaying");

        boolean isValid = moduleService.validateAndSave(moduleDto, model);
        if (isValid) {
            return "SignupSuccess.jsp";
        }
        model.addAttribute("dto", moduleDto);
        return "Signup.jsp";
    }

    @GetMapping("/signin")
    public String signin() {
        System.out.println("Signin page displaying");
        return "Signin.jsp";
    }

    @PostMapping("/signin")
    public String onSignin(@RequestParam String email, @RequestParam String password, Model model) {
        System.out.println("Signin response is displaying");
        ModuleDto moduleDto = moduleService.onSignin(email, password, model);
        if (moduleDto == null) {
            return "Signin.jsp";
        } else {
            model.addAttribute("email", moduleDto.getEmail());
            return "SigninSuccess.jsp";
        }
    }

    @GetMapping("/onUpdate")
    public String update(@RequestParam String email, Model model) {
        System.out.println("Email Controller:" + email);
        System.out.println("Update page display with email");
        model.addAttribute("email", email);
        return "Update.jsp";
    }

    @GetMapping("/updateDetails")
    public String updateDetails(@RequestParam String email, Model model) {
        ModuleDto moduleDto = moduleService.findByEmail(email);
        List<LocationEnum> location = new ArrayList<>(Arrays.asList(LocationEnum.values()));
        System.out.println(location);
        model.addAttribute("list", location);
        model.addAttribute("dto", moduleDto);
        System.out.println("Update Details page Display");
        return "UpdateDetails.jsp";
    }

    @PostMapping("/updateDetails")
    public String updateDetails(ModuleDto moduleDto, Model model){
        moduleService.updatebyEmail(moduleDto, model);
        model.addAttribute("email", moduleDto.getEmail());
        return "UpdateSuccess.jsp";
    }

}
