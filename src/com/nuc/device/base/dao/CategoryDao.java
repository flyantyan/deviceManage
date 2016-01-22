package com.nuc.device.base.dao;

import com.nuc.device.base.bean.Category;
import com.nuc.device.base.bean.Country;

import java.util.List;

/**
 * Created by IDEA
 * User:Leopold
 * Email:ylp_boy@126.com
 * Date:2015/11/26
 * Time:1:22
 */
public interface CategoryDao {
    public List<Category> queryCategoryList();
    public Category queryCategoryById(Long id);
    public void updateCategory(Category category);
    public void delCategory(Category category);
    public void insertCategory(Category category);
}
