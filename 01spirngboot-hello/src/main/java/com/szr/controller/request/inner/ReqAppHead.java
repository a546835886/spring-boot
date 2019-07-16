package com.szr.controller.request.inner;


import org.hibernate.validator.constraints.Length;

public class ReqAppHead {

    @Length(max = 1, message = "PGUP_OR_PGDN最大长度不能超过1！")
    private String PGUP_OR_PGDN;            //上翻/下翻标志

    @Length(max = 3, message = "CURRENT_PG_TOTAL_NUM最大长度不能超过3！")
    private String CURRENT_PG_TOTAL_NUM;    //本页记录总数

    @Length(max = 12, message = "CURRENT_NUM最大长度不能超过12！")
    private String CURRENT_NUM;             //当前记录号

    @Length(max = 1, message = "TOTAL_FLAG最大长度不能超过1！")
    private String TOTAL_FLAG;              //汇总标志

    public String getPGUP_OR_PGDN() {
        return PGUP_OR_PGDN;
    }

    public void setPGUP_OR_PGDN(String PGUP_OR_PGDN) {
        this.PGUP_OR_PGDN = PGUP_OR_PGDN;
    }

    public String getCURRENT_PG_TOTAL_NUM() {
        return CURRENT_PG_TOTAL_NUM;
    }

    public void setCURRENT_PG_TOTAL_NUM(String CURRENT_PG_TOTAL_NUM) {
        this.CURRENT_PG_TOTAL_NUM = CURRENT_PG_TOTAL_NUM;
    }

    public String getCURRENT_NUM() {
        return CURRENT_NUM;
    }

    public void setCURRENT_NUM(String CURRENT_NUM) {
        this.CURRENT_NUM = CURRENT_NUM;
    }

    public String getTOTAL_FLAG() {
        return TOTAL_FLAG;
    }

    public void setTOTAL_FLAG(String TOTAL_FLAG) {
        this.TOTAL_FLAG = TOTAL_FLAG;
    }
}
