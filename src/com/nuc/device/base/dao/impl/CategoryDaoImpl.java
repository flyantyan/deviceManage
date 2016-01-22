package com.nuc.device.base.dao.impl;

import com.nuc.device.base.BaseDao;
import com.nuc.device.base.bean.Category;
import com.nuc.device.base.bean.Country;
import com.nuc.device.base.dao.CategoryDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by IDEA
 * User:Leopold
 * Email:ylp_boy@126.com
 * Date:2015/11/26
 * Time:1:23
 */
@Repository
public class CategoryDaoImpl extends BaseDao implements CategoryDao {
    @Override
    public List<Category> queryCategoryList() {
        return getSession().selectList("category.queryCategoryList");
    }

    @Override
    public Category queryCategoryById(Long id) {
        return getSession().selectOne("category.queryCategoryById",id);
    }

    @Override
    public void updateCategory(Category category) {
        getSession().update("category.updateCategory",category);
    }

    @Override
    public void delCategory(Category category) {
        getSession().update("category.delCategory",category);
    }

    @Override
    public void insertCategory(Category category) {
            getSession().insert("category.insertCategory",category);
    }
}
