/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vnvt.controller;

import com.vnvt.service.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author ntlam
 */
@Controller
public class EmployerController {

@Autowired
    private EmployerService employerService;

    @GetMapping("/employers/{employerId}")
    public String employerDetail(Model model, @PathVariable(value = "employerId") int employerId) {
        model.addAttribute("employer", this.employerService.getEmployerById(employerId));

        return "employer-detail";
    }
}
