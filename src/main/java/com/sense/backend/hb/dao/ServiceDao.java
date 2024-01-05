package com.sense.backend.hb.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ServiceDao {

    @Autowired
    private SessionFactory sessionFactory;


}
