package com.szr.controller.response;


import com.szr.controller.response.inner.ContactArray;
import com.szr.controller.response.inner.SettleArray;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;

/**
 * 账户详细信息查询响应实体类
 * @author liuy
 * @time 2019年7月16日 20:19:31
 */
@Setter
@Getter
public class QueryAccountInfoResponseDto {

    private String INTERNAL_KEY;            //账户主键
    private String BASE_ACCT_NO;            //账号/卡号
    private String PROD_TYPE;               //产品类型
    private String PROD_TYPE_DESC;          //产品类型描述
    private String ACCT_NAME;               //账户名称
    private String ACCT_OPEN_DATE;          //开户日期
    private String ACCT_STATUS;             //账户状态 A活动C关闭D睡眠H批量开户待激活I预开户N新建O转营业外P逾期S久悬户
    private String ACCT_STATUS_PREV;        //前次账户状态
    private String ACCT_STATUS_UPD_DATE;    //账户状态变更日期
    private String ACCOUNTING_STATUS;       //账户核算状态
    private String ACCOUNTING_STATUS_PREV;  //前次核算状态
    private String ACCOUNT_STATUS_UPD_DATE; //核算状态变更日期
    private String ACCT_STATUS_DESC;        //账户状态描述
    private String BRANCH;                  //机构
    private String CCY;                     //币种
    private String CLIENT_NO;               //客户号
    private String CLIENT_TYPE;             //客户类型
    private String CLIENT_SHORT;            //客户简称
    private String CLIENT_NAME; 	        //客户英文名称
    private String CH_CLIENT_NAME; 	        //客户中文名称
    private String DOCUMENT_TYPE; 	        //证件类型
    private String DOCUMENT_TYPE_DESC;     //证件类型描述
    private String DOCUMENT_ID; 	        //证件号码
    private String ACCT_EXEC; 	            //客户经理
    private String ACCT_EXEC_NAME; 	        //客户经理名称
    private String ALT_ACCT_NAME; 	        //账户英文名称
    private String CATEGORY_TYPE; 	        //分类类别
    private String INTERNAL_IND; 	        //内部客户标志:Y-是银行内部客户；N-非银行内部客户
    private String CLIENT_IND_DESC; 	    //客户分类描述
    private String OWNERSHIP_TYPE; 	        //归属种类
    private String OWNERSHIP_TYPE_DESC;    //账户归属种类描述
    private String PROFIT_CENTRE; 	        //利润中心
    private String USER_ID; 	            //交易柜员
    private String LAST_CHANGE_DATE; 	    //最后更改日期
    private String LAST_CHANGE_USER_ID; 	//最后修改柜员
    private String APPROVAL_STATUS; 	    //复核状态 A:已批准；E:以录入
    private String APPROVAL_STATUS_DESC; 	//账户复核状态描述
    private String TERMINAL_ID; 	        //终端编号
    private String APPR_USER_ID; 	        //复核柜员
    private String CLIENT_STATUS; 	        //客户状态
    private String ADDRESS; 	            //地址
    private String CLASS_LEVEL; 	        //客户等级 :1-正常；2-关注；3-次级；4-可疑；5-损失
    private String ACCT_TYPE; 	            //账户类型
    private String ACCT_TYPE_DESC; 	        //账户类型描述
    private String ACCT_DESC; 	            //账户描述
    private BigDecimal BALANCE; 	        //余额
    private String CCY_DESC; 	            //币种描述
    private String OSA_FLAG; 	            //离岸标记 I:inland(本地)；O:offshore(离岸)
    private String REGION_FLAG; 	        //区域内外标识
    private String ACCT_NATURE; 	        //账户属性 B：基本户；C：一般户；S：专用户；T：临时户
    private String ACCT_NATURE_DESC; 	    //账户属性描述
    private String OPEN_TRAN_DATE; 	        //开户交易日期
    private String MULTI_BAL_TYPE; 	        //多余额账户标识 Y:是；N:否
    private String LEAD_ACCT_FLAG; 	        //是否顶层账户 Y:是；N:否
    private String TERM; 	                //期限
    private String TERM_TYPE; 	            //期限类型 D:日；M:月；Y:年
    private String ALL_DEP_IND; 	        //通存标志 取值范围:Y,N
    private String ISS_COUNTRY; 	        //签发国家
    private String ALL_DRA_IND; 	        //通兑标志 取值范围:Y,N
    private String HOME_BRANCH; 	        //账户归属机构
    private String REASON_CODE; 	        //账户用途
    private BigDecimal REAL_RATE; 	        //执行利率
    private String DAY_NUM; 	            //每期天数
    private String MATURITY_DATE; 	        //到期日
    private BigDecimal ACTUAL_BAL; 	        //实际余额
    private String DOC_TYPE; 	            //凭证类型
    private String VOUCHER_NO; 	            //凭证号码
    private String WITHDRAWAL_TYPE; 	    //支取方式
    private String PREFIX; 	                //前缀
    private BigDecimal ACTUAL_RATE; 	    //行内利率
    private BigDecimal FLOAT_RATE; 	        //浮动利率
    private String INT_TYPE; 	            //利率类型
    private BigDecimal TAX_POSTED; 	        //利息税累计金额
    private BigDecimal TAX_ACCRUED; 	    //利息税累计计提金额
    private BigDecimal INT_POSTED; 	        //结息利息金额（累计金额）
    private BigDecimal INT_ACCRUED; 	    //累计计提利息 结息周期内累计计提金额
    private BigDecimal INT_ADJ; 	        //利息调整(累计)
    private BigDecimal NET_INTEREST_AMT; 	//净利息
    private String FIXED_CALL; 	            //定期账户细类 A协议存款B定期一本通C通知存款D定活两便E教育储蓄F整存争取L零存整取
    private String ACCT_SEQ_NO; 	        //账户序号
    private String APPLY_BRANCH; 	        //预约机构
    private String AUTO_RENEW_ROLLOVER; 	//自动转存标志
    private String INT_CLASS; 	            //利息分类
    private String ACCT_STOP_PAY; 	        //账户余额止付标志
    private String RES_FLAG; 	            //冻结标志
    private String IS_INDIVIDUAL; 	        //是否对私客户 Y:对私客户N:对公客户
    @Valid
    private List<SettleArray> SETTLE_ARRAY;       //结算明细信息
    @Valid
    private List<ContactArray> CONTACT_ARRAY;     //账户联系人信息数组
    private String ACCT_DUE_DATE;           //账户到期日期
    private String ACCT_CLASS;              //账户类别 1：一类账户2：二类账户3：三类账户
    private String GL_TYPE;                 //总账类型
    private String AUTO_DEP;                //是否自动续存 Y:是N:否
    private String PARTIAL_RENEW_ROLL;      //是否部分允许本金转存 Y:是 N:否
    private BigDecimal AMOUNT;              //金额值
    private String DEP_BASE_ACCT_NO;        //存入账号
    private String DOC_CLASS;               //凭证种类
    private String ACCT_PROOF_STATUS;       //账户验证状态 00：验证通过、01：未验证、02：验证不通过
    private String CARD_STATUS;             //卡状态 1-申请2-待发3-活动4-注销5-CVN锁定6-单日密码锁定7-密码错误次数累计达到上限锁定8-密码失效
    private String APP_FLAG;                //主附卡标志 是否附属卡Y-是N-否
    private String FTA_FLAG;                //自贸区标识
    private String JUDICIAL_FREEZE_FLAG;    //司法冻结标识
    private String  DEAL_DAY;               //处理日
    private String NEXT_DEAL_DATE;          //下一处理日期
    private String AUP_BASE_ACCT_NO;        //转出账号
    private String AMT_TYPE;                //金额类型 PRI-本金BAL-余额OSL-未到期本金PD-逾期本金PF-净本金DDA-发放金额INT-利息ALL-本加息FEE-费用（余额类型）
    private String LOST_STATUS;             //挂失状态 0-正常1-书面挂失2-口头挂失
    private BigDecimal PREV_DAY_BALANCE;    //上日余额
    private String BAL_TYPE;                //余额类型
    private String CA_TT_FLAG;              //钞汇标志
    private String FACE_FLAG;               //面签标志
    private String ANNUAL_DATE;             //年检日期
    private BigDecimal ACTUAL_BAL_PRE;      //前付息账户可用余额
    private String NEXT_CYCLE_DATE;         //下一结息日
    private String CR_DR_MAINT_IND;         //借贷标志 C:贷方，D:借
    private String HANG_WRITE_OFF_FLAG;     //是否挂销账
    private String  WRITE_OFF_WAY;          //销账方式
    private String  HANG_TERM;              //挂账期限
    private String IS_STOP_PAY;             //是否止付标志
    private String PAY_PWD_IND;             //是否绑定支付密码器
    private BigDecimal FIN_XTF_BAL;         //薪添富余额
    private String  YHT_PROD_TYPE;          //一户通主账户标志


}
