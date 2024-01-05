package com.sense.backend.hb.service;

import com.sense.backend.hb.dao.auth.AuthUserInfoDAO;
import com.sense.backend.hb.entity.auth.AuthUserInfo;
import com.sense.service.rest.bean.internal.auth.LoginReq;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthUserInfoService {

    @Autowired
    private AuthUserInfoDAO dao;

    @Transactional
    public void insert(AuthUserInfo entity) {
        dao.persist(entity);
    }

    @Transactional
    public List<AuthUserInfo> findAll() {
        return dao.findAll();
    }

    @Transactional
    public List<AuthUserInfo> findBySQL(String sql) {
        return dao.findBySQL(sql);
    }

    @Transactional
    public AuthUserInfo findById(String id) {
        return dao.findById(id);
    }

    @Transactional
    public List<AuthUserInfo> findByUserNameAndPassword(LoginReq req) {
        return dao.findByUserNameAndPassword(req);
    }

}
