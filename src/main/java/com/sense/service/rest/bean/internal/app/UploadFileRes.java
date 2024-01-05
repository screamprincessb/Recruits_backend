package com.sense.service.rest.bean.internal.app;

import com.sense.service.base.BaseResp;
import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class UploadFileRes extends BaseResp {

    private String filename;
    private String filePath;
    private String fileUrl;

    private String filenameThumbnail;
    private String filePathThumbnail;
    private String fileUrlThumbnail;
}
