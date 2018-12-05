package com.dyc;

import com.alibaba.fastjson.JSON;
import com.dyc.model.ParamDTO;
import com.dyc.model.RegisterDTO;
import com.dyc.model.UserDTO;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;

/**
 * @Auther: tony_jaa
 * @Date: 2018/7/27 14:32
 * @Description:
 */
public class HttpClientLogin {
    private static final String AGENT = "QD9J";//代理号
    private static final String MERCHANT_CODE = "FPC";//商户号
    private static final String SALT_TXT = "EEEUB7M1DLCNTGC";

    public static void main(String[] args) {
        @SuppressWarnings("resource")
        HttpClient httpClient = new DefaultHttpClient();
        HttpPut httpput = new HttpPut("http://sh9001.sport.me:8070/api/game/FPC/handle");
        httpput.addHeader("Content-Type","application/json");
        try {
            HttpEntity requestEntity=getStringEntity();
            httpput.setEntity(requestEntity);
            HttpResponse response = httpClient.execute(httpput);
            System.out.println("response--"+response);
            System.out.println("response.getStatusLine()--"+response.getStatusLine());
            System.out.println("response.getStatusLine().getStatusCode()--"+response.getStatusLine().getStatusCode());
            String strJson = EntityUtils.toString(response.getEntity(), "UTF-8");
            System.out.println("strJson--"+strJson);

        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            httpClient.getConnectionManager().shutdown();
        }
    }

    public static HttpEntity getStringEntity() throws Exception{
        RegisterDTO registerDTO = new RegisterDTO();
        registerDTO.setAction("login");//注册接口
        registerDTO.setMode("1");//测试
        registerDTO.setAgent(AGENT);//代理号
        registerDTO.setMerchant(MERCHANT_CODE);//商户号
    //    registerDTO.setParams(createUserDTO());
        registerDTO.setNickName("tony123456");
        registerDTO.setPassword("123456");
        registerDTO.setUserName(MERCHANT_CODE+AGENT+registerDTO.getNickName());
        registerDTO.setIp("192.168.0.190");
        String strJson = JSON.toJSONString(registerDTO);
        System.out.println(strJson);
        String param = encryptDES3(strJson,SALT_TXT);
        ParamDTO paramDTO = new ParamDTO(param);
        return new StringEntity(JSON.toJSONString(paramDTO), "UTF-8");
    }



    public static String encryptDES3(String str, String saltTxt){
        byte[] md5Key = getMd5 (saltTxt); //16bytes
        SecretKey key = new SecretKeySpec(md5Key, "DESede");
        Cipher ecipher;
        String encryptedString = null;
        try {
            ecipher = Cipher.getInstance ("DESede/ECB/PKCS5Padding");
            ecipher.init(Cipher. ENCRYPT_MODE , key);
            byte[] data = str.getBytes("UTF-8");
            byte[] encryptedArray = ecipher.doFinal(data);
            encryptedString = new Base64().encodeToString(encryptedArray);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return encryptedString;
    }

    public static byte[] getMd5(String keyString){
        MessageDigest messageDigest;
        byte[] rawKey = new byte[24];
        try {
            messageDigest = MessageDigest. getInstance ("MD5");
            messageDigest.update(keyString.getBytes("UTF-8"), 0, keyString.length());
            byte[] md5 = messageDigest.digest();
            System. arraycopy (md5, 0, rawKey, 0, 16);
            System. arraycopy (md5, 0, rawKey, 16, 8);
        } catch (Exception e) {
           e.printStackTrace();
        }
        return rawKey;
    }



}
