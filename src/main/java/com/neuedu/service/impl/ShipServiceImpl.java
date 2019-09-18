package com.neuedu.service.impl;

import com.neuedu.dao.ShippingMapper;
import com.neuedu.pojo.Shipping;
import com.neuedu.service.IShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShipServiceImpl implements IShipService{

    @Autowired
    ShippingMapper iShipService;

    @Override
    public Shipping selectByPrimaryKey(int id) {
        return iShipService.selectByPrimaryKey(id);
    }
}
