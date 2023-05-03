package com.bookclub.security;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class SecurityController {

    @GetMapping("/login/user")
    public String showLoginForm() {
        return "userLogin";
    }

    @GetMapping("/login")
    public String showSecondLoginForm() {
        return "login";
    }



   @PostMapping("/login/user")
   public String loginPageCustomer(){
       //Redirect to the second page
       return "redirect:/login";

   }

    @PostMapping("/login")
    public String doSecondLogin() {
        // Handle login logic for second form
        // If successful, redirect to home
        return "redirect:/home";
    }


//    @RequestMapping(path = "/login", method = RequestMethod.GET)
//    public String showLoginPage() {
//        return "login";
//    }

    @RequestMapping(path = "home")
    public String homePage() {
        return "index";
    }

    @RequestMapping(path = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request, HttpServletResponse response)
    {
        Authentication auth = SecurityContextHolder.getContext()
                .getAuthentication();

        if (auth != null) {
            new SecurityContextLogoutHandler()
                    .logout((javax.servlet.http.HttpServletRequest) request, (javax.servlet.http.HttpServletResponse) response, auth);
        }
       return "redirect:/login?logout=true";
    }

}

