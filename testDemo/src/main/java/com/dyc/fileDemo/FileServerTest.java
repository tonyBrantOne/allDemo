package com.dyc.fileDemo;/**
 * @Auther: tony_jaa
 * @Date: 2018/10/23 16:47
 * @Description:
 */

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @Auther: tony_jaa
 * @Date: 2018/10/23 16:47
 * @Description:
 */
public class FileServerTest {
    public static void main(String[] args) throws Exception {
        String path1 = "D:\\folder\\a\\soul.txt";
        String path2 = "D:\\folder\\bak\\soul.txt";
        copyLocalToLocalFile(path1,path2);
    }


    /**
     * 本地替换本地文件
     * @param path1
     * @param path2
     * @throws Exception
     */
    public static void copyLocalToLocalFile(String path1, String path2) throws Exception {
        InputStream inputStream =null;
        ServletOutputStream outputStream = null;
        try {
            inputStream = new FileInputStream(path1);
      //      outputStream = new ServletOutputStream();
            replaceLocalFile(inputStream,outputStream);
        }
        finally {
            inputStream.close();
            outputStream.close();
        }
    }


    /**
     * 输入流数据传输到输出流
     * @param inputStream
     * @param outputStream
     * @throws Exception
     */
    private static void replaceLocalFile(InputStream inputStream, OutputStream outputStream) throws Exception{
        byte[] buf = new byte[1024];
        int bytesRead;
        while ( ( bytesRead = inputStream.read(buf)) != -1){
            outputStream.write(buf,0,bytesRead);
        }
    }
}
