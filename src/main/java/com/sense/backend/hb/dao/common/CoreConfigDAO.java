package com.sense.backend.hb.dao.common;

import com.sense.backend.hb.dao.BaseDAO;
import com.sense.backend.hb.dao.BaseDAO;
import com.sense.backend.hb.entity.common.CoreConfig;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CoreConfigDAO extends BaseDAO<CoreConfig, String> {

    @Autowired
    private SessionFactory sessionFactory;

    public CoreConfigDAO() {
        super(CoreConfig.class);
    }


}
