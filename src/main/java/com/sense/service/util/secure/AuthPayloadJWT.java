package com.sense.service.util.secure;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import lombok.Data;

@Data
public class AuthPayloadJWT {

    private String apiKeyId;
    private String desc;
    private String role;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date expireDt;
    private String remark;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createDt;
    private String userId;
    private String password;
    private String ipAddress;
    private String createBy;

    public AuthPayloadJWT(){}

}