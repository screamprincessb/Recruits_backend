package com.sense.service.rest.bean.internal.app;

import java.util.Date;

public class AppCommonInfoResp {

    private String serverId;
    private String restUuid;
    private String infoDesc;
    private String infoLastBuild;
    private String infoVersion;
    private Date infoCurrentDt;

    public String getServerId() {
        return serverId;
    }

    public void setServerId(String serverId) {
        this.serverId = serverId;
    }

    public String getRestUuid() {
        return restUuid;
    }

    public void setRestUuid(String restUuid) {
        this.restUuid = restUuid;
    }

    public String getInfoDesc() {
        return infoDesc;
    }

    public void setInfoDesc(String infoDesc) {
        this.infoDesc = infoDesc;
    }

    public String getInfoLastBuild() {
        return infoLastBuild;
    }

    public void setInfoLastBuild(String infoLastBuild) {
        this.infoLastBuild = infoLastBuild;
    }

    public String getInfoVersion() {
        return infoVersion;
    }

    public void setInfoVersion(String infoVersion) {
        this.infoVersion = infoVersion;
    }

    public Date getInfoCurrentDt() {
        return infoCurrentDt;
    }

    public void setInfoCurrentDt(Date infoCurrentDt) {
        this.infoCurrentDt = infoCurrentDt;
    }

}
