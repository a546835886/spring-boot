package com.szr.controller.response;


import com.szr.controller.response.inner.ResAppHead;
import com.szr.controller.response.inner.ResLocalHead;
import com.szr.controller.response.inner.ResSysHead;

public class ESBResponse<B> {

    public ESBResponse() {
    }

    public ESBResponse(ResSysHead SYS_HEAD, ResAppHead APP_HEAD, ResLocalHead LOCAL_HEAD, B BODY) {
        this.SYS_HEAD = SYS_HEAD;
        this.APP_HEAD = APP_HEAD;
        this.LOCAL_HEAD = LOCAL_HEAD;
        this.BODY = BODY;
    }

    private ResSysHead SYS_HEAD;        //存放各系统通用的关键字段

    private ResAppHead APP_HEAD;        //存储报文的交易查询信息

    private ResLocalHead LOCAL_HEAD;    //除全行标准报文头外的特殊字段

    private B BODY;                     //存放响应报文

    public ResSysHead getSYS_HEAD() {
        return SYS_HEAD;
    }

    public void setSYS_HEAD(ResSysHead SYS_HEAD) {
        this.SYS_HEAD = SYS_HEAD;
    }

    public ResAppHead getAPP_HEAD() {
        return APP_HEAD;
    }

    public void setAPP_HEAD(ResAppHead APP_HEAD) {
        this.APP_HEAD = APP_HEAD;
    }

    public ResLocalHead getLOCAL_HEAD() {
        return LOCAL_HEAD;
    }

    public void setLOCAL_HEAD(ResLocalHead LOCAL_HEAD) {
        this.LOCAL_HEAD = LOCAL_HEAD;
    }

    public B getBODY() {
        return BODY;
    }

    public void setBODY(B BODY) {
        this.BODY = BODY;
    }
}
