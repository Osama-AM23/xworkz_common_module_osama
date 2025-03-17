package com.xworkz.xworkz_common_Module_osama.restController;

import com.xworkz.xworkz_common_Module_osama.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class SignupRestController {
    @Autowired
    ModuleService moduleService;

    @GetMapping(value = "/userName/{userName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String onUserName(@PathVariable String userName) {
        Long count = moduleService.getCountByUserName(userName);
        if (count == 0) {
            return "";
        }
        return "User Name is Already Exist";
    }

    @GetMapping(value = "/loginId/{loginId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String onLoginId(@PathVariable String loginId) {
        Long count = moduleService.getCountByLoginId(loginId);
        if (count == 0) {
            return "";
        }
        return "LoginId is Already Exist";
    }

    @GetMapping(value = "/email/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String onEmail(@PathVariable String email) {
        Long count = moduleService.getCountByEmail(email);
        if (count == 0) {
            return "";
        }
        return "Email is Already Exist";
    }

//    @GetMapping(value = "/age/{age}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public String onAge(@PathVariable String age) {
//        return "";
//    }

    @GetMapping(value = "/phoneNo/{phoneNo}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String onPhoneNo(@PathVariable String phoneNo) {
        Long count = moduleService.getCountByPhone(phoneNo);
        if (count == 0) {
            return "";
        }
        return "phone Number is Already Exist";
    }

}
