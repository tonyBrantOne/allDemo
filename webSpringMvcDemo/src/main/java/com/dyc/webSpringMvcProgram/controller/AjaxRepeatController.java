package com.dyc.webSpringMvcProgram.controller;

import com.dyc.webSpringMvcProgram.model.Input;
import com.dyc.webSpringMvcProgram.util.DateUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * title:
 * create by tony_jaa
 * date 2018/11/4
 */
@Controller
public class AjaxRepeatController {
    private int num = 0;
    private static final String PREFIX = "/views/";
    private static final String SUFFIX_JSP = ".jsp";
    private static final String SUFFIX_HTML = ".html";
    private String url = "http://localhost:8080/hall";

    @RequestMapping("/timeRepeat")
    @ResponseBody
    public Map<String,Object> timeRepeat(@RequestBody Input input, HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
        model.addAttribute("title","欢迎登录竞技游戏大厅");
        Map<String,Object> map = new HashMap<>();
        String nowDate = DateUtil.dateConvertString(new Date());
        map.put("code","2000");
        map.put("message","成功返回");
        map.put("body",nowDate);
        return map;
    }

    @RequestMapping(value="/timeSse",produces = "text/event-stream;charset=UTF-8")
    @ResponseBody
    public String timeSse( HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
        if( num++ > 0) {
            System.out.println("休眠中");
            Thread.sleep(20000);
        }
        String nowDate = DateUtil.dateConvertString(new Date());
        Map<String,Object> map = new HashMap<>();
        StringBuilder stringBuilder = new StringBuilder("retry:2000\n").append("data:")
                .append(nowDate).append("\n\n");
        return stringBuilder.toString();
    }

    @RequestMapping(value="/needPricer")
    public void pushRight( HttpServletResponse response) throws Exception {
        response.setContentType("text/event-stream");
        response.setCharacterEncoding("utf-8");
        PrintWriter printWriter = response.getWriter();
        while (true){
            String nowDate = DateUtil.dateConvertString(new Date());
            StringBuilder stringBuilder = new StringBuilder("retry:2000\n").append("data:")
                    .append(nowDate).append("\n\n");
            if( printWriter.checkError() ){
                System.out.println("printWriter.checkError");
                return;
            }
            Thread.sleep(1000);
            printWriter.write(stringBuilder.toString());
            printWriter.flush();
        }
    }


}
