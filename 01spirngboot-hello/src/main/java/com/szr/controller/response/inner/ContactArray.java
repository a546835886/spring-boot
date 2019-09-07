package com.szr.controller.response.inner;

import lombok.Getter;
import lombok.Setter;

/**
 * 账户联系人信息数组
 * @author liuy
 * @time 2019年7月29日 19:55:21
 */
@Setter
@Getter
public class ContactArray {
    private String LINKMAN_TYPE;    //联系人类型
    private String LINKMAN_NAME;    //联系人姓名
    private String DOCUMENT_TYPE;   //证件类型
    private String DOCUMENT_ID;     //证件号码
    private String PHONE_NO1;       //联系人电话1
    private String PHONE_NO2;       //联系人电话2
}
