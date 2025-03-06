package com.xworkz.xworkz_common_Module_osama.repository;

import com.xworkz.xworkz_common_Module_osama.entity.ModuleEntity;

public interface ModuleRepository {

    boolean save(ModuleEntity moduleEntity);

    ModuleEntity onSignin(String email);

    ModuleEntity findByEmail(String email);

    boolean updateByEmail(ModuleEntity moduleEntity);
}
