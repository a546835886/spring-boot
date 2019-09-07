package szr.controller.request;


import com.szr.controller.request.inner.ReqAppHead;
import com.szr.controller.request.inner.ReqLocalHead;
import com.szr.controller.request.inner.ReqSysHead;

public class ESBRequest<B> {

    public ESBRequest() {
    }

    public ESBRequest(ReqSysHead SYS_HEAD, ReqAppHead APP_HEAD, ReqLocalHead LOCAL_HEAD, B BODY) {
        this.SYS_HEAD = SYS_HEAD;
        this.APP_HEAD = APP_HEAD;
        this.LOCAL_HEAD = LOCAL_HEAD;
        this.BODY = BODY;
    }

    private ReqSysHead SYS_HEAD;    //存放各系统通用的关键字段

    private ReqAppHead APP_HEAD;    //存储报文的交易查询信息

    private ReqLocalHead LOCAL_HEAD;  //除全行标准报文头外的特殊字段

    private B BODY;                  //存放请求报文

    public ReqSysHead getSYS_HEAD() {
        return SYS_HEAD;
    }

    public void setSYS_HEAD(ReqSysHead SYS_HEAD) {
        this.SYS_HEAD = SYS_HEAD;
    }

    public ReqAppHead getAPP_HEAD() {
        return APP_HEAD;
    }

    public void setAPP_HEAD(ReqAppHead APP_HEAD) {
        this.APP_HEAD = APP_HEAD;
    }

    public ReqLocalHead getLOCAL_HEAD() {
        return LOCAL_HEAD;
    }

    public void setLOCAL_HEAD(ReqLocalHead LOCAL_HEAD) {
        this.LOCAL_HEAD = LOCAL_HEAD;
    }

    public B getBODY() {
        return BODY;
    }

    public void setBODY(B BODY) {
        this.BODY = BODY;
    }
}
