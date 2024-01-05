package com.sense.service.custom.filter;

import io.swagger.annotations.ApiModelProperty;

public class ApiAttrBean {

    @ApiModelProperty(hidden = true)
    private String restUuid;

    @ApiModelProperty(hidden = true)
    private String serverId;

    @ApiModelProperty(hidden = true)
    private String restUri;

    @ApiModelProperty(hidden = true)
    private String restMethod;
    
    @ApiModelProperty(hidden = true)
    private String restUrl;
    
    @ApiModelProperty(hidden = true)
    private String reportPath;

    public String getRestUuid() {
        return restUuid;
    }

    public void setRestUuid(String restUuid) {
        this.restUuid = restUuid;
    }

    public String getServerId() {
        return serverId;
    }

    public void setServerId(String serverId) {
        this.serverId = serverId;
    }

    public String getRestUri() {
        return restUri;
    }

    public void setRestUri(String restUri) {
        this.restUri = restUri;
    }

    public String getRestMethod() {
        return restMethod;
    }

    public void setRestMethod(String restMethod) {
        this.restMethod = restMethod;
    }

    public String getRestUrl() {
        return restUrl;
    }

    public void setRestUrl(String restUrl) {
        this.restUrl = restUrl;
    }

    public String getReportPath() {
        return reportPath;
    }

    public void setReportPath(String reportPath) {
        this.reportPath = reportPath;
    }

}
