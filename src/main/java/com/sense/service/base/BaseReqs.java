package com.sense.service.base;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BaseReqs {

    @JsonProperty(value = "userInfo")
    private String userInfo;

    @JsonProperty(value = "mode")
    private String mode;

    @JsonProperty(value = "menuCode")
    private String menuCode;

    //Paing
    @JsonProperty(value = "minRange")
    private Integer minRange;

    @JsonProperty(value = "maxRange")
    private Integer maxRange;

}
