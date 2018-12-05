package com.dyc.demo3.util;/**
 * @Auther: tony_jaa
 * @Date: 2018/7/19 20:08
 * @Description:
 */

import com.dyc.mqOnline.service.TestService;
import org.springframework.context.ApplicationContext;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: tony_jaa
 * @Date: 2018/7/19 20:08
 * @Description:
 */
public class ParamMapUtil {
    /**
     * 用来存放更新失败的次数
     */
    public static final Map<Long, Map<String,Integer>> errNumMap = new HashMap<Long, Map<String,Integer>>();

    public static final Map<Class<ApplicationContext>,ApplicationContext> CONTEXT_MAP = new HashMap<>();

}
