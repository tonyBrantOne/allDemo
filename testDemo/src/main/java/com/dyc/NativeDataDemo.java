package com.dyc;


/**
 * @Auther: tony_jaa
 * @Date: 2019/1/15 15:40
 * @Description:
 */
public class NativeDataDemo {
    private byte b = 127;//字节类型              8位
    private boolean bool;//布尔值   1个byte

    private short s;//短整型       2个byte 16位
    private char c = 'A'; //字符         2个byte 16位

    private int i;//整型           4个byte 32位
    private float f;//单精度浮点型   4个byte 32位


    private long l;//长整型         8个byte 64位
    private double d;//双精度浮点型  8个byte 64位

    public static void main(String[] args) {
        new NativeDataDemo().startMain();
    }

    private void startMain(){
        String str2 = firstPhraseToSmall( "SetId");
        System.out.println(str2);
    }
    public String firstPhraseToSmall( String content ){
        char[] chars = content.toCharArray();
        chars[0] = (char) (chars[0] + 32);
        return String.valueOf(chars);
    }


}
