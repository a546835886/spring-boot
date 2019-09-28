package com.szr.controller;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.support.StandardMultipartHttpServletRequest;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/leex-api")
public class RecoveryFileController {

    @RequestMapping(value = "/szrService/upload")
    @ResponseBody
    public String file (HttpServletRequest request, HttpServletResponse response
            ,@RequestParam(value = "szrData") String data) throws IOException {
        try {
            String szrData1 = request.getParameter("szrData");
            System.out.println(szrData1);
            System.out.println("szrService controller data 请求报文："+ URLDecoder.decode(data, "utf-8"));

            StandardMultipartHttpServletRequest req = (StandardMultipartHttpServletRequest) request;
            Iterator<String> iterator = req.getFileNames();
            while (iterator.hasNext()) {
                MultipartFile file = req.getFile(iterator.next());
                String absolutelyName = file.getOriginalFilename();
                String fileName = absolutelyName.substring(absolutelyName.lastIndexOf(File.separator) + 1);
                InputStream is = file.getInputStream();
                //TODO 本机目录格式String localDir = localPath /debtorCode /Upload_date()/App_serial_no();
                FileOutputStream fos = new FileOutputStream("E:/YG" + File.separator + fileName);
                byte[] buffer = new byte[1024];
                while (is.read(buffer) > 0) {
                    fos.write(buffer, 0, buffer.length);
                }
                fos.flush();
                fos.close();
            }
            response.setContentType("text/html;charset=UTF-8");

        }catch (Exception e){
            e.printStackTrace();
            return "fail";
        }
        return "success";
    }

    @RequestMapping(value = "/receive", method = RequestMethod.POST)
    @ResponseBody
    public void receiveData(HttpServletRequest request, HttpServletResponse response) {

        PrintWriter out = null;
        response.setContentType("text/html;charset=UTF-8");
        //response.setContentType("multipart/form-data");

        Map map = new HashMap();
        FileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setHeaderEncoding("UTF-8");
        upload.setFileSizeMax(1024*1024*10);
        upload.setSizeMax(1024*1024*30);


        File directory = null;
        List<FileItem> items = new ArrayList();
        try {


            MultipartHttpServletRequest multipartRequest =
                    WebUtils.getNativeRequest(request, MultipartHttpServletRequest.class);
            MultipartFile file = multipartRequest.getFile("upfile");
            MultipartFile file1 = multipartRequest.getFile("upstream");
            MultipartFile file2 = multipartRequest.getFile("text");


            items = upload.parseRequest(multipartRequest);
            // 得到所有的文件
            Iterator<FileItem> it = items.iterator();
            while (it.hasNext()) {
                FileItem fItem = (FileItem) it.next();
                String fName = "";
                Object fValue = null;
                if (fItem.isFormField()) { // 普通文本框的值
                    fName = fItem.getFieldName();
//					fValue = fItem.getString();
                    fValue = fItem.getString("UTF-8");
                    map.put(fName, fValue);
                } else { // 获取上传文件的值
                    fName = fItem.getFieldName();
                    fValue = fItem.getInputStream();
                    map.put(fName, fValue);
                    String name = fItem.getName();
                    if(name != null && !("".equals(name))) {
                        name = name.substring(name.lastIndexOf(File.separator) + 1);

//						String stamp = StringUtils.getFormattedCurrDateNumberString();
                        String timestamp_Str = new SimpleDateFormat("yyyyMMdd").format(new Date());
                        directory = new File("E://AAA");
                        directory.mkdirs();

                        String filePath = ("E://AAA")+ timestamp_Str+ File.separator + name;
                        map.put(fName + "FilePath", filePath);

                        InputStream is = fItem.getInputStream();
                        FileOutputStream fos = new FileOutputStream(filePath);
                        byte[] buffer = new byte[1024];
                        while (is.read(buffer) > 0) {
                            fos.write(buffer, 0, buffer.length);
                        }
                        fos.flush();
                        fos.close();
                        map.put(fName + "FileName", name);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("读取http请求属性值出错!");
            e.printStackTrace();
//            logger.error("读取http请求属性值出错");
        }

        // 数据处理
        System.out.println("处理数据11111111111111111111");

        try {
            out = response.getWriter();
            out.print("{success:true, msg:'接收成功'}");
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
