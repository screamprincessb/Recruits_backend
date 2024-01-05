package com.sense.service.rest.report.response;

import com.sense.service.base.BaseResp;

public class ReportResponse extends BaseResp {

    private String status;
    private String errorMsg;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

}
