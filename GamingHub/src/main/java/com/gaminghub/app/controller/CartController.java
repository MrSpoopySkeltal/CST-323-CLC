package com.gaminghub.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CartController {
  @GetMapping("/cart")
  public String cart(Model model) {
    model.addAttribute("cartCount", 0); // replace with real count
    return "cart"; 
  }
}
