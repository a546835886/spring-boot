package com.szr.controller.response.inner;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * 结算明细信息
 * @author liuy
 * @time 2019年7月29日 19:55:21
 */
@Setter
@Getter
public class SettleArray {
    private String SETTLE_BRANCH;           //结算分行
    private String SETTLE_CLIENT;           //结算客户号
    private String SETTLE_ACCT_CLASS;       //结算账户分类
    private String SETTLE_METHOD;           //结算方式
    private String PAY_REC_IND;             //收付款标志
    private String AMT_TYPE;                //金额类型
    private String SETTLE_ACCT_INTERNAL_KEY;//结算账户主键
    private String SETTLE_BASE_ACCT_NO;     //结算账号
    private String SETTLE_PROD_TYPE;        //结算账户产品类型
    private String SETTLE_ACCT_CCY;         //结算账户币种
    private String SETTLE_ACCT_SEQ_NO;      //结算账户序号
    private String SETTLE_CCY;              //结算币种
    private BigDecimal SETTLE_AMT;          //结算金额
    private BigDecimal SETTLE_XRATE;        //结算汇率
    private String SETTLE_XRATE_ID;         //结算汇兑方式
    private String AUTO_BLOCKING;           //自动锁定标记
    private String SORT_PRIORITY;           //排序优先级
    private BigDecimal SETTLE_WEIGHT;       //结算权重
    private String TRUSTED_PAY_NO;          //受托支付编号
    private String SETTLE_NO;               //结算编号
    private String SETTLE_BANK_FLAG;        //资金转移账户银行标识
    private String SETTLE_ACCT_NAME;        //结算账户名称
    private String SETTLE_BANK_NAME;        //结算行名称
    private String SETTLE_MOBILE_PHONE;     //结算账户手机号
}
