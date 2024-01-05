package com.sense.backend.hb.dao.common;

import com.sense.backend.common.conts.BackendConst;
import com.sense.backend.hb.dao.BaseDAO;
import com.sense.backend.hb.dao.BaseDAO;
import com.sense.backend.hb.entity.common.LogStoredProcedure;
import com.sense.service.util.BackEndDateTimeUtil;
import java.sql.Timestamp;
import java.util.Date;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LogStoredProcedureDAO extends BaseDAO<LogStoredProcedure, Long> {

    @Autowired
    private SessionFactory sessionFactory;

    public LogStoredProcedureDAO() {
        super(LogStoredProcedure.class);
    }

    public void deleteOldLog() {
        Date currDt = BackEndDateTimeUtil.currentDateTime();
        Timestamp ts = BackEndDateTimeUtil.addDay(currDt.getTime(), BackendConst.DAY_DELETE_OLD_LOG * -1);

        String dtStr = BackEndDateTimeUtil.convertDateTime2String(ts.getTime(), BackEndDateTimeUtil.DATE_TIME_FORMAT_5);
        StringBuilder sb = new StringBuilder();
        sb.append("delete from LOG_STORED_PROCEDURE where LOG_DT < ");
        sb.append(" 'param' ");
        String sql = sb.toString();
        sql = sql.replaceFirst("param", dtStr);

        sessionFactory.getCurrentSession().createNativeQuery(sql).executeUpdate();
    }

}
