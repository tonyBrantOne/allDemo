package com.dyc.test;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * @Auther: tony_jaa
 * @Date: 2019/1/17 15:26
 * @Description:
 */
public class PostMainTest {

    public static void main(String[] args) throws Exception {
        Properties prop=new Properties();
        prop.put("mail.host","smtp.163.com" );
        prop.put("mail.transport.protocol", "smtp");
        prop.put("mail.smtp.auth", true);
        //使用java发送邮件5步骤
        //1.创建sesssion
        Session session=Session.getInstance(prop);
        //开启session的调试模式，可以查看当前邮件发送状态
        session.setDebug(true);

        //2.通过session获取Transport对象（发送邮件的核心API）
        Transport ts=session.getTransport();
        //3.通过邮件用户名密码链接
        ts.connect("18060579796@163.com", "123456abc");

        //4.创建邮件
        Message msg=createSimpleMail(session);

        //5.发送电子邮件
        ts.sendMessage(msg, msg.getAllRecipients());
        System.out.println("结束发送");

    }


    public static MimeMessage createSimpleMail(Session session) throws AddressException,MessagingException {
        //创建邮件对象
        MimeMessage mm=new MimeMessage(session);
        //设置发件人
        mm.setFrom(new InternetAddress("18060579796@163.com"));
        //设置收件人
        mm.setRecipient(Message.RecipientType.TO, new InternetAddress("1740205238@qq.com"));

        //       mm.setRecipient(Message.RecipientType.TO, new InternetAddress("1005185662@qq.com"));
//        //设置抄送人
//        mm.setRecipient(Message.RecipientType.CC, new InternetAddress(""));

        mm.setSubject("致国强的一封信！");
        mm.setContent("亲爱的：国强", "text/html;charset=utf-8");

        return mm;
    }


}
