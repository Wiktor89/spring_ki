package com.product.service;

import com.product.dao.IDao;
import com.product.models.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IServiceImpl implements IService {

    @Autowired
    private IDao iDao;

    @Override
    public void addMessage(Message message) {

    }
}
