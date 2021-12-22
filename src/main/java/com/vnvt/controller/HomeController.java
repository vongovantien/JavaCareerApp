package com.vnvt.controller;

import com.vnvt.pojo.Category;
import com.vnvt.service.CategoryService;
import com.vnvt.service.PostService;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@ControllerAdvice
public class HomeController {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private PostService productService;

    @ModelAttribute
    public void commonAttrs(Model model, HttpSession session) {
        model.addAttribute("categories", this.categoryService.getCategories());
        model.addAttribute("currentUser", session.getAttribute("currentUser"));
    }

    @GetMapping("/")
    public String index(Model model,
            @RequestParam(required = false) Map<String, String> params,
            HttpSession session) {
        String kw = params.getOrDefault("kw", null);
        int page = Integer.parseInt(params.getOrDefault("page", "1"));

        String cateId = params.get("CateId");
        if (cateId == null) {
            model.addAttribute("products", this.productService.getPosts(kw, page));
        } else {
            Category c = this.categoryService.getCategoryById(Integer.parseInt(cateId));
            model.addAttribute("products", c.getPostCollection());
        }

        model.addAttribute("productCounter", this.productService.countPost());
        model.addAttribute("hotPosts", this.productService.getHotPosts(6));
        model.addAttribute("disPosts", this.productService.getMostDiscussPosts(6));

        return "index";
    }
}
