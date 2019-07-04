package com.hm.book.service;

import com.hm.book.bean.Category;

import java.util.List;

/**
 * @program: bookmgr
 * @Date: 2019/7/3 14:57
 * @Author: Mr.Han
 * @Description:
 */
public interface CategoryService {

 List<Category> findAllCategores();

 void addCategory(Category category);

    Category findCategoryById(String categoryId);
}
