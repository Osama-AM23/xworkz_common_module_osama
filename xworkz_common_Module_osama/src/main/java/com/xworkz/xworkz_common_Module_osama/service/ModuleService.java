package com.xworkz.xworkz_common_Module_osama.service;

import com.xworkz.xworkz_common_Module_osama.dto.ModuleDto;
import org.springframework.ui.Model;

public interface ModuleService {

    boolean validateAndSave(ModuleDto moduleDto, Model model);

    ModuleDto onSignin(String email, String password, Model model);

    ModuleDto findByEmail(String email);

    boolean updatebyEmail(ModuleDto moduleDto, Model model);
}
