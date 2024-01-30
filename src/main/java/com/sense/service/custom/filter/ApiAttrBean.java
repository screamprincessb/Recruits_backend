package com.sense.service.custom.filter;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiAttrBean {

    @Schema(hidden = true)
    private String restUuid;

    @Schema(hidden = true)
    private String serverId;

    @Schema(hidden = true)
    private String restUri;

    @Schema(hidden = true)
    private String restMethod;

    @Schema(hidden = true)
    private String restUrl;

    @Schema(hidden = true)
    private String reportPath;
}

