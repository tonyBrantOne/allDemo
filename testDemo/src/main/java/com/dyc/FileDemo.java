package com.dyc;/**
 * @Auther: tony_jaa
 * @Date: 2019/1/9 20:32
 * @Description:
 */

import java.io.File;

/**
 * @Auther: tony_jaa
 * @Date: 2019/1/9 20:32
 * @Description:
 */
public class FileDemo {
    private static final String path = "D:/projectManage/demo/bossMonitor/target/bossMonitor-1.0-SNAPSHOT/WEB-INF/classes/file/";
    public static void main(String[] args) {
        File file = new File(path);
        if( !file.isDirectory() ){
            file.mkdir();
        }
    }
}
