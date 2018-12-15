package com.dyc.webSpringMvcProgram.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * title:
 * create by tony_jaa
 * date 2018/11/4
 */
@Controller
public class IndexController {
    private static final String PREFIX = "/views/";
    private static final String SUFFIX_JSP = ".jsp";
    private static final String SUFFIX_HTML = ".html";
    private String url = "http://localhost:8080/hall";

    @RequestMapping("/index")
    public String index(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
        model.addAttribute("title","欢迎登录竞技游戏大厅");
        return PREFIX +"index" + SUFFIX_JSP;
    }


}
