package com.sense.backend.hb.dao.auth;

import com.sense.backend.hb.dao.common.*;
import com.sense.backend.hb.dao.BaseDAO;
import com.sense.backend.hb.dao.BaseDAO;
import com.sense.backend.hb.entity.auth.AuthUserInfo;
import com.sense.backend.hb.entity.common.CoreConfig;
import com.sense.service.rest.bean.internal.auth.LoginReq;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AuthUserInfoDAO extends BaseDAO<AuthUserInfo, String> {

    @Autowired
    private SessionFactory sessionFactory;

    public AuthUserInfoDAO() {
        super(AuthUserInfo.class);
    }

    public List<AuthUserInfo> findByUserNameAndPassword(LoginReq req) {
        List<AuthUserInfo> resultList = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM AUTH_USER_INFO");
        sql.append(" WHERE USER_ID = '").append(req.getData().getUserId()).append("'");
        sql.append(" AND PASSWORD = '").append(req.getData().getPassword()).append("'");

        Query query = sessionFactory.getCurrentSession().createNativeQuery(sql.toString(), AuthUserInfo.class);
        resultList = query.getResultList();
        return resultList;
    }

}
