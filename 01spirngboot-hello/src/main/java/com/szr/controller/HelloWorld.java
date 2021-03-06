package com.szr.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.PascalNameFilter;
import com.szr.controller.request.ESBRequest;
import com.szr.controller.request.inner.ReqAppHead;
import com.szr.controller.response.ESBResponse;
import com.szr.controller.response.QueryAccountInfoResponseDto;
import com.szr.controller.response.QueryInnerAccountResponseDto;
import com.szr.controller.response.UnifiedAccountingResponseDto;
import com.szr.controller.response.inner.ResAppHead;
import com.szr.controller.response.inner.ResSysHead;
import com.szr.controller.response.inner.Sub;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HelloWorld {
    @RequestMapping("/hello")
    @ResponseBody
    public Map<String, Object> showHelloWorld(){
        Map<String,Object> map = new HashMap<>();
        map.put("msg", "HelloWorld!！！！！！！！！！！！！");
        map.put("branchtest01","011111111111");
        return map;
    }

    @RequestMapping(value = "/esb", method = RequestMethod.POST)
    @ResponseBody
    public void testESBSendutil(HttpServletResponse response,@Valid @RequestBody String data) throws IOException {
        String decode = URLDecoder.decode(data, "utf-8");
        System.out.println(decode);

        //解析请求
        ESBRequest esbRequest = JSON.parseObject(decode, ESBRequest.class);
        System.out.println("SERVICE_ID:"+esbRequest.getSYS_HEAD().getSERVICE_ID());
        System.out.println("SERVICE_ID:"+esbRequest.getSYS_HEAD().getSCENE_ID());
        //解析请求

        //发送响应
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


        response.setCharacterEncoding("UTF-8");
        String jsonString = JSONObject.toJSONString(esbResponse,new PascalNameFilter());
        //String data1 = "输出的内容";
        //获取PrintWriter输出流
        PrintWriter out = response.getWriter();
        //使用PrintWriter流向客户端输出字符
        out.write(jsonString);

    }


    @RequestMapping(value = "/account", method = RequestMethod.POST)
    @ResponseBody
    public void testAccountingInterface(HttpServletResponse response,@Valid @RequestBody String data) throws IOException {
        String decode = URLDecoder.decode(data, "utf-8");
        System.out.println(decode);

        //发送响应
        ESBResponse esbResponse = new ESBResponse();
        ResSysHead head = new ResSysHead();
        head.setSERVICE_ID("1");
        head.setSCENE_ID("11111");
        List<ResSysHead.Ret> ret = new ArrayList<>();
        ResSysHead.Ret ret1 = head.new Ret();
        ret1.setRET_CODE("000000");
        ret1.setRET_MSG("123123123");
        ret.add(ret1);
        head.setRET_ARRAY(ret);
        esbResponse.setSYS_HEAD(head);

        //贷款账户信息查询
        QueryAccountInfoResponseDto body = new QueryAccountInfoResponseDto();
        body.setACCOUNT_STATUS_UPD_DATE("11111");
        body.setACCT_NAME("1111111");


        //内部账户信息查询
//        QueryInnerAccountResponseDto body = new QueryInnerAccountResponseDto();
//        Sub sub = new Sub();
//        sub.setACCOUNT_STATUS_UPD_DATE("11111");
//        sub.setACCT_CLASS("11111");
//        sub.setBALANCE(new BigDecimal("123123"));
//        List<Sub> list = new ArrayList<Sub>();
//        list.add(sub);
//        body.setSUB_ARRAY(list);

        //统一记账接口
//        UnifiedAccountingResponseDto body = new UnifiedAccountingResponseDto();
//        body.setREFERENCE("11111111");
//        UnifiedAccountingResponseDto.Result result = new UnifiedAccountingResponseDto().new Result();
//        result.setACCT_CCY("888888881");
//        result.setBRANCH("88881");
//        List<UnifiedAccountingResponseDto.Result> list = new ArrayList<>();
//        list.add(result);
//        body.setRESULT_ARRAY(list);

        esbResponse.setBODY(body);
        //response.setStatus(502);
        response.setCharacterEncoding("UTF-8");
        String jsonString = JSONObject.toJSONString(esbResponse,new PascalNameFilter());
        //String data1 = "输出的内容";
        //获取PrintWriter输出流
        PrintWriter out = response.getWriter();
        //使用PrintWriter流向客户端输出字符
        out.write(jsonString);

    }
}
