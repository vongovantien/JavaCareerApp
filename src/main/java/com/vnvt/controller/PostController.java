package com.vnvt.controller;

import com.vnvt.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/posts/{postId}")
    public String postDetail(Model model, @PathVariable(value = "postId") int postId) {
        model.addAttribute("post", this.postService.getPostById(postId));

        return "post-detail";
    }
}
