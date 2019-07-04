package com.hm.book.mapper;

import com.hm.book.bean.Category;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CategoryMapper {


    @Select("select * from category")
    @ResultMap("BaseCategoryResultMap")
    List<Category> findAllCategores();

    void addCategory(Category category);

    @Select("select * from category where id=#{xx}")
    @ResultMap("BaseCategoryResultMap")
    Category findCategoryById(String categoryId);
}