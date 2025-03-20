package com.xworkz.xworkz_common_Module_osama.controller;

import com.xworkz.xworkz_common_Module_osama.dto.ModuleDto;
import com.xworkz.xworkz_common_Module_osama.constant.LocationConstant;
import com.xworkz.xworkz_common_Module_osama.service.ModuleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
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
    public String signup(Model model, HttpSession session) {
        log.info("Signup page displaying");
        List<LocationConstant> location = new ArrayList<>(Arrays.asList(LocationConstant.values()));
        String captcha =moduleService.generateCaptcha();
        session.setAttribute("captcha", captcha);
        model.addAttribute("captchaText", captcha);
        model.addAttribute("list", location);
        return "Signup";
    }

    @PostMapping("/signup")
    public String getSignUp(@RequestParam("captcha") String enteredCaptcha, @Valid ModuleDto moduleDto, BindingResult bindingResult, HttpSession session, Model model) {
        log.info("SignUp Response is displaying");
        if (bindingResult.hasErrors()) {
            model.addAttribute("captchaText", session.getAttribute("captcha"));
            if (bindingResult.hasFieldErrors("userName")) {
                log.info("User_Name Error :" + bindingResult.getFieldError("userName").getDefaultMessage());
            }
            if (bindingResult.hasFieldErrors("loginId")) {
                log.info("Login_Id Error :" + bindingResult.getFieldError("loginId").getDefaultMessage());
            }
            if (bindingResult.hasFieldErrors("email")) {
                log.info("email Error :" + bindingResult.getFieldError("email").getDefaultMessage());
            }
            if (bindingResult.hasFieldErrors("phoneNo")) {
                log.info("Phone_No Error :" + bindingResult.getFieldError("phoneNo").getDefaultMessage());
            }
            if (bindingResult.hasFieldErrors("age")) {
                log.info("Age Error :" + bindingResult.getFieldError("age").getDefaultMessage());
            }
        }
        String sessionCaptcha = (String) session.getAttribute("captcha");

        if (moduleDto.getCaptcha() == null || !enteredCaptcha.equalsIgnoreCase(sessionCaptcha)) {
            model.addAttribute("captchaError", "Captcha does not match!");
            model.addAttribute("captchaText", sessionCaptcha);
            return "Signup";
        }
        boolean isValid = moduleService.validateAndSave(moduleDto, model);
        if (isValid) {
            return "SignupSuccess";
        }
        model.addAttribute("dto", moduleDto);
        return "Signup";
    }

}
