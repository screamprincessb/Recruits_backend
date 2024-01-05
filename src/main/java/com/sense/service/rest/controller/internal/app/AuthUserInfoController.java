package com.sense.service.rest.controller.internal.app;

//import com.google.common.base.Optional;
import com.sense.backend.common.helper.ConfigHelper;
import com.sense.backend.common.helper.HBHelper;
import com.sense.backend.hb.entity.auth.AuthUserInfo;
import com.sense.service.util.ErrorMessageUtil;
import com.sense.service.util.ExceptionUtil;
import com.sense.backend.hb.service.AuthUserInfoService;
import com.sense.service.base.BaseRestController;
import com.sense.service.conts.ApiFilterConst;
import com.sense.service.conts.RestCustomConst;
import com.sense.service.rest.bean.internal.auth.LoginReq;
import com.sense.service.rest.bean.internal.auth.LoginRes;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {RestCustomConst.SERVICE_NAME_AUTH_LOGIN})
@CrossOrigin(origins = "*")
@RequestMapping(value = RestCustomConst.REST_PATH_INTERNAL_APP_AUTH)
@RestController
public class AuthUserInfoController extends BaseRestController {

    private AuthUserInfoService service;
    private Map<String, String> CONFIG = new HashMap<>();

    @PostConstruct
    public void init() {
        CONFIG = ConfigHelper.getInstance().getConfig();
    }

    @ApiOperation(value = "Get All API")
    @RequestMapping(value = RestCustomConst.SERVICE_NAME_AUTH_LOGIN, method = RequestMethod.POST)
    public LoginRes loginLogoutRequest(@RequestHeader(defaultValue = ApiFilterConst.DEFAULT_VALUE_TOKEN_KEY) String token, @RequestBody LoginReq request) {
        boolean isError = false;
        String logMsg = null;

        LoginRes response = new LoginRes();
        //validate
        if (request.getData() == null) {
            response.setErrorcode(1);
            response.setErrormessage(ErrorMessageUtil.ERROR_0000);
            return response;
        }
        service = HBHelper.instance().service(AuthUserInfoService.class);
        try {
            List<AuthUserInfo> result = service.findByUserNameAndPassword(request);
            
            response.setDataList(result);
            response.setTotalCount(result.size());
        } catch (Exception e) {
            isError = true;
            logMsg = ExceptionUtil.getLastErrorMessage(e);
            //
        } finally {
        }
        response.setErrorcode(isError ? 1 : 0);
        response.setErrormessage(logMsg);
        return response;
    }

}
