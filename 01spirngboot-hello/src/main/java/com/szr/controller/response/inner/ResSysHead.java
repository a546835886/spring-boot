package com.szr.controller.response.inner;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import java.util.List;

public class ResSysHead {

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
    private String TRAN_DATE;           //交易日期 服务请求系统的日期 格式为YYYYMMDD

    @NotBlank(message = "交易时间不能为空！")
    @Length(max = 6, message = "交易时间最大长度不能超过6！")
    private String TRAN_TIMESTAMP;      //交易时间 格式为HHMMSS

    @NotBlank(message = "运行日期不能为空！")
    @Length(max = 8, message = "运行日期最大长度不能超过8！")
    private String RUN_DATE;            //运行日期 业务系统运行日期 格式为YYYYMMDD

    @NotBlank(message = "全局流水号不能为空！")
    @Length(max = 24, message = "全局流水号最大长度不能超过24！")
    private String GLBL_SEQ_NO;         //全局流水号

    @NotBlank(message = "系统编号不能为空！")
    @Length(max = 4, message = "系统编号最大长度不能超过4！")
    private String PRVD_SYSTEM_ID;      //提供方系统编号

    @NotBlank(message = "系统流水号不能为空！")
    @Length(max = 50, message = "系统流水号最大长度不能超过50！")
    private String PRVD_SYSTEM_SEQ_NO;  //提供方系统流水号

    @Length(max = 512, message = "文件路径最大长度不能超过512！")
    private String FILE_PATH;           //文件路径

    @Length(max = 128, message = "MAC值最大长度不能超过128！")
    private String MAC_VALUE;           //MAC值

    @NotBlank(message = "返回状态不能为空！")
    @Length(max = 1, message = "返回状态最大长度不能超过1！")
    private String RET_STATUS;          //返回状态 S－系统处理成功 F－系统处理失败

    @NotBlank(message = "返回信息不能为空！")
    List<Ret> RET_ARRAY;      //返回信息列表

    @Length(max = 6, message = "源节点编号最大长度不能超过6！")
    private String SOURCE_BRANCH_NO;    //源节点编号

    @Length(max = 6, message = "目标节点编号最大长度不能超过6！")
    private String DEST_BRANCH_NO;      //目标节点编号

    @Length(max = 50, message = "目标节点编号最大长度不能超过50！")
    private String CITATION_NO;         //扎帐流水号

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

    public String getRUN_DATE() {
        return RUN_DATE;
    }

    public void setRUN_DATE(String RUN_DATE) {
        this.RUN_DATE = RUN_DATE;
    }

    public String getGLBL_SEQ_NO() {
        return GLBL_SEQ_NO;
    }

    public void setGLBL_SEQ_NO(String GLBL_SEQ_NO) {
        this.GLBL_SEQ_NO = GLBL_SEQ_NO;
    }

    public String getPRVD_SYSTEM_ID() {
        return PRVD_SYSTEM_ID;
    }

    public void setPRVD_SYSTEM_ID(String PRVD_SYSTEM_ID) {
        this.PRVD_SYSTEM_ID = PRVD_SYSTEM_ID;
    }

    public String getPRVD_SYSTEM_SEQ_NO() {
        return PRVD_SYSTEM_SEQ_NO;
    }

    public void setPRVD_SYSTEM_SEQ_NO(String PRVD_SYSTEM_SEQ_NO) {
        this.PRVD_SYSTEM_SEQ_NO = PRVD_SYSTEM_SEQ_NO;
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

    public String getRET_STATUS() {
        return RET_STATUS;
    }

    public void setRET_STATUS(String RET_STATUS) {
        this.RET_STATUS = RET_STATUS;
    }

    public List<Ret> getRET_ARRAY() {
        return RET_ARRAY;
    }

    public void setRET_ARRAY(List<Ret> RET_ARRAY) {
        this.RET_ARRAY = RET_ARRAY;
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

    public String getCITATION_NO() {
        return CITATION_NO;
    }

    public void setCITATION_NO(String CITATION_NO) {
        this.CITATION_NO = CITATION_NO;
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

    public class Ret {

        @NotBlank(message = "返回代码不能为空！")
        @Length(max = 30, message = "返回代码最大长度不能超过30！")
        private String RET_CODE;    //返回代码

        @NotBlank(message = "返回信息不能为空！")
        @Length(max = 512, message = "返回信息最大长度不能超过512！")
        private String RET_MSG;     //返回信息

        public String getRET_CODE() {
            return RET_CODE;
        }

        public void setRET_CODE(String RET_CODE) {
            this.RET_CODE = RET_CODE;
        }

        public String getRET_MSG() {
            return RET_MSG;
        }

        public void setRET_MSG(String RET_MSG) {
            this.RET_MSG = RET_MSG;
        }
    }
}
