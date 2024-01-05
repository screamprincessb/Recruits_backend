package com.sense.service.util.secure;
import java.util.Date;

public class BlackListDataBean {

    private String apiKeyId;
    private String remark;

    private String banFlag; //'Y','N'
    private Date banDt;
    private String banBy;

    public BlackListDataBean() {
    }

    public BlackListDataBean(String apiKeyId, String banFlag) {
        this.apiKeyId = apiKeyId;
        this.banFlag = banFlag;
    }

    public String getApiKeyId() {
        return apiKeyId;
    }

    public void setApiKeyId(String apiKeyId) {
        this.apiKeyId = apiKeyId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getBanFlag() {
        return banFlag;
    }

    public void setBanFlag(String banFlag) {
        this.banFlag = banFlag;
    }

    public Date getBanDt() {
        return banDt;
    }

    public void setBanDt(Date banDt) {
        this.banDt = banDt;
    }

    public String getBanBy() {
        return banBy;
    }

    public void setBanBy(String banBy) {
        this.banBy = banBy;
    }

}
