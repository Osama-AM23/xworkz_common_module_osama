package com.xworkz.xworkz_common_Module_osama.entity;

import com.xworkz.xworkz_common_Module_osama.enums.LocationEnum;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "module_table")
@Data

@NamedQuery(name = "getEmailAndPassword",
        query = "Select me from ModuleEntity me where me.email = :email")

@NamedQuery(name = "findByEmail",
        query = "select ue From ModuleEntity ue where ue.email = :email")

@NamedQuery(name="updateByEmail",
        query="Update ModuleEntity me set me.userName = :userName, me.age = :age, me.dob = :dob, me.phoneNo = :phoneNo, me.location = :location, me.password = :password Where me.email = :email")
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
}
