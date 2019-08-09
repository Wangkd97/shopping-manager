package com.neuedu.service;

import com.neuedu.pojo.Category;
import com.neuedu.pojo.Product;

import java.util.List;

public interface IProductService {

    List<Product> getAllProduct();
    int updateById(Product product);
    int insert(Product product);
    Product selectById(int id);
    int deleteById(int id);
    List<Category> newSelectAll();
    int updatestatus(Product product);
}
