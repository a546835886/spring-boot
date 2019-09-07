package com.szr.controller.response.inner;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * 子账号信息数组
 * @author liuy
 * @time 2019年7月30日 19:55:21
 */
@Setter
@Getter
public class Sub {

    private String INTERNAL_KEY;            //账户主键
    private String CAPITAL_SOURCE资金;       //来源
    private String ACCT_STATUS_UPD_DATE;    //账户状态变更日期
    private String ACCOUNTING_STATUS;       //账户核算状态
    private String ACCOUNTING_STATUS_PREV;  //前次核算状态
    private String ACCOUNT_STATUS_UPD_DATE; //核算状态变更日期
    private String ACCT_STATUS_DESC;        //账户状态描述
    private String BRANCH;                  //机构
    private String CCY;                     //币种
    private String CLIENT_NO;               //客户号
    private String CLIENT_TYPE;             //客户类型
    private String CLIENT_SHORT;           //客户简称
    private String BASE_ACCT_NO;            //账号\卡号
    private String CLIENT_NAME;             //客户英文名称
    private String CH_CLIENT_NAME;          //客户中文名称
    private String DOCUMENT_TYPE;           //证件类型
    private String DOCUMENT_TYPE_DESC;      //证件类型描述
    private String ISS_COUNTRY;             //签发国家
    private String ACCT_EXEC;               //客户经理
    private String ACCT_EXEC_NAME;          //客户经理名称
    private String ALT_ACCT_NAME;           //账户备用名称
    private String CATEGORY_TYPE;           //分类类别
    private String PROD_TYPE;               //产品类型
    private String INTERNAL_IND;            //内部客户表示    Y;N
    private String CLIENT_IND_DESC;         //客户分类描述
    private String OWNERSHIP_TYPE;          //归属种类  AS-多客户联名；SG-独立账户；SU-继承账户
    private String OWNERSHOP_TYPE_DESC;     //账户归属种类描述
    private String PROFIT_CENTER;           //利润中心
    private String USER_ID;                 //柜员标识
    private String LAST_CHANGE_DATE;        //最后更改日期
    private String LAST_CHANGE_USER_ID;     //最后修改柜员
    private String APPROVAL_STATUS;         //复核状态  A:已批准；E-已录入
    private String APPROVAL_STATUS_DESC;    //账户复核状态描述
    private String PROD_TYPE_DESC;          //产品类型描述
    private String TERMINAL_ID;             //终端编号
    private String VERIFICATION_USER_ID;    //核实柜员
    private String CLIENT_STATUS;           //客户状态
    private String ADRESS;                  //地址
    private String CLASS_LEVEL;             //客户等级
    private String ACCT_TYPE;               //账户类型
    private String ACCT_TYPE_DESC;          //账户类型描述
    private String ACCT_DESC;               //账户描述
    private String CCY_DESC;                //币种描述
    private String OSA_FLAG;                //离岸标记  I-本地；O-离岸
    private String ACCT_NAME;               //账户名称
    private String REGION_FLAG;             //区域内外标识    I;O
    private String ACCT_NATURE;             //账户属性
    private String ACCT_NATURE_DESC;        //账户属性描述
    private String OPEN_TRAN_DATE;          //开户交易日期
    private String MULTI_BAL_TYPE;          //多余额账户标识
    private String LEAD_ACCT_FLAG;          //是否顶级账户
    private String TERM;                    //期限
    private String TERM_TYPE;               //期限类型
    private String ALL_DEP_IND;             //通存标志
    private String HOME_BRANCH;             //账户归属机构
    private String APPLY_BRANCH;            //预约机构
    private String COUNTRY_LOC;             //居住国
    private BigDecimal BALANCE;             //余额
    private String ACCT_SEQ_NO;             //账户序号
    private String DOC_TYPE;                //凭证类型
    private String VOUCHER_NO;              //凭证号码
    private String PREFIX;                  //前缀
    private String MATURITY_DATE;           //到期日
    private BigDecimal  ACTUAL_BAL;         //实际余额
    private String  ACCT_OPEN_DATE;         //账户开户日期
    private BigDecimal CA_AMOUNT;           //钞余额
    private BigDecimal TT_AMOUNT;           //当日汇余额
    private String AMT_TYPE;                //金额类型
    private String FIXED_CALL;              //定期账户细类
    private String IS_INDIVIDUAL;           //是否对私客户
    private String REASON_CODE;             //账户用途
    private String SOURCE_MODULE;           //源模块
    private String AUTO_RENEW_ROLLOVER;     //自动转存标志
    private String RENWE_NO;                //自动本金转存次数
    private String ACCT_STOP_PAY;           //账户余额止付标志
    private String ACCT_STATUS;             //账户状态
    private String ROLLOVER_NO;             //转存的次数
    private String ADDTL_PRINCIPAL;         //是否允许增加本金
    private String PARTIAL_RENEW_ROLL;      //是否部分允许本金转存
    private String ACCT_CLASS;              //账户类别
    private BigDecimal DAY_AVG_AMT;         //日平均余额
    private BigDecimal MON_AVG_AMT;         //月平均余额
    private BigDecimal SEASON_AVG_AMT;      //季平均余额
    private BigDecimal HALFYEAR_AVG_AMT;    //半年平均余额
    private BigDecimal YEAR_AVG_AMT;        //年平均余额
    private String GL_TYPE;                 //总长类型
    private String ACCT_STATUS_PREV;        //前次账户状态
    private String BAL_DIRECT_TYPE;         //余额方向
    private String GL_CODE;                 //科目代码
    private String CONTRA_ACCT_NO;          //对手账号
}
