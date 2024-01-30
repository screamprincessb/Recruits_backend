package com.sense.service.base;

import com.sense.service.conts.ApiFilterConst;
import com.sense.service.custom.filter.ApiAttrBean;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ModelAttribute;

public class BaseRestController {

    @ModelAttribute(ApiFilterConst.ATTR_DATA_NAME)
    public ApiAttrBean getAttrData(HttpServletRequest request) {
        return (ApiAttrBean) request.getAttribute(ApiFilterConst.ATTR_DATA_NAME);
    }
}
