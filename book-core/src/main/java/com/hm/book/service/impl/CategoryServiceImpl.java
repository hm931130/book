package com.hm.book.service.impl;

import com.hm.book.bean.Category;
import com.hm.book.mapper.CategoryMapper;
import com.hm.book.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @program: bookmgr
 * @Date: 2019/7/3 14:57
 * @Author: Mr.Han
 * @Description:
 */
@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;


    public List<Category> findAllCategores() {
        return categoryMapper.findAllCategores();
    }

    public void addCategory(Category category) {
        category.setCreateTime(new Date());
        category.setUpdateTime(new Date());
        categoryMapper.addCategory(category);
    }

    public Category findCategoryById(String categoryId) {
        return categoryMapper.findCategoryById(categoryId);
    }
}
