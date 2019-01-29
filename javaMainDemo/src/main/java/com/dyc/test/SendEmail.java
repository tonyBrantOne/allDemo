package com.dyc.test;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * @Auther: tony_jaa
 * @Date: 2019/1/17 15:04
 * @Description:
 */
public class SendEmail {

    public static void main(String[] args) throws Exception {
//        // 收件人电子邮箱
//        String to = "175709605@qq.com";
//
//        // 发件人电子邮箱
//        String from = "18060579796@163.com";
//
//        // 指定发送邮件的主机为 localhost
//        String host = "https://mail.163.com";
//
//        // 获取系统属性
//        Properties properties = System.getProperties();
//
//        // 设置邮件服务器
//        properties.setProperty("smtp.163.com", host);
//
//        // 获取默认session对象
//        Session session = Session.getDefaultInstance(properties);
//
//        try{
//            // 创建默认的 MimeMessage 对象
//            MimeMessage message = new MimeMessage(session);
//
//            // Set From: 头部头字段
//            message.setFrom(new InternetAddress(from));
//
//            // Set To: 头部头字段
//            message.addRecipient(Message.RecipientType.TO,
//                    new InternetAddress(to));
//
//            // Set Subject: 头部头字段
//            message.setSubject("This is the Subject Line!");
//
//            // 设置消息体
//            message.setText("丐哥你好！我是X_MAN");
//
//            // 发送消息
//            Transport.send(message);
//            System.out.println("Sent message successfully....");
//        }catch (MessagingException mex) {
//            mex.printStackTrace();
//        }

    }
}
