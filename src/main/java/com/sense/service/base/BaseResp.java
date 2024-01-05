package com.sense.service.base;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Data
@Getter
@Setter
public class BaseResp implements Serializable{

    @JsonProperty(value = "errorcode")
    private Integer errorcode;

    @JsonProperty(value = "errormessage")
    private String errormessage;
    
     //Paing
//    @JsonProperty(value = "minRange")
//    private Integer minRange;
//    
//    @JsonProperty(value = "maxRange")
//    private Integer maxRange;
    
    @JsonProperty(value = "totalCount")
    private Integer totalCount;

}
