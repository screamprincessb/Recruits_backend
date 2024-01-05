package com.sense.backend.hb.service;

import com.sense.backend.hb.dao.common.CoreConfigDAO;
import com.sense.backend.hb.entity.common.CoreConfig;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CoreConfigService {

    @Autowired
    private CoreConfigDAO dao;

    @Transactional
    public void insert(CoreConfig entity) {
        dao.persist(entity);
    }
    
     @Transactional
    public List<CoreConfig> findAll() {
        return dao.findAll();
    }

    @Transactional
    public List<CoreConfig> findBySQL(String sql) {
        return dao.findBySQL(sql);
    }

    @Transactional
    public CoreConfig findById(String id) {
        return dao.findById(id);
    }

}
