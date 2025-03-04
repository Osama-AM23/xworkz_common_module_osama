package com.xworkz.xworkz_common_Module_osama.service;

import com.xworkz.xworkz_common_Module_osama.dto.ModuleDto;
import org.springframework.ui.Model;

public interface ModuleService {

    boolean validateAndSave(ModuleDto moduleDto, Model model);
}
