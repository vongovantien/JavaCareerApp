/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnvt.service;

import com.vnvt.pojo.Comment;
import com.vnvt.pojo.User;

/**
 *
 * @author 18510
 */
public interface CommentService {

    Comment addComment(String content, int productId, User creator);
}
