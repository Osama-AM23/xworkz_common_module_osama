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

    public ModuleServiceImpl() {
        System.out.println("ModuleServiceImpl is Created");
    }

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

            if (moduleDto.getEmail() != null && moduleDto.getEmail().contains("@gmail.com") && moduleDto.getEmail().matches("^[a-z0-9]+@gmail\\.com$")) {
                mEntity.setEmail(moduleDto.getEmail());
            } else {
                isValidate = false;
                model.addAttribute("emailError", "Email must be contain @ and gmail.com and use any numbers");
            }

            if (moduleDto.getAge() != null && moduleDto.getAge() >= 18) {
                mEntity.setAge(moduleDto.getAge());
            } else {
                isValidate = false;
                model.addAttribute("ageError", "Age must be above 18+");
            }

            if (moduleDto.getPassword().equals(moduleDto.getConfirmPassword()) && moduleDto.getPassword().length() >= 8 && moduleDto.getPassword().matches(".*[0-9].*") && moduleDto.getPassword().matches(".*[!@#$%^&,.].*") && moduleDto.getPassword().matches(".*[A-Z].*")) {
                String encoded = encodedPassword.encode(moduleDto.getPassword());
                mEntity.setPassword(encoded);

            } else {
                isValidate = false;
                model.addAttribute("passwordError", "Password must be at least 8 characters and must be contain Special character and Numbers");
            }

            if (isValidate) {
                return moduleRepository.save(mEntity);
            }
        }

        return false;
    }

    @Override
    public ModuleDto onSignin(String email, String password, Model model) {
        ModuleDto moduleDto = new ModuleDto();
        ModuleEntity moduleEntity = moduleRepository.onSignin(email);
        if (moduleEntity != null) {
            if (encodedPassword.matches(password, moduleEntity.getPassword())) {
                BeanUtils.copyProperties(moduleEntity, moduleDto);
                System.out.println("SERVICE: " + moduleEntity);
                return moduleDto;
            } else {
                model.addAttribute("errorMessage", "Invalid Email or Password");
            }
        }
        return null;
    }

    // geting the data from DB
    @Override
    public ModuleDto findByEmail(String email) {
        ModuleDto moduleDto = new ModuleDto();
        ModuleEntity moduleEntity = moduleRepository.findByEmail(email);

        BeanUtils.copyProperties(moduleEntity, moduleDto);
        System.out.println("GET-SERVICE :" + moduleEntity);
        return moduleDto;
    }

    // update the details by email
    @Override
    public boolean updatebyEmail(ModuleDto moduleDto, Model model) {

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

            if (moduleDto.getEmail() != null && moduleDto.getEmail().contains("@gmail.com") && moduleDto.getEmail().matches("^[a-z0-9]+@gmail\\.com$")) {
                mEntity.setEmail(moduleDto.getEmail());
            } else {
                isValidate = false;
                model.addAttribute("emailError", "Email must be contain @ and gmail.com and use any numbers");
            }

            if (moduleDto.getAge() != null && moduleDto.getAge() >= 18) {
                mEntity.setAge(moduleDto.getAge());
            } else {
                isValidate = false;
                model.addAttribute("ageError", "Age must be above 18+");
            }

            if (moduleDto.getPassword().equals(moduleDto.getConfirmPassword()) && moduleDto.getPassword().length() >= 8 && moduleDto.getPassword().matches(".*[0-9].*") && moduleDto.getPassword().matches(".*[!@#$%^&,.].*") && moduleDto.getPassword().matches(".*[A-Z].*")) {
                String encoded = encodedPassword.encode(moduleDto.getPassword());
                mEntity.setPassword(encoded);

            } else {
                isValidate = false;
                model.addAttribute("passwordError", "Password must be at least 8 characters and must be contain Special character and Numbers");
            }

            if (isValidate) {
                return moduleRepository.updateByEmail(mEntity);
            }
        }
        return false;
    }


}
