/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnvt.service.impl;

import com.vnvt.pojo.Comment;
import com.vnvt.pojo.Post;
import com.vnvt.pojo.User;
import com.vnvt.repository.CommentRepository;
import com.vnvt.repository.PostRepository;
import com.vnvt.repository.UserRepository;
import com.vnvt.service.CommentService;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author 18510
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Comment addComment(String content, int productId, User creator) {
        Post p = this.postRepository.getPostById(productId);
//        User u = this.userRepository.getUserById(6);

        Comment c = new Comment();
        c.setContent(content);
//        c.setPost(p);
//        c.setUserId(creator);
        c.setCreatedDate(new Date());

        return this.commentRepository.addComment(c);
    }

}
