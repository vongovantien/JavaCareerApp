/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnvt.repository;

import com.vnvt.pojo.Category;
import java.util.List;

/**
 *
 * @author 18510
 */
public interface CategoryRepository {
    List<Category> getCategories();
    Category getCategoryById(int cateId);
}
