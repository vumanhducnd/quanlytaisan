package com.website.qlts.controller;

import com.website.qlts.dto.UserRegistrationDto;
import com.website.qlts.entity.Users;
import com.website.qlts.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping(value = "/")
    public String home() {
        return "pages/user/index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Model model) {
        model.addAttribute("user", new Users());
        return "pages/user/login";
    }

    @RequestMapping(value = "/logout")
    public String logoutPage() {
        return "pages/user/logout";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerPage(Model model) {
        model.addAttribute("user", new UserRegistrationDto());
        return "pages/user/register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerPage(@ModelAttribute("user") UserRegistrationDto userRegistrationDto) {
        userService.save(userRegistrationDto);
        return "redirect:/register?success";
    }


}
