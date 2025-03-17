package com.xworkz.xworkz_common_Module_osama.controller;

import com.xworkz.xworkz_common_Module_osama.dto.ModuleDto;
import com.xworkz.xworkz_common_Module_osama.enums.LocationEnum;
import com.xworkz.xworkz_common_Module_osama.service.ModuleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
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
    public String signup(Model model) {
        log.info("Signup page displaying");
        List<LocationEnum> location = new ArrayList<>(Arrays.asList(LocationEnum.values()));
        model.addAttribute("list", location);
        return "Signup.jsp";
    }

    @PostMapping("/signup")
    public String getSignUp(@Valid ModuleDto moduleDto, BindingResult bindingResult, HttpSession session, Model model) {
        log.info("SignUp Response is displaying");
        if (bindingResult.hasErrors()) {
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

        if (moduleDto.getCaptcha() == null || !moduleDto.getCaptcha().equals(sessionCaptcha)) {
            model.addAttribute("captchaError", "Captcha Does not match!");
            return "Signup.jsp";
        }
        boolean isValid = moduleService.validateAndSave(moduleDto, model);
        if (isValid) {
            return "SignupSuccess.jsp";
        }
        model.addAttribute("dto", moduleDto);
        return "Signup.jsp";
    }

    @GetMapping("/captcha")
    public void generateCaptchaImage(HttpSession session, HttpServletResponse response) throws IOException {

        int width = 150;
        int height = 45;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();

        // Set background color
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, width, height);

        // Set text properties
        g.setColor(Color.YELLOW);
        g.setFont(new Font("Arial", Font.BOLD, 22));

        // Generate and store CAPTCHA text in session
        String captchaText = moduleService.generateCaptcha();
        session.setAttribute("captcha", captchaText);

        // Draw CAPTCHA text
        g.drawString(captchaText, 30, 35);
        g.dispose();

        // Write image to response
        response.setContentType("image/png");
        ImageIO.write(image, "png", response.getOutputStream());
    }
}
