package com.szr.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.PascalNameFilter;
import com.szr.controller.response.ESBResponse;
import com.szr.controller.response.inner.ResAppHead;
import com.szr.controller.response.inner.ResSysHead;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        ESBResponse esbResponse = new ESBResponse();
        ResSysHead head = new ResSysHead();
        head.setSERVICE_ID("1");
        head.setSCENE_ID("11111");
        List<ResSysHead.Ret> ret = new ArrayList<>();
        ResSysHead.Ret ret1 = head.new Ret();
        ret1.setRET_CODE("0000");
//        ret1.setRET_MSG("123123123");
        ret.add(ret1);
        head.setRET_ARRAY(ret);
        esbResponse.setSYS_HEAD(head);

        ResAppHead body = new ResAppHead();
        body.setCURRENT_NUM("1");
        body.setCURRENT_PG_TOTAL_NUM("1");
        body.setPGUP_OR_PGDN("1");
        body.setTOTAL_FLAG(null);
        esbResponse.setBODY(body);

        String json = JSON.toJSONString(esbResponse);
        System.out.println(json);
    }
}
