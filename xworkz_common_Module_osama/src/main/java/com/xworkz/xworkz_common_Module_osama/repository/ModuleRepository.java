package com.xworkz.xworkz_common_Module_osama.repository;

import com.xworkz.xworkz_common_Module_osama.entity.ModuleEntity;

import java.time.LocalDateTime;

public interface ModuleRepository {

    boolean save(ModuleEntity moduleEntity);

    long getCountOfName(String userName);

    long getCountOfLoginId(String loginId);

    long getCountOfEmail(String email);

    long getCountOfPhoneNo(String phoneNo);

    ModuleEntity onSignin(String email);

    ModuleEntity findByEmail(String email);

    boolean onUpdateCount(ModuleEntity moduleEntity);

    boolean updateByEmail(ModuleEntity moduleEntity);

    boolean setLockTime(String email, ModuleEntity moduleEntity);

    void deleteUserByEmail(String email);

    ModuleEntity getDataForUpdate(String email);

    boolean forgetPasswordUpdate(ModuleEntity moduleEntity);


}
