package com.sense.service.custom.filter;
import com.sense.service.util.secure.BlackListDataBean;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class ApiFilteMemData {

    private static ApiFilteMemData instance;

    //private List<ApiAuthBean> apiAuthList;
    private List<BlackListDataBean> apiKeyIdBlackList;

    private ApiFilteMemData() {
        //For Test
        loadDataTest();
    }

    private void loadDataTest() {
        apiKeyIdBlackList = Arrays.asList(
                new BlackListDataBean("key-0", "Y"),
                //new BlackListDataBean("key", "N"),
                new BlackListDataBean("key-99", "Y")
        );
    }

    public static ApiFilteMemData instance() {
        if (instance == null) {
            instance = new ApiFilteMemData();
        }

        return instance;
    }

    public boolean isInBacklList(String chkApiKeyId) {
        return apiKeyIdBlackList.stream()
                .filter(x -> x.getApiKeyId().equals(chkApiKeyId))
                .findFirst().isPresent();
    }

//    public Optional<ApiAuthBean> xfindData(String chkApiKey) {
//        return apiAuthList.stream()
//                .filter(x -> x.getApiKey().equals(chkApiKey))
//                .findFirst();
//    }
}
