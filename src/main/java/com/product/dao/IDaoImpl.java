package com.product.dao;

import com.product.models.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class IDaoImpl implements IDao {

    @Autowired
    private Message message;
}
