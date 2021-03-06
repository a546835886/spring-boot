package com.szr.controller.response.inner;

import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.validator.constraints.Length;

public class ResAppHead {

    @Length(max = 1, message = "PGUP_OR_PGDN最大长度不能超过1！")
    private String PGUP_OR_PGDN;            //上翻/下翻标志 原值返回


    @Length(max = 3, message = "CURRENT_PG_TOTAL_NUM最大长度不能超过3！")
    private String CURRENT_PG_TOTAL_NUM;    //本页记录总数 原值返回


    @Length(max = 12, message = "CURRENT_NUM最大长度不能超过12！")
    private String CURRENT_NUM;             //当前记录号 原值返回



    @Length(max = 12, message = "CURRENT_NUM最大长度不能超过12！")
    private String TOTAL_ROWS;              //总笔数


    @Length(max = 1, message = "TOTAL_FLAG最大长度不能超过1！")
    private String TOTAL_FLAG;              //汇总标志 原值返回

    @JSONField(name = "PGUP_OR_PGDN")
    public String getPGUP_OR_PGDN() {
        return PGUP_OR_PGDN;
    }

    public void setPGUP_OR_PGDN(String PGUP_OR_PGDN) {
        this.PGUP_OR_PGDN = PGUP_OR_PGDN;
    }

    @JSONField(name = "CURRENT_PG_TOTAL_NUM")
    public String getCURRENT_PG_TOTAL_NUM() {
        return CURRENT_PG_TOTAL_NUM;
    }

    public void setCURRENT_PG_TOTAL_NUM(String CURRENT_PG_TOTAL_NUM) {
        this.CURRENT_PG_TOTAL_NUM = CURRENT_PG_TOTAL_NUM;
    }

    @JSONField(name = "CURRENT_NUM")
    public String getCURRENT_NUM() {
        return CURRENT_NUM;
    }

    public void setCURRENT_NUM(String CURRENT_NUM) {
        this.CURRENT_NUM = CURRENT_NUM;
    }

    @JSONField(name = "TOTAL_ROWS")
    public String getTOTAL_ROWS() {
        return TOTAL_ROWS;
    }

    public void setTOTAL_ROWS(String TOTAL_ROWS) {
        this.TOTAL_ROWS = TOTAL_ROWS;
    }

    @JSONField(name = "TOTAL_FLAG")
    public String getTOTAL_FLAG() {
        return TOTAL_FLAG;
    }

    public void setTOTAL_FLAG(String TOTAL_FLAG) {
        this.TOTAL_FLAG = TOTAL_FLAG;
    }
}
