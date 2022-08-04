package com.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class Servlet01 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //1、判断数据是否是多段的
        if (ServletFileUpload.isMultipartContent(req)) {
            //2、创建fileItemFactory工厂实现类
            FileItemFactory fileItemFactory = new DiskFileItemFactory();

            //3、创建用于解析上传数据的工具类
            ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);

            try {
                //4、解析上传的数据，得到每一个表单项FileItem
                List<FileItem> list = servletFileUpload.parseRequest(req);
                //5、循环判断，每一个表单项，是普通类还是上传文件
                for (FileItem fileItem : list) {
                    if (fileItem.isFormField()) {
                        //普通表单项
                        System.out.println("表单项的name属性值：" + fileItem.getFieldName());
                        //参数UTF-8，解决乱码问题
                        System.out.println("表单项的value属性值：" + fileItem.getString());

                    } else {
                        //上传文件
                        System.out.println("表单项的name属性值：" + fileItem.getFieldName());
                        System.out.println("上传的文件名：" + fileItem.getName());

                        //文件保存位置
                        fileItem.write(new File("f:\\" + fileItem.getName()));
                    }
                }



            } catch (FileUploadException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
