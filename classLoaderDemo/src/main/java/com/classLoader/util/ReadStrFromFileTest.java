package com.classLoader.util;


import java.io.*;

/**
 * @Auther: tony_jaa
 * @Date: 2019/1/15 13:07
 * @Description:从文件中读取字符串
 */
public class ReadStrFromFileTest {

    public static void main(String[] args) throws Exception {

        String path = "D:\\file\\strFile.txt";
        String content = "tonyJaa";
        String jsonStr = bufferedStrRead( path );
        System.out.println(jsonStr);

    }

    /**
     * 从文件中读取字符串。
     * @param path
     * @return
     * @throws Exception
     */
    public static String bufferedStrRead( String path ) throws Exception {
        BufferedReader bReader = null;
        try {
            File file = new File(path);//定义一个file对象，用来初始化FileReader
            FileReader reader = new FileReader(file);//定义一个fileReader对象，用来初始化BufferedReader
            bReader = new BufferedReader(reader);//new一个BufferedReader对象，将文件内容读取到缓存
            StringBuilder sb = new StringBuilder();//定义一个字符串缓存，将字符串存放缓存中
            String s = "";
            while ( ( s = bReader.readLine()) != null ) {//逐行读取文件内容，不读取换行符和末尾的空格
                sb.append(s + "\n");//将读取的字符串添加换行符后累加存放在缓存中
            }
            return sb.toString();
        }finally {
            if( bReader != null ) bReader.close();
        }
    }

    /**
     * 每次读取一个int内容，并写入到ByteArrayOutputStream流中，
     * @param path
     * @return 把流转为byte数组
     * @throws Exception
     */
    public static byte[] readFileToByteArray( String path ) throws Exception {
        BufferedReader bReader = null;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bytes = null;
        try {
            File file = new File(path);//定义一个file对象，用来初始化FileReader
            FileReader reader = new FileReader(file);//定义一个fileReader对象，用来初始化BufferedReader
            bReader = new BufferedReader(reader);//new一个BufferedReader对象，将文件内容读取到缓存
            StringBuilder sb = new StringBuilder();//定义一个字符串缓存，将字符串存放缓存中
            int ch = 0;
            while ( ( ch = bReader.read()) != -1 ) {//逐行读取文件内容，不读取换行符和末尾的空格
                byteArrayOutputStream.write(ch);
            }
            return byteArrayOutputStream.toByteArray();
        }finally {
            if( bReader != null ) bReader.close();
        }
    }


    public static byte[] readInputStreamToByteArray( String path ) throws Exception {
        InputStream inputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bytes = null;
        try {
            File file = new File(path);//定义一个file对象，用来初始化FileReader
            inputStream = new FileInputStream(file);
            int ch = 0;
            while ( ( ch = inputStream.read()) != -1 ) {//逐行读取文件内容，不读取换行符和末尾的空格
                byteArrayOutputStream.write(ch);
            }
            return byteArrayOutputStream.toByteArray();
        }finally {
            if( inputStream != null ) inputStream.close();
        }
    }

}
