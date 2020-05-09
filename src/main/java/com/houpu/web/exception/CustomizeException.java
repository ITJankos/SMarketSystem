package com.houpu.web.exception;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class CustomizeException implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        // 把异常信息，通过流的形式写到某个日志文件中
          // 获取错误位置
        StackTraceElement stackTrace = e.getStackTrace()[0];
         // 获取错误信息
        String message = e.getMessage();
         // 获取错误日期
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月 dd日 hh - mm - ss");
        String format = simpleDateFormat.format(new Date());
        // 以字符缓冲流的形式写到日志文件
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:\\error.log", true));
            bufferedWriter.write(stackTrace + ";" + message + ";" + format);
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        //视图跳转
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("erorr");
        return modelAndView;
    }
}
