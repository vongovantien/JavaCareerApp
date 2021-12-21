package com.vnvt.controller;


import com.vnvt.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
@ControllerAdvice
public class HomeController {

//    @Autowired
//    private CategoryService categoryService;
//
//    @ModelAttribute
//    public void commonAttribute(Model model) {
//        model.addAttribute("categories", model);
//    }

    @GetMapping("/")
    public String index(Model model) {

        return "index";
    }
}
