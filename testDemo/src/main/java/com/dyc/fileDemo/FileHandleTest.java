package com.dyc.fileDemo;/**
 * @Auther: tony_jaa
 * @Date: 2018/10/23 16:47
 * @Description:
 */

import java.io.*;

/**
 * @Auther: tony_jaa
 * @Date: 2018/10/23 16:47
 * @Description:
 */
public class FileHandleTest {
    public static void main(String[] args) throws Exception {
        String path1 = "D:\\folder\\a\\soul.txt";
        getFileNameByFile(new File(path1));
//        String path2 = "D:\\folder\\bak\\soul.txt";
//        copyLocalToLocalFile(path1,path2);
    }


    public static void getFileNameByFile( File file){
        String name = file.getName();
        System.out.println(name);
    }


    /**
     * 本地替换本地文件
     * @param path1
     * @param path2
     * @throws Exception
     */
    public static void copyLocalToLocalFile(String path1, String path2) throws Exception {
        InputStream inputStream =null;
        OutputStream outputStream = null;
        try {
            inputStream = new FileInputStream(path1);
            outputStream = new FileOutputStream(path2);
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
