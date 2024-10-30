package com.ling.exportexcelfile.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

public class ExcelUtils {

    public static void setExcelResponseProp(HttpServletRequest request, HttpServletResponse response, String rawFileName) throws IOException {

        String userAgent = request.getHeader("User-Agent");
        String encodedFileName = URLEncoder.encode(rawFileName, "UTF-8");
        if (userAgent.contains("MSIE") && userAgent != null) {
            encodedFileName = encodedFileName.replace("+", "%20");
        } else {
            encodedFileName.replaceAll("%20", " ");
        }
//        //设置内容类型
//        response.setContentType("application/vnd.vnd.ms-excel");
//        //设置编码格式
//        response.setCharacterEncoding("utf-8");
//        //设置导出文件名称（避免乱码）
//        String fileName = URLEncoder.encode(rawFileName.concat(".xlsx"), "UTF-8");
//        // 设置响应头
////        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName);

        response.setHeader("Content-disposition", "attachment;filename=" + encodedFileName + ".xlsx");


    }
}
