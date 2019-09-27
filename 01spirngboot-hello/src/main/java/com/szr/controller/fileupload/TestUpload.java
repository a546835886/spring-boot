package com.szr.controller.fileupload;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.ContentBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Map;

/**
 * 文件传送
 * 发送文件流到服务器端
 * 服务器端使用SpringBoot的MultipartFile接收
 *
 * 适用场景：
 * 绝对路径的URL文件，不存储到本地，转换成stream,直接使用HTTPClient传送到SpringBoot
 *
 */
public class TestUpload {

    public static String postFileMultiPart(String url,Map<String, ContentBody> reqParam) throws ClientProtocolException, IOException{
        CloseableHttpClient httpclient = HttpClients.createDefault();

        try {
            // 创建httpget.
            HttpPost httppost = new HttpPost(url);

            //setConnectTimeout：设置连接超时时间，单位毫秒。setConnectionRequestTimeout：设置从connect Manager获取Connection 超时时间，单位毫秒。这个属性是新加的属性，因为目前版本是可以共享连接池的。setSocketTimeout：请求获取数据的超时时间，单位毫秒。 如果访问一个接口，多少时间内无法返回数据，就直接放弃此次调用。
            RequestConfig defaultRequestConfig = RequestConfig.custom().setConnectTimeout(5000).setConnectionRequestTimeout(5000).setSocketTimeout(15000).build();
            httppost.setConfig(defaultRequestConfig);

            System.out.println("executing request " + httppost.getURI());

            MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create();
            for(Map.Entry<String,ContentBody> param : reqParam.entrySet()){
                multipartEntityBuilder.addPart(param.getKey(), param.getValue());
            }
            HttpEntity reqEntity = multipartEntityBuilder.build();
            httppost.setEntity(reqEntity);

            // 执行post请求.
            CloseableHttpResponse response = httpclient.execute(httppost);

            System.out.println("got response");

            try {
                // 获取响应实体
                HttpEntity entity = response.getEntity();
                //System.out.println("--------------------------------------");
                // 打印响应状态
                //System.out.println(response.getStatusLine());
                if (entity != null) {
                    return EntityUtils.toString(entity,Charset.forName("UTF-8"));
                }
                //System.out.println("------------------------------------");
            } finally {
                response.close();

            }
        } finally {
            // 关闭连接,释放资源
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


    public static void main(String[] args) {
        //文件URL，此处取豆瓣上的一个图片
        String fileUrl ="https://img1.doubanio.com/view/photo/l/public/p2537149328.webp";
        try {
            //提取到文件名
            String fileName = fileUrl.substring(fileUrl.lastIndexOf("/")+1);
            //转换成文件流
            InputStream is = new URL(fileUrl).openStream();

            //接收文件的服务器地址
            String uploadURL = "http://localhost:8003/fileupload";

            //创建HttpClient
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost(uploadURL);
            MultipartEntityBuilder builder = MultipartEntityBuilder.create();
            /*绑定文件参数，传入文件流和contenttype，此处也可以继续添加其他formdata参数*/
            builder.addBinaryBody("file",is, ContentType.MULTIPART_FORM_DATA,fileName);
            HttpEntity entity = builder.build();
            httpPost.setEntity(entity);

            //执行提交
            HttpResponse response = httpClient.execute(httpPost);
            HttpEntity responseEntity = response.getEntity();
            if(responseEntity != null){
                //将响应的内容转换成字符串
                String result = EntityUtils.toString(responseEntity, Charset.forName("UTF-8"));

                //此处根据服务器返回的参数转换，这里返回的是JSON格式
                JSONObject output = JSON.parseObject(result);
                JSONArray body = output.getJSONArray("body");
                String resUrl = body.get(0)+"";

                System.out.println(resUrl);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }
}
