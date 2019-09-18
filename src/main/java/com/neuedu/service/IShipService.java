package com.neuedu.service;

import com.neuedu.pojo.Shipping;

public interface IShipService {
    public Shipping selectByPrimaryKey(int id);
}
