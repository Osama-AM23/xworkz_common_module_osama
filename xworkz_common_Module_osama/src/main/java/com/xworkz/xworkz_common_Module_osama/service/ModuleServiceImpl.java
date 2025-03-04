package com.xworkz.xworkz_common_Module_osama.service;

import com.xworkz.xworkz_common_Module_osama.dto.ModuleDto;
import com.xworkz.xworkz_common_Module_osama.entity.ModuleEntity;
import com.xworkz.xworkz_common_Module_osama.repository.ModuleRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class ModuleServiceImpl implements ModuleService {

    @Autowired
    ModuleRepository moduleRepository;

    ModuleEntity mEntity = new ModuleEntity();
    private BCryptPasswordEncoder encodedPassword = new BCryptPasswordEncoder();

    @Override
    public boolean validateAndSave(ModuleDto moduleDto, Model model) {

        boolean isValidate = true;

        if (moduleDto != null) {

            BeanUtils.copyProperties(moduleDto, mEntity);

            if (moduleDto.getUserName() != null && !moduleDto.getUserName().isEmpty() &&
                    moduleDto.getUserName().length() >= 3 && moduleDto.getUserName().length() <= 25 &&
                    moduleDto.getUserName().matches("[A-Z][a-z]*")) {
                mEntity.setUserName(moduleDto.getUserName());
            } else {
                isValidate = false;
                model.addAttribute("userNameError", "Username must be between 3 and 25 characters and start with an uppercase letter");
            }

            String strPhone = moduleDto.getPhoneNo() != null ? moduleDto.getPhoneNo().toString() : "";
            if (moduleDto.getPhoneNo() != null && strPhone.length() == 10 && strPhone.matches("^[976]\\d{9}$")) {
                mEntity.setPhoneNo(moduleDto.getPhoneNo());
            } else {
                isValidate = false;
                model.addAttribute("phoneNoError", "Phone number must be exactly 10 digits and start with 9, 7, or 6");
            }

            if (moduleDto.getPassword().equals(moduleDto.getConfirmPassword()) && moduleDto.getPassword().length() > 6) {
                String encoded = encodedPassword.encode(moduleDto.getPassword());
                mEntity.setPassword(encoded);

            } else {
                isValidate = false;
                model.addAttribute("passwordError", "Password must be at least 7 characters and match the confirm password");
            }

            if (isValidate) {
                return moduleRepository.save(mEntity);
            }
        }

        return false;
    }
}
