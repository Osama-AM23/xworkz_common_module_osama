package com.xworkz.xworkz_common_Module_osama.dto;

import com.xworkz.xworkz_common_Module_osama.enums.LocationEnum;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Email;


import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class ModuleDto {

    private Integer id;
    @Size(min = 3, max = 25, message = "User Name Should be 3 and 25")
    private String userName;

    private Integer loginId;

    private String email;

    private String gender;

    private Integer age;

    private String dob;

    private String phoneNo;

    private String location;

    private String password;

    private String confirmPassword;

}
