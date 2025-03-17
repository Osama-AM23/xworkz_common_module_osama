package com.xworkz.xworkz_common_Module_osama.dto;

import com.xworkz.xworkz_common_Module_osama.enums.LocationEnum;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Email;


import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class ModuleDto {

    private Integer id;
    @Size(min = 3, max = 25, message = "User Name Should be 3 and 25")
    private String userName;
    @Pattern(regexp = "^[1-9][0-9]{1,3}$", message = "Login ID must be between 10 and 9999, with no leading zeros")
    private String loginId;
    @Pattern(regexp = "^[a-z0-9._%+-]+@gmail\\.com$", message = "Email should contain '@' and end with 'gmail.com'")
    private String email;

    private String gender;
    @Pattern(regexp = "^(1[89]|[2-9][0-9]|100)$", message = "Age must be a number and at least 18")
    private String age;

    private String dob;
    @Pattern(regexp = "^[0-9]{10}$", message = "Give correct phone number")
    private String phoneNo;

    private String location;

    private String password;

    private String confirmPassword;

    private String captcha;
}
