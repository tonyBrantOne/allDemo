package com.dyc.fileWriteRead.write.strMode.unBuffer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @Auther: tony_jaa
 * @Date: 2019/1/15 14:15
 * @Description:
 */
public class FileWriterStrToLocalFile {

    public static void main(String[] args) throws Exception {
        String path = "D:\\file\\strFile.txt";
        String content = "fileWriterDireStrToFile";
        fileWriterDireStrToFile(content,path);
    }

    /**
     * 直接通过FileWriter对象把字符串写入到文件中，无需借助缓冲区。
     * @param str
     * @param filePath
     */
    public static void fileWriterDireStrToFile( String str,String filePath ) throws Exception {
        FileWriter fw = null;
        try {
            File file = new File(filePath);
            if( !file.exists() ) {
                file.createNewFile();
            }
            fw = new FileWriter(file);
            fw.write(str);
        }finally{
            if( fw != null ) fw.close();
        }
    }
}
