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
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = RestCustomConst.SERVICE_NAME_AUTH_LOGIN)
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

    @Operation(summary = "Get All API")
    @RequestMapping(value = RestCustomConst.SERVICE_NAME_AUTH_LOGIN, method = RequestMethod.POST)
    public ResponseEntity<?> loginLogoutRequest(@RequestHeader(defaultValue = ApiFilterConst.DEFAULT_VALUE_TOKEN_KEY) String token, @RequestBody LoginReq request) {
        boolean isError = false;
        String logMsg = null;

        LoginRes response = new LoginRes();
        //validate
        if (request.getData() == null) {
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
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
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
