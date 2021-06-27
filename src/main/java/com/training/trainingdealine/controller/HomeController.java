package com.training.trainingdealine.controller;

import com.training.trainingdealine.entity.HomeEntity;
import com.training.trainingdealine.service.HomeServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/home")
public class HomeController {

    private final HomeServiceImpl homeService;


    public HomeController(HomeServiceImpl homeService) {
        this.homeService = homeService;
    }

    @GetMapping
    public String home(Model model) {
        model.addAttribute("list", homeService.listAll());
        return "index";
    }


    @GetMapping("/create")
    public String createUI(Model model) {
        model.addAttribute("homeEntity", new HomeEntity());
        return "/create";
    }

    @PostMapping("/save")
    public String saveEntity(@ModelAttribute("homeEntity") HomeEntity homeEntity, HttpServletRequest request) {
        homeService.save(homeEntity);
        request.setAttribute("msg", "Save successfully!!");
        return "redirect:/home";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView update(@PathVariable(name = "id") Long id) {

        ModelAndView mvn = new ModelAndView("/edit");

        HomeEntity homeEntity = homeService.get(id);
        mvn.addObject("homeEntity", homeEntity);

        return mvn;
    }

    @RequestMapping("delete/{id}")
    public String delete(@PathVariable(name = "id") Long id){
        homeService.delete(id);

        return "redirect:/home";
    }

}
