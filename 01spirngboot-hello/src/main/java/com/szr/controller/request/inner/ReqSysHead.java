package com.szr.controller.request.inner;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

public class ReqSysHead{

    @NotBlank(message = "服务标识不能为空！")
    @Length(max = 9, message = "服务标识最大长度不能超过9！")
    private String SERVICE_ID;          //服务标识

    @NotBlank(message = "场景标识不能为空！")
    @Length(max = 2, message = "场景标识最大长度不能超过2！")
    private String SCENE_ID;            //场景标识

    @NotBlank(message = "渠道类型不能为空！")
    @Length(max = 10, message = "渠道类型最大长度不能超过10！")
    private String CHANNEL_TYPE;        //渠道类型

    @NotBlank(message = "交易日期不能为空！")
    @Length(max = 8, message = "交易日期最大长度不能超过8！")
    private String TRAN_DATE;           //交易日期 格式为YYYYMMDD

    @NotBlank(message = "交易时间不能为空！")
    @Length(max = 6, message = "交易时间最大长度不能超过6！")
    private String TRAN_TIMESTAMP;      //交易时间 格式为HHMMSS

    @NotBlank(message = "全局流水号不能为空！")
    @Length(max = 24, message = "全局流水号最大长度不能超过24！")
    private String GLBL_SEQ_NO;         //全局流水号

    @NotBlank(message = "用户语言不能为空！")
    @Length(max = 20, message = "用户语言最大长度不能超过20！")
    private String USER_LANG = "CHINESE";    //用户语言 取值:CHINESE－中文(默认)ENGLISH－英文

    @NotBlank(message = "交易模式不能为空！")
    @Length(max = 10, message = "交易模式最大长度不能超过10！")
    private String TRAN_MODE;           //交易模式 ONLINE：联机类报文 ASYNC：通知类报文

    @NotBlank(message = "消费方系统编号不能为空！")
    @Length(max = 4, message = "消费方系统编号最大长度不能超过4！")
    private String CONSUMER_SYSTEM_ID;  //消费方系统编号

    @NotBlank(message = "消费方系统流水号不能为空！")
    @Length(max = 50, message = "消费方系统流水号最大长度不能超过50！")
    private String CONSUMER_SYSTEM_SEQ_NO;  //消费方系统流水号

    @Length(max = 20, message = "法人代码最大长度不能超过20！")
    private String LEGAL_CD;            //法人代码

    @NotBlank(message = "机构标识不能为空！")
    @Length(max = 5, message = "机构标识最大长度不能超过5！")
    private String BRANCH_ID;           //机构标识

    @NotBlank(message = "柜员标识不能为空！")
    @Length(max = 4, message = "柜员标识最大长度不能超过4！")
    private String USER_ID;             //柜员标识

    @Length(max = 512, message = "文件路径最大长度不能超过512！")
    private String FILE_PATH;           //文件路径

    @Length(max = 128, message = "MAC值最大长度不能超过128！")
    private String MAC_VALUE;           //MAC值

    @Length(max = 8, message = "交易屏幕标识最大长度不能超过8！")
    private String PROGRAM_ID;          //交易屏幕标识

    @Length(max = 4, message = "授权柜员标识最大长度不能超过4！")
    private String AUTH_USER_ID;        //授权柜员标识

    @Length(max = 1, message = "授权标志最大长度不能超过1！")
    private String AUTH_FLAG;           //授权标志

    @Length(max = 4, message = "交易录入柜员标识最大长度不能超过4！")
    private String APPR_USER_ID;        //交易录入柜员标识

    @Length(max = 1, message = "复核标志最大长度不能超过1！")
    private String APPR_FLAG;           //复核标志

    @Length(max = 6, message = "源节点编号最大长度不能超过6！")
    private String SOURCE_BRANCH_NO;    //源节点编号

    @Length(max = 6, message = "目标节点编号最大长度不能超过6！")
    private String DEST_BRANCH_NO;      //目标节点编号

    @Length(max = 30, message = "终端标识最大长度不能超过30！")
    private String WS_ID;               //终端标识

    @Length(max = 32, message = "系统保留标志串最大长度不能超过32！")
    private String SYSTEM_KEEP_FLAG_STR;//系统保留标志串

    @Length(max = 1024, message = "系统保留字符串最大长度不能超过1024！")
    private String SYSTEM_KEEP_ST;      //系统保留字符串

    public String getSERVICE_ID() {
        return SERVICE_ID;
    }

    public void setSERVICE_ID(String SERVICE_ID) {
        this.SERVICE_ID = SERVICE_ID;
    }

    public String getSCENE_ID() {
        return SCENE_ID;
    }

    public void setSCENE_ID(String SCENE_ID) {
        this.SCENE_ID = SCENE_ID;
    }

    public String getCHANNEL_TYPE() {
        return CHANNEL_TYPE;
    }

    public void setCHANNEL_TYPE(String CHANNEL_TYPE) {
        this.CHANNEL_TYPE = CHANNEL_TYPE;
    }

    public String getTRAN_DATE() {
        return TRAN_DATE;
    }

    public void setTRAN_DATE(String TRAN_DATE) {
        this.TRAN_DATE = TRAN_DATE;
    }

    public String getTRAN_TIMESTAMP() {
        return TRAN_TIMESTAMP;
    }

    public void setTRAN_TIMESTAMP(String TRAN_TIMESTAMP) {
        this.TRAN_TIMESTAMP = TRAN_TIMESTAMP;
    }

    public String getGLBL_SEQ_NO() {
        return GLBL_SEQ_NO;
    }

    public void setGLBL_SEQ_NO(String GLBL_SEQ_NO) {
        this.GLBL_SEQ_NO = GLBL_SEQ_NO;
    }

    public String getUSER_LANG() {
        return USER_LANG;
    }

    public void setUSER_LANG(String USER_LANG) {
        this.USER_LANG = USER_LANG;
    }

    public String getTRAN_MODE() {
        return TRAN_MODE;
    }

    public void setTRAN_MODE(String TRAN_MODE) {
        this.TRAN_MODE = TRAN_MODE;
    }

    public String getCONSUMER_SYSTEM_ID() {
        return CONSUMER_SYSTEM_ID;
    }

    public void setCONSUMER_SYSTEM_ID(String CONSUMER_SYSTEM_ID) {
        this.CONSUMER_SYSTEM_ID = CONSUMER_SYSTEM_ID;
    }

    public String getCONSUMER_SYSTEM_SEQ_NO() {
        return CONSUMER_SYSTEM_SEQ_NO;
    }

    public void setCONSUMER_SYSTEM_SEQ_NO(String CONSUMER_SYSTEM_SEQ_NO) {
        this.CONSUMER_SYSTEM_SEQ_NO = CONSUMER_SYSTEM_SEQ_NO;
    }

    public String getLEGAL_CD() {
        return LEGAL_CD;
    }

    public void setLEGAL_CD(String LEGAL_CD) {
        this.LEGAL_CD = LEGAL_CD;
    }

    public String getBRANCH_ID() {
        return BRANCH_ID;
    }

    public void setBRANCH_ID(String BRANCH_ID) {
        this.BRANCH_ID = BRANCH_ID;
    }

    public String getUSER_ID() {
        return USER_ID;
    }

    public void setUSER_ID(String USER_ID) {
        this.USER_ID = USER_ID;
    }

    public String getFILE_PATH() {
        return FILE_PATH;
    }

    public void setFILE_PATH(String FILE_PATH) {
        this.FILE_PATH = FILE_PATH;
    }

    public String getMAC_VALUE() {
        return MAC_VALUE;
    }

    public void setMAC_VALUE(String MAC_VALUE) {
        this.MAC_VALUE = MAC_VALUE;
    }

    public String getPROGRAM_ID() {
        return PROGRAM_ID;
    }

    public void setPROGRAM_ID(String PROGRAM_ID) {
        this.PROGRAM_ID = PROGRAM_ID;
    }

    public String getAUTH_USER_ID() {
        return AUTH_USER_ID;
    }

    public void setAUTH_USER_ID(String AUTH_USER_ID) {
        this.AUTH_USER_ID = AUTH_USER_ID;
    }

    public String getAUTH_FLAG() {
        return AUTH_FLAG;
    }

    public void setAUTH_FLAG(String AUTH_FLAG) {
        this.AUTH_FLAG = AUTH_FLAG;
    }

    public String getAPPR_USER_ID() {
        return APPR_USER_ID;
    }

    public void setAPPR_USER_ID(String APPR_USER_ID) {
        this.APPR_USER_ID = APPR_USER_ID;
    }

    public String getAPPR_FLAG() {
        return APPR_FLAG;
    }

    public void setAPPR_FLAG(String APPR_FLAG) {
        this.APPR_FLAG = APPR_FLAG;
    }

    public String getSOURCE_BRANCH_NO() {
        return SOURCE_BRANCH_NO;
    }

    public void setSOURCE_BRANCH_NO(String SOURCE_BRANCH_NO) {
        this.SOURCE_BRANCH_NO = SOURCE_BRANCH_NO;
    }

    public String getDEST_BRANCH_NO() {
        return DEST_BRANCH_NO;
    }

    public void setDEST_BRANCH_NO(String DEST_BRANCH_NO) {
        this.DEST_BRANCH_NO = DEST_BRANCH_NO;
    }

    public String getWS_ID() {
        return WS_ID;
    }

    public void setWS_ID(String WS_ID) {
        this.WS_ID = WS_ID;
    }

    public String getSYSTEM_KEEP_FLAG_STR() {
        return SYSTEM_KEEP_FLAG_STR;
    }

    public void setSYSTEM_KEEP_FLAG_STR(String SYSTEM_KEEP_FLAG_STR) {
        this.SYSTEM_KEEP_FLAG_STR = SYSTEM_KEEP_FLAG_STR;
    }

    public String getSYSTEM_KEEP_ST() {
        return SYSTEM_KEEP_ST;
    }

    public void setSYSTEM_KEEP_ST(String SYSTEM_KEEP_ST) {
        this.SYSTEM_KEEP_ST = SYSTEM_KEEP_ST;
    }
}
