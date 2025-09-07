package com.gaminghub.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Validated
public class SupportController {

  // Option A: render the page
  @GetMapping("/about")
  public String about(Model model) {
    // If you want a blank form object:
    if (!model.containsAttribute("supportForm")) {
      model.addAttribute("supportForm", new SupportForm());
    }
    return "about"; // templates/about.html
  }

  // Option B: handle support form submit (PRG pattern)
  @PostMapping("/support")
  public String submitSupport(@ModelAttribute("supportForm") @Validated SupportForm form,
                              BindingResult br,
                              RedirectAttributes ra) {
    if (br.hasErrors()) {
      ra.addFlashAttribute("org.springframework.validation.BindingResult.supportForm", br);
      ra.addFlashAttribute("supportForm", form);
      return "redirect:/about#support";
    }

    // TODO: hand off to a service (email, DB ticket, etc.)
    // supportService.createTicket(form.getName(), form.getEmail(), form.getMessage());

    ra.addFlashAttribute("supportSent", true);
    return "redirect:/about#support";
  }

  // Simple DTO for validation
  public static class SupportForm {
    private String name;
    private String email;
    private String message;

    public String getName() { return name; }
    public void setName(String n) { this.name = n; }
    public String getEmail() { return email; }
    public void setEmail(String e) { this.email = e; }
    public String getMessage() { return message; }
    public void setMessage(String m) { this.message = m; }
  }
}