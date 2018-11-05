package com.elegantcollection.controller;

import com.elegantcollection.entity.Customer;
import com.elegantcollection.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class UploadController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UploadController.class);
    @Autowired
    CustomerService customerService;

    /**
     * 单个文件上传
     * 上传头像
     *
     * @return 结果
     */
//    @GetMapping("/upload")
//    public String upload() {
//        return "upload";
//    }

    @PostMapping("/upload")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile imageFile, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (imageFile.isEmpty()) {
            return "上传失败，请选择文件";
        }
        Customer customer = (Customer) request.getSession().getAttribute("customer");
        if (request.getSession().getAttribute("customer") == null) {
            //TODO 422 exception
//            request.getRequestDispatcher("/login").forward(request, response);
            response.sendRedirect("/top");
            return "登陆中...";
        }
        //check()检查文件的格式
        String originFileName = imageFile.getOriginalFilename();
        if (!originFileName.endsWith(".jpg")
                && !originFileName.endsWith(".bmp")
                && !originFileName.endsWith(".png")
                && !originFileName.endsWith(".gif")) {
            return "上传失败，不允许的类型!";
        }
        HttpSession session = request.getSession();
        String realPath = session.getServletContext().getRealPath("/");
        String filePath = "uploads/images/";
        File dir = new File(realPath + filePath);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        //先把用户上传到原图保存到服务器上
        //TODO 这里先写死
        String savedFileName = (new Date()).getTime() + originFileName.substring(originFileName.lastIndexOf("."));
        File file = new File(dir, savedFileName);
        String custProfile =filePath + savedFileName;

        try {
            imageFile.transferTo(file);//从内存保存到磁盘中
            LOGGER.info("上传成功");
            customer.setCustProfile(custProfile);
            customerService.updataCustProfile(customer);
            response.sendRedirect("userinfo");
            return custProfile;
        } catch (IOException e) {
            LOGGER.error(e.toString(), e);
        }
        return "上传失败！";
    }


    /**
     * 多文件上传
     *
     * @return 返回结果
     */
    @GetMapping("/multiUpload")
    public String multiUpload() {
        return "multiUpload";
    }

    @PostMapping("/multiUpload")
    @ResponseBody
    public String multiUpload(HttpServletRequest request) {
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
        String filePath = "/Users/itinypocket/workspace/temp/";
        for (int i = 0; i < files.size(); i++) {
            MultipartFile file = files.get(i);
            if (file.isEmpty()) {
                return "上传第" + (i++) + "个文件失败";
            }
            String fileName = file.getOriginalFilename();

            File dest = new File(filePath + fileName);
            try {
                file.transferTo(dest);
                LOGGER.info("第" + (i + 1) + "个文件上传成功");
            } catch (IOException e) {
                LOGGER.error(e.toString(), e);
                return "上传第" + (i++) + "个文件失败";
            }
        }

        return "上传成功";
    }
}
