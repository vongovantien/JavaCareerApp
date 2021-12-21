/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vnvt.controllers;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
/**
 *
 * @author ntlam
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    
    @GetMapping("/cate-stats")
    public String cateStats(Model model) {
//        model.addAttribute("cateStats", this.statsService.cateStats());
        
        return "cate-stats";
    }
    
    @GetMapping("/date-stats")
    public String dateStats(Model model, @RequestParam(required = false) Map<String, String> params) {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        String kw = params.getOrDefault("kw", null);
        
        Date fromDate = null, toDate = null;
        
        try {
            String from = params.getOrDefault("fromDate", null);
            if (from != null)
                fromDate = f.parse(from);


            String to = params.getOrDefault("toDate", null);
            if (to != null)
                toDate = f.parse(to);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
                
        
//        model.addAttribute("productStats", this.statsService.productStats(kw, fromDate, toDate));
         
        return "date-stats";
    }
    
    @GetMapping("/year-stats")
    public String productMonthStats(Model model, @RequestParam(required = false) Map<String, String> params) {
       SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        String kw = params.getOrDefault("kw", null);
        
        Date fromDate = null, toDate = null;
        
        try {
            String from = params.getOrDefault("fromDate", null);
            if (from != null)
                fromDate = f.parse(from);


            String to = params.getOrDefault("toDate", null);
            if (to != null)
                toDate = f.parse(to);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
          
//        model.addAttribute("productMonthStats", this.statsService.productMonthStats(kw, fromDate, toDate));
        
        return "year-stats";
    }
}