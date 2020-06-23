package com.website.qlts.validator;

import com.website.qlts.models.Accounts;
import com.website.qlts.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class AccountValidator implements Validator {
    @Autowired
    private AccountService accountService;

    @Autowired
    public boolean supports(Class<?> aClass){
        return Accounts.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Accounts accounts = (Accounts) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
        if (accounts.getUserName().length() < 6 || accounts.getUserName().length() > 32) {
            errors.rejectValue("username", "Size.userForm.username");
        }
        if (accountService.findByUsername(accounts.getUserName()) != null) {
            errors.rejectValue("username", "Duplicate.userForm.username");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (accounts.getPassWord().length() < 8 || accounts.getPassWord().length() > 32) {
            errors.rejectValue("password", "Size.userForm.password");
        }

        if (!accounts.getPasswordConfirm().equals(accounts.getPassWord())) {
            errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
        }
    }
}
