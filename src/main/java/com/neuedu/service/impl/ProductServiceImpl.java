package com.neuedu.service.impl;

import com.neuedu.dao.CategoryMapper;
import com.neuedu.dao.ProductMapper;
import com.neuedu.pojo.Category;
import com.neuedu.pojo.Product;
import com.neuedu.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService{
    @Autowired
    ProductMapper productMapper;

    @Autowired
    CategoryMapper categoryMapper;
    @Override
    public List<Product> getAllProduct() {

        return productMapper.selectAll();
    }

    @Override
    public int updateById(Product product) {
        return productMapper.updateByPrimaryKey(product);
    }

    @Override
    public int insert(Product product) {
        return productMapper.insert(product);
    }

    @Override
    public Product selectById(int id) {
        return productMapper.selectByPrimaryKey(id);
    }

    @Override
    public int deleteById(int id) {
        return productMapper.deleteByPrimaryKey(id);
    }
    @Override
    public List<Category> newSelectAll() {

        return categoryMapper.newSelectAll();


    }

    @Override
    public int updatestatus(Product product) {
        return productMapper.updatestatus(product);
    }

    @Override
    public List<Product> getfenye(int page, int size) {
        List<Product> list =productMapper.getfenye(page,size);
        return list;
    }

}
