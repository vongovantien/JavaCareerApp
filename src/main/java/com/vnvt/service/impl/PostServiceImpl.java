/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnvt.service.impl;

import com.vnvt.service.PostService;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.vnvt.pojo.Post;
import com.vnvt.repository.PostRepository;
import com.vnvt.service.PostService;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author 18510
 */
@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private Cloudinary cloudinary;

    @Override
    public List<Post> getPosts(String kw, int page) {
        return this.postRepository.getPosts(kw, page);
    }

    @Override
    public boolean addOrUpdate(Post post) {
//        String p ="";
//        p.startsWith(p)
//        try {
//            Map r = this.cloudinary.uploader().upload(post.getFile().getBytes(),
//                    ObjectUtils.asMap("resource_type", "auto"));
//            post.setImage((String) r.get("secure_url"));
//            
//            return this.postRepository.addOrUpdate(post);
//        } catch (IOException ex) {
//            System.err.println("== ADD PRODUCT ==" + ex.getMessage());
//        }

        return false;
    }

    @Override
    public long countPost() {
        return this.postRepository.countPost();
    }

    @Override
    public Post getPostById(int i) {
        return this.postRepository.getPostById(i);
    }

    @Override
    public List<Object[]> getHotPosts(int num) {
        return this.postRepository.getHotPosts(num);
    }

    @Override
    public List<Object[]> getMostDiscussPosts(int i) {
        return this.postRepository.getMostDiscussPosts(i);
    }
}
