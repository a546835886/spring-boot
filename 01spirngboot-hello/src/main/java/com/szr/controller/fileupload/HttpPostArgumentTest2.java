package com.szr.controller.fileupload;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.PascalNameFilter;
import com.szr.controller.request.ImageFileTransmitRequestDTO;
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

        String imageFileName = "E:\\test\\YGCA201901220000000001147_0001.jpg";
        String imageFileName1 = "E:\\test\\YGCA201901220000000001147_0002.jpg";
        String imageFileName2 = "E:\\test\\YGCA201901220000000001147_0003.jpg";
        String imageFileName3 = "E:\\test\\YGCA201901220000000001147_0004.pdf";
        String imageFileName4 = "E:\\test\\YGLA201901220000000001147_0005.pdf";
        String zipFileName = "E:\\test\\test01.zip";

        //构建POST请求
        HttpPost post = new HttpPost("http://localhost:8081/leex-api/szrService/upload1");
        InputStream inputStream1 = null;
        try {
            InputStream inputStream = new FileInputStream(zipFileName);
            File file = new File(imageFileName);
            File file1 = new File(imageFileName1);
            File file2 = new File(imageFileName2);
            File file3 = new File(imageFileName3);
            File file4 = new File(imageFileName4);
            String message = getjson();
            MultipartEntityBuilder builder = MultipartEntityBuilder.create();
            builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
            builder.addBinaryBody("upfile", file, ContentType.DEFAULT_BINARY, imageFileName);
            builder.addBinaryBody("upfile1", file1, ContentType.DEFAULT_BINARY, imageFileName1);
            builder.addBinaryBody("upfile2", file2, ContentType.DEFAULT_BINARY, imageFileName2);
            builder.addBinaryBody("upfile3", file3, ContentType.DEFAULT_BINARY, imageFileName3);
            builder.addBinaryBody("upfile4", file4, ContentType.DEFAULT_BINARY, imageFileName4);
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
        ImageFileTransmitRequestDTO  request = new ImageFileTransmitRequestDTO();
       request.setApp_serial_no("YGCA201901220000000001147");
       request.setFile_list("YGCA201901220000000001147_0001.jpg|YGCA201901220000000001147_0002.jpg|YGCA201901220000000001147_0003.jpg|YGCA201901220000000001147_0004.pdf|YGLA201901220000000001147_0005.pdf");

        return JSONObject.toJSONString(request);
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
