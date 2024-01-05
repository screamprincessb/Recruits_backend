package com.sense.backend.hb.bean.fm;

import lombok.Data;

@Data
public class P114StFmReportBean {

    private String base64;

    public P114StFmReportBean() {
    }

    public P114StFmReportBean(String base64) {
//        this.seqPk = seqPk;
        this.base64 = base64;
    }

}
