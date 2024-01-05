package com.sense.service.custom.filter;
import java.util.Date;

public class ApiAuthBean {

    private String apiKey;

    private Date expireDt;

    private String status; // 'Y','N'
    private String role; // 'USER | ADMIN | SUPER_ADMIN'

    private Date genDt;
    private Date genBy;

    public ApiAuthBean() {
    }

    public ApiAuthBean(String apiKey, Date expireDt, String status, String role) {
        this.apiKey = apiKey;
        this.expireDt = expireDt;
        this.status = status;
        this.role = role;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public Date getExpireDt() {
        return expireDt;
    }

    public void setExpireDt(Date expireDt) {
        this.expireDt = expireDt;
    }

    public Date getGenDt() {
        return genDt;
    }

    public void setGenDt(Date genDt) {
        this.genDt = genDt;
    }

    public Date getGenBy() {
        return genBy;
    }

    public void setGenBy(Date genBy) {
        this.genBy = genBy;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}