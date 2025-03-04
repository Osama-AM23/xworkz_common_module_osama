package com.xworkz.xworkz_common_Module_osama.controller;

import com.xworkz.xworkz_common_Module_osama.dto.ModuleDto;
import com.xworkz.xworkz_common_Module_osama.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class ModuleController {
    @Autowired
    ModuleService moduleService;

    public ModuleController(){
        System.out.println("ModuleController is Created");
    }
    @GetMapping("/signup")
    public String signup(){
        System.out.println("Signup page displaying");
        return "Signup.jsp";
    }

    @GetMapping("/index")
    public String index(){
        System.out.println("Home page is displaying");
        return "index.jsp";
    }
    @PostMapping("/signup")
    public String getSignUp(ModuleDto moduleDto, Model model){
        System.out.println("SignUp Response is displaying");
        boolean isValid= moduleService.validateAndSave(moduleDto, model);
        if(isValid){
            return "SignupResponse.jsp";
        }
        model.addAttribute("dto", moduleDto);
        return "Signup.jsp";
    }

}
