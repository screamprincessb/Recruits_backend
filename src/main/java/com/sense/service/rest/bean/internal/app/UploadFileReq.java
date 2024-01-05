package com.sense.service.rest.bean.internal.app;

import java.io.Serializable;
import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class UploadFileReq implements Serializable {

    private UploadFileData data; 

    @Data
    public class UploadFileData {

        private String fileType;
        private String fileBase64;
        private Boolean isTempFile;
        private String branchCode;
        private String year;
        private String jobCode;
    }
}
