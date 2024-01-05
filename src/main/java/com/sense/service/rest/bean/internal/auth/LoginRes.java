package com.sense.service.rest.bean.internal.auth;

import com.sense.backend.hb.entity.auth.AuthUserInfo;
import com.sense.service.base.BaseResp;
import java.util.List;
import lombok.Data;


@Data
public class LoginRes extends BaseResp {

    private List<AuthUserInfo> dataList;
    
}
