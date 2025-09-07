package com.gaminghub.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfileController {
  @GetMapping("/profile")
  public String profile(Model model) {
     //model.addAttribute("user", userService.getCurrent());  //these are used for Auth
     //model.addAttribute("paymentMethods", paymentService.listForUser()); //These is used for auth
    model.addAttribute("cartCount", 0);
    return "profile";
  }
}
