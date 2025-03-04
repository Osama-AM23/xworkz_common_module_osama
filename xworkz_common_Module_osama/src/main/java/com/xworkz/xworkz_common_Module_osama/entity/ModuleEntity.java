package com.xworkz.xworkz_common_Module_osama.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "module_table")
@Data
public class ModuleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String userName;

    private Integer loginId;

    private String email;

    private String gender;

    private Integer age;

    private String dob;

    private Long phoneNo;

    private String location;

    private String password;

//    private String confirmPassword;
}
