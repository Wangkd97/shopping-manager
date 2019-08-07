package com.neuedu.service.impl;

import com.neuedu.dao.ProductMapper;
import com.neuedu.pojo.Product;
import com.neuedu.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService{
    @Autowired
    ProductMapper productMapper;

    @Override
    public List<Product> getAllProduct() {

        return productMapper.selectAll();
    }
}
