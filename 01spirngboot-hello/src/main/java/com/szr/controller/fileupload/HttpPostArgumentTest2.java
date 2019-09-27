package com.szr.controller.fileupload;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.PascalNameFilter;
import com.szr.controller.response.ESBResponse;
import com.szr.controller.response.inner.ResAppHead;
import com.szr.controller.response.inner.ResSysHead;
import org.apache.http.*;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.DateUtils;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileItemFactory;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.junit.Test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author <a href="mailto:just_szl@hotmail.com"> Geray</a>
 * @version 1.0,2012-6-12
 */
public class HttpPostArgumentTest2 {

    @Test
    public  void fileUpload() throws IOException {

        //构建HttpClient对象
        CloseableHttpClient client = HttpClients.createDefault();

        String imageFileName = "E:\\test\\YGCA201901220000000001282_0001.jpg";
        String zipFileName = "E:\\test\\test01.zip";

        //构建POST请求
        HttpPost post = new HttpPost("http://localhost:8080/file/receive1");
        InputStream inputStream1 = null;
        try {
            InputStream inputStream = new FileInputStream(zipFileName);
            File file = new File(imageFileName);
            String message = getjson();
            MultipartEntityBuilder builder = MultipartEntityBuilder.create();
            builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
            builder.addBinaryBody
                        ("upfile", file, ContentType.DEFAULT_BINARY, imageFileName);
            builder.addBinaryBody
                    ("upstream", inputStream, ContentType.create("application/zip"), zipFileName);
            builder.addTextBody("szrData", message, ContentType.TEXT_PLAIN);
//
            HttpEntity entity = builder.build();
            post.setEntity(entity);
            HttpResponse response = client.execute(post);

            HttpEntity entity1 = response.getEntity();
            //响应报文
            String responseJson = EntityUtils.toString(entity1, "UTF-8");

            System.out.println("响应报文：" + responseJson);

            //==================23
//            //要上传的文件
//            File file = new File("E:\\test\\YGCA201901220000000001282_0001.jpg");
//            //构建文件体
//            FileBody fileBody = new FileBody(file, ContentType.MULTIPART_FORM_DATA,"YGCA201901220000000001282_0001.jpg");
//            StringBody stringBody = new StringBody("12",ContentType.MULTIPART_FORM_DATA);
//            HttpEntity httpEntity = MultipartEntityBuilder
//                    .create()
//                    .setMode(HttpMultipartMode.BROWSER_COMPATIBLE)
//                    .addPart("uploadFile", fileBody)
//                    .addPart("id",stringBody).build();
//            httpPost.setEntity(httpEntity);
//            //发送请求
//            HttpResponse response = client.execute(post);
//            httpEntity = response.getEntity();
//
//            HttpEntity entity = response.getEntity();
            //响应报文
//            String responseJson = EntityUtils.toString(entity, "UTF-8");
//            System.out.println("响应报文" + responseJson);

//            if(httpEntity != null){
//                inputStream = httpEntity.getContent();
//                //转换为字节输入流
//                BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, Consts.UTF_8));
//                String body = null;
//                while ((body = br.readLine()) != null) {
//                    System.out.println(body);
//                }
//            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(inputStream1 != null){
                try {
                    inputStream1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public String getjson(){
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


        return JSONObject.toJSONString(esbResponse,new PascalNameFilter());
    }


    //file1与file2在同一个文件夹下 filepath是该文件夹指定的路径
    public void SubmitPost(String url,String filename1,String filename2, String filepath){

        //HttpClient httpclient = new DefaultHttpClient();
        HttpClient httpclient = HttpClients.createDefault();

        try {

            HttpPost httppost = new HttpPost(url);

            FileBody bin = new FileBody(new File(filepath + File.separator + filename1));

            FileBody bin2 = new FileBody(new File(filepath + File.separator + filename2));

            StringBody comment = new StringBody(filename1);

            MultipartEntity reqEntity = new MultipartEntity();

            reqEntity.addPart("file1", bin);//file1为请求后台的File upload;属性
            reqEntity.addPart("file2", bin2);//file2为请求后台的File upload;属性
            reqEntity.addPart("filename1", comment);//filename1为请求后台的普通参数;属性
            httppost.setEntity(reqEntity);

            HttpResponse response = httpclient.execute(httppost);


            int statusCode = response.getStatusLine().getStatusCode();


            if(statusCode == HttpStatus.SC_OK){

                System.out.println("服务器正常响应.....");

                HttpEntity resEntity = response.getEntity();


                System.out.println(EntityUtils.toString(resEntity));//httpclient自带的工具类读取返回数据



                System.out.println(resEntity.getContent());

                EntityUtils.consume(resEntity);
            }

        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                httpclient.getConnectionManager().shutdown();
            } catch (Exception ignore) {

            }
        }
    }





    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        HttpPostArgumentTest2 httpPostArgumentTest2 = new HttpPostArgumentTest2();

        httpPostArgumentTest2.SubmitPost("http://localhost:8080/file/receive",
                "YGCA201901220000000001282_0001.jpg","YGCA201901220000000001282_0002.jpg","E:/test");
    }

}
