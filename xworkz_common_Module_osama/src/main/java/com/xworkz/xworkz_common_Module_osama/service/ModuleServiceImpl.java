package com.xworkz.xworkz_common_Module_osama.service;

import com.xworkz.xworkz_common_Module_osama.dto.ModuleDto;
import com.xworkz.xworkz_common_Module_osama.entity.ModuleEntity;
import com.xworkz.xworkz_common_Module_osama.repository.ModuleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.Properties;
import java.util.Random;

@Slf4j
@Service
public class ModuleServiceImpl implements ModuleService {

    @Autowired
    ModuleRepository moduleRepository;

    ModuleEntity mEntity = new ModuleEntity();

    private String autoGeneratePassword;

     private BCryptPasswordEncoder encodedPassword = new BCryptPasswordEncoder();

    public String autoGeneratePassword() {

        String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCase = "abcdefghijklmnopqrstuvwyz";
        String numbers = "0123456789";
        String specialChar = "!@#$%^&*";

        String autoGenerate = upperCase + lowerCase + numbers + specialChar;

        Random random = new Random();
        StringBuilder autoPassword = new StringBuilder();

        for (int i = 0; i <= 8; i++) {
            autoPassword.append(autoGenerate.charAt(random.nextInt(autoGenerate.length())));
        }
        return autoPassword.toString();
    }

    @Override
    public String generateCaptcha() {

        String captchaChar = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0987654321";

        StringBuilder captcha = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i <= 6; i++) {
            captcha.append(captchaChar.charAt(random.nextInt(captchaChar.length())));
        }
        return captcha.toString();
    }

    @Override
    public boolean validateAndSave(ModuleDto moduleDto, Model model) {

        boolean isValidate = true;

        if (moduleDto != null) {

            BeanUtils.copyProperties(moduleDto, mEntity);

            if (moduleDto.getUserName() != null && !moduleDto.getUserName().isEmpty() && moduleDto.getUserName().length() >= 3 && moduleDto.getUserName().length() <= 25 && moduleDto.getUserName().matches("[A-Z][a-z]*")) {
                mEntity.setUserName(moduleDto.getUserName());
                mEntity.setCreatedBy(moduleDto.getUserName());
                mEntity.setCreatedDate(LocalDateTime.now());
            } else {
                isValidate = false;
                model.addAttribute("userNameError", "Username must be between 3 and 25 characters and start with an uppercase letter");
            }

            if (moduleDto.getLoginId() != null) {
                int loginId = Integer.parseInt(moduleDto.getLoginId());
                if (loginId >= 10 && loginId <= 9999) {
                    mEntity.setLoginId(moduleDto.getLoginId());
                } else {
                    isValidate = false;
                    model.addAttribute("loginIdError", "Login Id should be between 10 and 9999");
                }
            } else {
                isValidate = false;
                model.addAttribute("loginIdError", "Login Id is Required");
            }

            if (moduleDto.getPhoneNo() != null && moduleDto.getPhoneNo().length() == 10 && moduleDto.getPhoneNo().matches("^[976]\\d{9}$")) {
                mEntity.setPhoneNo(moduleDto.getPhoneNo());
            } else {
                isValidate = false;
                model.addAttribute("phoneNoError", "Phone number must be exactly 10 digits and start with 9, 7, or 6");
            }

            if (moduleDto.getEmail() != null && moduleDto.getEmail().contains("@gmail.com") && moduleDto.getEmail().matches("^[a-z0-9._]+@gmail\\.com$")) {
                autoGeneratePassword = autoGeneratePassword();
                mEntity.setPassword(autoGeneratePassword);
                log.info("Auto Password :" + autoGeneratePassword);
                mEntity.setEmail(moduleDto.getEmail());
                boolean savedEmail = saveEmail(moduleDto.getEmail(), autoGeneratePassword);
                if (savedEmail) {
                    log.info("Email is sended");
                }
            } else {
                isValidate = false;
                model.addAttribute("emailError", "Email must be contain @ and gmail.com and use any numbers");
            }

            if (moduleDto.getAge() != null) {
                int age = Integer.parseInt(moduleDto.getAge());
                if (age >= 18) {
                    mEntity.setAge(moduleDto.getAge());
                } else {
                    isValidate = false;
                    model.addAttribute("ageError", "Age must be 18 or above");
                }
            } else {
                isValidate = false;
                model.addAttribute("ageError", "Invalid age format. Please enter a number.");
            }


            if (isValidate) {
                return moduleRepository.save(mEntity);
            }
        }

        return false;
    }

    @Override
    public long getCountByUserName(String userName) {
        return moduleRepository.getCountOfName(userName);
    }

    @Override
    public long getCountByLoginId(String loginId) {
        return moduleRepository.getCountOfLoginId(loginId);
    }

    @Override
    public long getCountByEmail(String email) {
        return moduleRepository.getCountOfEmail(email);
    }

    @Override
    public long getCountByPhone(String phoneNo) {
        return moduleRepository.getCountOfPhoneNo(phoneNo);
    }

    @Override
    public ModuleEntity onSignin(String email, String password, Model model) {
        ModuleDto moduleDto = new ModuleDto();
        ModuleEntity moduleEntity = moduleRepository.onSignin(email);
        if (moduleEntity == null) {
            return null;
        }
        if (moduleEntity.getLockTime() != null && isLockExpired(moduleEntity.getLockTime())) {
            moduleEntity.setLockTime(null);
            moduleRepository.onUpdateCount(moduleEntity);
        }
        if (moduleEntity.getSigninCount() == -1) {
            return moduleEntity;
        } else if (moduleEntity.getSigninCount() > 2) {
            model.addAttribute("errorMessage", "Your Account is locked");
            log.info("Your Account is locked");
            moduleEntity.setLockTime(LocalDateTime.now());
            moduleRepository.setLockTime(email, moduleEntity);
            return null;
        } else if (encodedPassword.matches(password, moduleEntity.getPassword())) {
            moduleEntity.setSigninCount(0);
            moduleRepository.onUpdateCount(moduleEntity);
            moduleRepository.setLockTime(email, moduleEntity);
            return moduleEntity;
        } else {
            int attempt = moduleEntity.getSigninCount() + 1;
            moduleEntity.setSigninCount(attempt);
            moduleEntity.setLockTime(LocalDateTime.now());
            moduleRepository.onUpdateCount(moduleEntity);
            moduleRepository.setLockTime(email, moduleEntity);
            return null;
        }
    }

    @Override
    public boolean isLockExpired(LocalDateTime lockTime) {
        return lockTime.plusMinutes(2).isBefore(LocalDateTime.now());
    }

    @Override
    public void deleteUserByEmail(String email) {
        moduleRepository.deleteUserByEmail(email);
    }

    // geting the data from DB
    @Override
    public ModuleDto findByEmail(String email) {
        ModuleDto moduleDto = new ModuleDto();
        ModuleEntity moduleEntity = moduleRepository.findByEmail(email);

        BeanUtils.copyProperties(moduleEntity, moduleDto);
        log.info("GET-SERVICE :" + moduleEntity);
        return moduleDto;
    }

    // update the details by email
    @Override
    public boolean updatebyEmail(ModuleDto moduleDto, Model model) {

        boolean isValidate = true;

        if (moduleDto != null) {

            BeanUtils.copyProperties(moduleDto, mEntity);

            if (moduleDto.getUserName() != null && !moduleDto.getUserName().isEmpty() && moduleDto.getUserName().length() >= 3 && moduleDto.getUserName().length() <= 25 && moduleDto.getUserName().matches("[A-Z][a-z]*")) {
                mEntity.setUserName(moduleDto.getUserName());
                mEntity.setUpdatedBy(moduleDto.getUserName());
                mEntity.setUpdatedDate(LocalDateTime.now());
            } else {
                isValidate = false;
                model.addAttribute("userNameError", "Username must be between 3 and 25 characters and start with an uppercase letter");
            }

            if (moduleDto.getPhoneNo() != null && moduleDto.getPhoneNo().length() == 10 && moduleDto.getPhoneNo().matches("^[976]\\d{9}$")) {
                mEntity.setPhoneNo(moduleDto.getPhoneNo());
            } else {
                isValidate = false;
                model.addAttribute("phoneNoError", "Phone number must be exactly 10 digits and start with 9, 7, or 6");
            }


            if (moduleDto.getAge() != null) {
                int age = Integer.parseInt(moduleDto.getAge());
                if (age >= 18) {
                    mEntity.setAge(moduleDto.getAge());
                } else {
                    isValidate = false;
                    model.addAttribute("ageError", "Age must be 18 or above");
                }
            } else {
                isValidate = false;
                model.addAttribute("ageError", "Invalid age format. Please enter a number.");
            }

            return moduleRepository.updateByEmail(mEntity);

        }
        return false;
    }


    @Override
    public boolean forgetPasswordUpdate(String email, String password, String confirmPassword) {
        if (password.equals(confirmPassword)) {
            ModuleEntity moduleEntity = moduleRepository.getDataForUpdate(email);
            if (moduleEntity != null) {
                moduleEntity.setPassword(encodedPassword.encode(confirmPassword));
                moduleEntity.setSigninCount(0);
                return moduleRepository.forgetPasswordUpdate(moduleEntity);
            }
            return false;
        }
        return false;
    }

    @Override
    public boolean saveEmail(String email, String password) {

        final String username = "osamavr691@gmail.com";
        final String userPassword = "zsqb vnxk ekbm tusu";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, userPassword);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(email)
            );
            message.setSubject("Secure-Password of X-workz SignUp");
            message.setText("Secure_Password:  " + password);

            Transport.send(message);

            log.info("Password Send Successfully to User");

        } catch (MessagingException e) {
            e.printStackTrace();
        }


        return true;
    }


}
