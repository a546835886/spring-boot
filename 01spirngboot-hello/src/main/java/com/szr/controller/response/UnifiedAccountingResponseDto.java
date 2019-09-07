package com.szr.controller.response;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;

/**
 * 统一记账接口响应实体类
 * @author liuy
 * @time 2019年7月16日 20:19:31
 */
@Setter
@Getter
public class UnifiedAccountingResponseDto {

    private String REFERENCE;           //交易参考号
    @Valid
    private List<Result> RESULT_ARRAY;  //结果数组

    @Setter
    @Getter
    public class Result{
        private String BASE_ACCT_NO;    //账号
        private String ACCT_CCY;        //币种
        private String PROD_TYPE;       //产品类型
        private String ACCT_SEQ_NO;     //账户序号
        private String BRANCH;          //机构
        private String TRAN_TYPE;       //交易类型
        private BigDecimal TRAN_AMT;    //交易金额
        private String REFERENCE;       //交易参考号
    }
}
