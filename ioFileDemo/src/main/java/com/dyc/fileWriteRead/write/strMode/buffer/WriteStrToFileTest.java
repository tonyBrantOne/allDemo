package com.dyc.fileWriteRead.write.strMode.buffer;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/**
 * @Auther: tony_jaa
 * @Date: 2019/1/15 13:07
 * @Description:将内存中的字符串写入文件中
 */
public class WriteStrToFileTest {

    public static void main(String[] args) throws Exception {

        String path = "D:\\file\\strFile.txt";
        String content = "tonyJaa";
        bufferedStrWriter(content,path);

    }

    /**
     * 将字符串写入文件中，借助BufferedWriter缓冲区对象。
     * @param str
     * @param filePath
     * @throws Exception
     */
    public static void bufferedStrWriter(String str,String filePath) throws Exception{
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            File file = new File(filePath);
            if( !file.exists() ) {
                file.createNewFile();
            }
            fw = new FileWriter(file);
            bw = new BufferedWriter(fw);
            bw.write(str);
        }catch ( Exception e ){
            e.printStackTrace();
            throw e;
        }finally{
            if( bw != null ) bw.close();
            if( fw != null ) fw.close();
        }
    }


}
