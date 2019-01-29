package com.dyc.fileWriteRead.write.intMode;


import java.io.*;

/**
 * @Auther: tony_jaa
 * @Date: 2019/1/15 15:19
 * @Description:
 */
public class FileInputStreamByIntWrite {


    public static void main(String[] args) throws Exception {
        String path = "D:\\file\\strFile.txt";
        String content = "12345";
        writeByBuffer(content,path);
//        int a = 1;
//        char b = (char) a;
//        System.out.println(b);
    }


    private static void writeByBuffer( String content, String path ) throws Exception {
        FileOutputStream  fileOutputStream = null;
        BufferedOutputStream bufferedInputStream = null;
         try {
             fileOutputStream = new FileOutputStream(path);
             bufferedInputStream=new BufferedOutputStream(fileOutputStream);
             char[] chars = content.toCharArray();
             for (int i = 0; i < chars.length; i++) {
                 int b = chars[i];
                 bufferedInputStream.write(b);
             }
         }finally {
             if( bufferedInputStream != null ) bufferedInputStream.close();
             if( fileOutputStream != null ) fileOutputStream.close();
         }
    }
}
