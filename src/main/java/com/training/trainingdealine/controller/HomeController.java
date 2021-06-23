package com.training.trainingdealine.controller;

import com.training.trainingdealine.entity.HomeEntity;
import com.training.trainingdealine.repository.HomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private HomeRepository homeRepository;


    @GetMapping
    public String home(Model model) {
        model.addAttribute("list", homeRepository.findAll());
        return "index";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @GetMapping("/create")
    public String createUI(Model model) {
        model.addAttribute("homeEntity", new HomeEntity());
        return "/create";
    }

    @PostMapping("/create")
    public String storeEntity(@ModelAttribute("homeEntity") HomeEntity homeEntity, RedirectAttributes redirectAttributes) {
        homeRepository.save(homeEntity);
        redirectAttributes.addAttribute("msg", "Save successfuly!!");
        return "redirect:/home";
    }

    @GetMapping("/update")
    public String updateH(Model model) {
        model.addAttribute("homeEntity", new HomeEntity());
        return "/create";
    }

    @PutMapping("/update")
    public String update(@ModelAttribute("homeEntity") HomeEntity homeEntity, RedirectAttributes redirectAttributes) {
        homeRepository.saveAndFlush(homeEntity);
        redirectAttributes.addAttribute("sv", "Update succesfuly.");
        return "redirect:/home";
    }

}
