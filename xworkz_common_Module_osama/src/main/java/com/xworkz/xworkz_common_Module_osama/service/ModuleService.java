package com.xworkz.xworkz_common_Module_osama.service;

import com.xworkz.xworkz_common_Module_osama.dto.ModuleDto;
import com.xworkz.xworkz_common_Module_osama.entity.ModuleEntity;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

public interface ModuleService {

    boolean validateAndSave(ModuleDto moduleDto, Model model);

    String generateCaptcha();

    long getCountByUserName(String userName);

    long getCountByLoginId(String loginId);

    long getCountByEmail(String email);

    long getCountByPhone(String phoneNo);

    ModuleEntity onSignin(String email, String password, Model model);

    boolean isLockExpired(LocalDateTime lockTime);

    void deleteUserByEmail(String email);

    ModuleDto findByEmail(String email);

    boolean updatebyEmail(ModuleDto moduleDto, MultipartFile multipartFile, Model model);

    boolean forgetPasswordUpdate(String email, String password, String confirmPassword);

    boolean saveEmail(String email, String password);
}
