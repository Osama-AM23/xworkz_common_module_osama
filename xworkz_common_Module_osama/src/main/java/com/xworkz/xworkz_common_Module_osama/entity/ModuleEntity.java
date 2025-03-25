package com.xworkz.xworkz_common_Module_osama.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "module_table")
@Data
@NamedQuery(name = "getNameCount",
        query = "Select Count (me) From ModuleEntity me Where me.userName = :userName")

@NamedQuery(name = "getLoginIdCount",
        query = "Select Count (me) From ModuleEntity me Where me.loginId = :loginId")
@NamedQuery(name = "getEmailCount",
        query = "Select Count (me) From ModuleEntity me Where me.email= :email")

@NamedQuery(name = "getPhoneNoCount",
        query = "Select Count (me) From ModuleEntity me Where me.phoneNo= :phoneNo")

@NamedQuery(name = "getEmailAndPassword",
        query = "Select me from ModuleEntity me where me.email = :email")

@NamedQuery(name = "findByEmail",
        query = "select ue From ModuleEntity ue where ue.email = :email")

@NamedQuery(name = "updateByEmail",
        query = "Update ModuleEntity me set me.userName = :userName, me.age = :age, me.dob = :dob, me.phoneNo = :phoneNo, me.location = :location, me.password = :password, me.updatedBy = :updatedBy, me.updatedDate = : updatedDate, me.fileName = : fileName, me.imgProperty = :imgProperty  Where me.email = :email")

@NamedQuery(name = "getDataForUpdate",
        query = "select se from ModuleEntity se where se.email= :email")

@NamedQuery(name = "deleteUser",
        query = "Delete from ModuleEntity Where email= :email")

@NamedQuery(name = "forgetPasswordUpdate",
        query = "Update ModuleEntity me set me.password = :password, me.signinCount = 0 where me.email = :email")

public class ModuleEntity extends AbstractAuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String userName;

    private String loginId;

    private String email;

    private String gender;

    private String age;

    private String dob;

    private String phoneNo;

    private String location;

    private String password;

    private Integer signinCount = -1;

    private LocalDateTime lockTime;

    private String fileName;

    private String imgProperty;
}
