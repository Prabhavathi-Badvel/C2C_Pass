package com.kspl.c2cpass;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class C2cController {
	@Autowired
    private C2cService c2cService;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listPassengers", c2cService.getAllPassengers());
        return "passengerRecord";
    }

    @GetMapping("/showNewPassengerForm")
    public String showNewPassengerForm(Model model) {
    	C2c passenger = new C2c();
        model.addAttribute("passenger", passenger);
        return "newPassenger";
    }

    @PostMapping("/savePassenger")
    public String savePassenger(@ModelAttribute("passenger") C2c passenger) {
        c2cService.savePassenger(passenger);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
        Optional<C2c> passenger = c2cService.getPassengerById(id);
        model.addAttribute("passenger", passenger);
        return "updatePassenger";
    }

    @GetMapping("/deletePassenger/{id}")
    public String deletePassenger(@PathVariable(value = "id") long id) {
        c2cService.deletePassenger(id);
        return "redirect:/";
    }
}
