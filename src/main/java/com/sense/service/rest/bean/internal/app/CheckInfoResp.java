package com.sense.service.rest.bean.internal.app;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Data
@Getter
@Setter
public class CheckInfoResp {

    private String serverId;
    private String serverDateTime;
    private String ServerContextPath;
    private String BuildDateTime;

}
