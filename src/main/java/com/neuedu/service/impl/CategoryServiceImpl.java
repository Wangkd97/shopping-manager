package com.neuedu.service.impl;

import com.neuedu.dao.CategoryMapper;
import com.neuedu.exception.MyException;
import com.neuedu.pojo.Category;
import com.neuedu.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public int addCategory(Category category) throws MyException {
        return categoryMapper.insert(category);
    }

    @Override
    public int deleteCategory(int categoryId) throws MyException {
        return categoryMapper.deleteByPrimaryKey(categoryId);
    }

    @Override
    public int updateCategory(Category category) throws MyException {
        return categoryMapper.updateByPrimaryKey(category);
    }

    @Override
    public List<Category> findAll() throws MyException {

        return categoryMapper.selectAll();


    }

    @Override
    public Category findCategoryById(int categoryId) {

       return  categoryMapper.selectByPrimaryKey(categoryId);

    }

    @Override
    public List<Category> newSelectAll() {

        return categoryMapper.newSelectAll();


    }

    @Override
    public List<Category> selectByKind(int kind) {
        return categoryMapper.selectByKind(kind);
    }

    @Override
    public Category selectLast() {
        return categoryMapper.selectLast();
    }
}
