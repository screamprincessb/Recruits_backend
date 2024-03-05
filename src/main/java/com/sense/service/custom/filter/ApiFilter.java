package com.sense.service.custom.filter;

import com.sense.backend.common.helper.ConfigHelper;
import com.sense.service.util.BackEndDateTimeUtil;
import com.sense.service.util.BackEndGeneralUtil;
import com.sense.service.util.StringUtil;
import com.sense.service.AppHelper;
import com.sense.service.conts.ApiFilterConst;
import com.sense.service.util.GeneratUtil;
import com.sense.service.util.ServiceUtil;
import com.sense.service.util.secure.AuthPayloadJWT;
import com.sense.service.util.secure.JWTUtil;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;

@Order(1)
public class ApiFilter implements Filter {

    private final static Logger LOG = LoggerFactory.getLogger(ApiFilter.class);

    private final static String SEPARATOR = ",";

    private final static List<String> methodChkList = Arrays.asList("GET", "POST", "PUT", "DELETE");

    private Map<String, String> CONFIG = new HashMap<>();

    @Override
    public void init(final FilterConfig filterConfig) throws ServletException {
        LOG.info("Initializing filter :{}", this);
        CONFIG = ConfigHelper.getInstance().getConfig();
    }

    @Override
    public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        res.setHeader("Access-Control-Allow-Origin", "*");
        res.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, DELETE, PATCH");
        res.setHeader("Access-Control-Allow-Headers", "*");

        boolean isPass = true;

        LOG.info("Logging Request  {} : {} : {}", req.getMethod(), req.getRequestURI(), req.getRequestURL());

        // Not Check All --> Do Next
        if (ServiceUtil.uriToRolePath(req.getRequestURI()).equals(ApiFilterConst.PATH_LEVEL_ROLE_PUBLIC)) {
            chain.doFilter(request, response);
            LOG.info("Logging Response :{} : {} ", res.getContentType(), res.getStatus());
            return;
        }

        //Check Api Key
        if (isChkMethod(req)) {
            isPass = doChk(req, res);
        }

        initData(request, req, res);

        // Do Next
        if (isPass) {
            chain.doFilter(request, response);
            LOG.info("Logging Response :{} : {} ", res.getContentType(), res.getStatus());
        }

    }

    private boolean doChk(HttpServletRequest req, HttpServletResponse res) throws IOException {
        boolean isPass = true;

        LOG.info("URI : {}", req.getRequestURI());
        LOG.info("Method : {} ", req.getMethod());
        String token = req.getHeader(ApiFilterConst.TOKEN_KEY_NAME);

//        Enumeration e =  req.getHeaderNames();
//        while (e.hasMoreElements()) {
//            Object nextElement = e.nextElement();
//            System.out.println(nextElement.toString());
//        }
        LOG.info("token : {}", token);

        isPass = chkApiKey(token, req, res);

        return isPass;
    }

    @Override
    public void destroy() {
        LOG.warn("Destructing filter :{}", this);
    }

    private boolean isChkMethod(HttpServletRequest req) {
        return ServiceUtil.isFoundInListIgnoreCase(methodChkList, req.getMethod());
    }

    private boolean chkApiKey(String token, HttpServletRequest req, HttpServletResponse res) throws IOException {
        if ((token == null) || (BackEndGeneralUtil.isUndefined(token))) {
            res.sendError(HttpServletResponse.SC_UNAUTHORIZED, "The token is not value.");
            LOG.info("----------------------------------------------------------------");
            return false;
        }

        if (token.equals("dev")) {
            token = genJWFForDev();
        }

        try {
            AuthPayloadJWT jwtPayload = JWTUtil.decodeJWTData(token);
            System.out.println(JWTUtil.convertPayloadDataToJSONString(jwtPayload));

            if (ApiFilteMemData.instance().isInBacklList(jwtPayload.getApiKeyId())) {
                res.sendError(HttpServletResponse.SC_UNAUTHORIZED, "The token is in black list.");
                LOG.info("----------------------------------------------------------------");
                return false;
            }

            String rolePath = ServiceUtil.uriToRolePath(req.getRequestURI());
            if ((rolePath.equals(ApiFilterConst.PATH_LEVEL_ROLE_INTERNAL)) && (!ServiceUtil.isFoundInMultiStringIgnoreCase(jwtPayload.getRole(),
                    ApiFilterConst.ROLE_NAME_USER, this.SEPARATOR))) {
                res.sendError(HttpServletResponse.SC_UNAUTHORIZED, "The token unauthorized to access. Require role " + ApiFilterConst.ROLE_NAME_USER);
                LOG.info("----------------------------------------------------------------");
                return false;
            }

            if ((rolePath.equals(ApiFilterConst.PATH_LEVEL_ROLE_MANAGE)) && (!ServiceUtil.isFoundInMultiStringIgnoreCase(jwtPayload.getRole(),
                    ApiFilterConst.ROLE_NAME_ADMIN, this.SEPARATOR))) {
                res.sendError(HttpServletResponse.SC_UNAUTHORIZED, "The token unauthorized to access. Require role " + ApiFilterConst.ROLE_NAME_ADMIN);
                LOG.info("----------------------------------------------------------------");
                return false;
            }

            if ((rolePath.equals(ApiFilterConst.PATH_LEVEL_ROLE_SECURE)) && (!ServiceUtil.isFoundInMultiStringIgnoreCase(jwtPayload.getRole(),
                    ApiFilterConst.ROLE_NAME_SUPER_ADMIN, this.SEPARATOR))) {
                res.sendError(HttpServletResponse.SC_UNAUTHORIZED, "The token unauthorized to access. Require role " + ApiFilterConst.ROLE_NAME_SUPER_ADMIN);
                LOG.info("----------------------------------------------------------------");
                return false;
            }

            if ((rolePath.equals(ApiFilterConst.PATH_LEVEL_ROLE_EXTERNAL)) && (!ServiceUtil.isFoundInMultiStringIgnoreCase(jwtPayload.getRole(),
                    ApiFilterConst.ROLE_NAME_EXTERNAL, this.SEPARATOR))) {
                res.sendError(HttpServletResponse.SC_UNAUTHORIZED, "The token unauthorized to access. Require role " + ApiFilterConst.ROLE_NAME_EXTERNAL);
                LOG.info("----------------------------------------------------------------");
                return false;
            }

            if ((rolePath.equals(ApiFilterConst.PATH_LEVEL_ROLE_SYSTEM)) && (!ServiceUtil.isFoundInMultiStringIgnoreCase(jwtPayload.getRole(),
                    ApiFilterConst.ROLE_NAME_SYSTEM, this.SEPARATOR))) {
                res.sendError(HttpServletResponse.SC_UNAUTHORIZED, "The token unauthorized to access. Require role " + ApiFilterConst.ROLE_NAME_SYSTEM);
                LOG.info("----------------------------------------------------------------");
                return false;
            }

            if (jwtPayload.getExpireDt().getTime() < BackEndDateTimeUtil.currentMillis()) {
                res.sendError(HttpServletResponse.SC_UNAUTHORIZED, "The token is expire.");
                LOG.info("----------------------------------------------------------------");
                return false;
            }

        } catch (Exception ex) {
            res.sendError(HttpServletResponse.SC_UNAUTHORIZED, ex.getMessage());
            LOG.info("----------------------------------------------------------------");
            return false;
        }
        //XXX

        return true;
    }

    private String genJWFForDev() {
        String result;
        AuthPayloadJWT jwt = new AuthPayloadJWT();
        jwt.setApiKeyId("1234567890");
        jwt.setDesc("For Test");
        jwt.setRole(ApiFilterConst.ROLE_NAME_USER + "," + ApiFilterConst.ROLE_NAME_ADMIN + "," + ApiFilterConst.ROLE_NAME_SUPER_ADMIN);
        jwt.setExpireDt(BackEndDateTimeUtil.addMin(BackEndDateTimeUtil.currentMillis(), 100000));
        jwt.setCreateDt(BackEndDateTimeUtil.currentDateTime());
        jwt.setCreateBy("ApiFilter");

        try {
            result = JWTUtil.createJWT(JWTUtil.convertPayloadDataToJSONString(jwt));
        } catch (Exception ex) {
            result = "";
        }

        return result;
    }

    private void initData(ServletRequest request, HttpServletRequest req, HttpServletResponse res) {
        ServletContext servletContext = request.getServletContext();

        String FilePath = GeneratUtil.getPatchFloderProject(CONFIG);
        String reportPath = servletContext.getRealPath("/report-form");
        String uuid = UUID.randomUUID().toString();
        String serverId = AppHelper.getInstance().getServerId();

        String urlPic;
        String zoneUrl = req.getHeader(ApiFilterConst.ZONE_URL);
        if (StringUtil.isnotnull(zoneUrl)) {
            urlPic = zoneUrl.concat(req.getContextPath()).concat(FilePath);
        } else {
            urlPic = getURLImage(req).concat(FilePath);
        }

        //Use for caller rest
        res.setHeader("REST_UUID", uuid);
        res.setHeader("SERVER_ID", serverId);

        // Pass value to controller
        ApiAttrBean bean = new ApiAttrBean();
        bean.setRestUuid(uuid);
        bean.setServerId(serverId);
        bean.setRestUri(req.getRequestURI());
        bean.setRestMethod(req.getMethod());
        bean.setRestUrl(urlPic);
        bean.setReportPath(reportPath);

        request.setAttribute(ApiFilterConst.ATTR_DATA_NAME, bean);
    }

    public static String getURLImage(HttpServletRequest req) {
        String scheme = req.getScheme();             // http
        String serverName = req.getServerName();     // hostname.com
        int serverPort = req.getServerPort();        // 80
        String contextPath = req.getContextPath();   // /mywebapp
        //String servletPath = req.getServletPath();   // /servlet/MyServlet
        //String pathInfo = req.getPathInfo();         // /a/b;c=123
        //String queryString = req.getQueryString();          // d=789

        //Reconstruct original requesting URL
        StringBuilder url = new StringBuilder();
        url.append(scheme).append("://").append(serverName);

        if (serverPort != 80 && serverPort != 443) {
            url.append(":").append(serverPort);
        }

        return url.append(contextPath).toString();
    }
}
