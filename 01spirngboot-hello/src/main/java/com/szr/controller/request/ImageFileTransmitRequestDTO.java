package com.szr.controller.request;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 影像文件传输 request dto
 * @author liuy
 * @since 2019年7月5日 09:47:12
 */
public class ImageFileTransmitRequestDTO {

    private String upload_date;     //上传日期

    private String app_serial_no;       //申请流水号,同授信

    private String file_list;       //文件列表，各文件名称以“|”分割

    public String getUpload_date() {
        return upload_date;
    }

    public void setUpload_date(String upload_date) {
        this.upload_date = upload_date;
    }

    public String getApp_serial_no() {
        return app_serial_no;
    }

    public void setApp_serial_no(String app_serial_no) {
        this.app_serial_no = app_serial_no;
    }

    public String getFile_list() {
        return file_list;
    }

    public void setFile_list(String file_list) {
        this.file_list = file_list;
    }
}
