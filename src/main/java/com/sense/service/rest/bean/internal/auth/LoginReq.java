package com.sense.service.rest.bean.internal.auth;

import com.sense.service.base.BaseReqs;
import lombok.Data;

@Data
public class LoginReq extends BaseReqs {

    private LoginData data;

    @Data
    public class LoginData {

        private String userId;
        private String password;
    }
}
