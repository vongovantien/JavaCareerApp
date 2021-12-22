/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnvt.repository;

import com.vnvt.pojo.Post;
import java.util.List;

/**
 *
 * @author 18510
 */
public interface PostRepository {

    List<Post> getPosts(String kw, int page);

    List<Object[]> getHotPosts(int num);

    List<Object[]> getMostDiscussPosts(int num);

    Post getPostById(int postId);

    long countPost();

    boolean addOrUpdate(Post post);
}
