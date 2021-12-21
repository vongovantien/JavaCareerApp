/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnvt.service;

import com.vnvt.repository.*;
import com.vnvt.pojo.Post;
import java.util.List;

/**
 *
 * @author 18510
 */
public interface PostService {

    List<Post> getProducts(String kw, int page);

    List<Object[]> getHotProducts(int num);

    List<Object[]> getMostDiscussProducts(int num);

    Post getProductById(int productId);

    long countProduct();

    boolean addOrUpdate(Post post);
}
