package com.Email.controller;


import com.Email.Config.EmailConfig;
import com.Email.Config.Feedback;
import com.Email.model.EmailMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {


    @Value("${spring.mail.host}")
    private String host;
    @Value("${spring.mail.port}")
    private Integer port;
    @Value("${spring.mail.username}")
    private String username;
    @Value("${spring.mail.password}")
    private String password;

    @Autowired
    EmailConfig emailConfig;

    @PostMapping
    public void sendFeedback(@RequestBody Feedback feedback) {


        //Create mail sender
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(emailConfig.getHost());
        mailSender.setPort(emailConfig.getPort());
        mailSender.setUsername(emailConfig.getUsername());
        mailSender.setPassword(emailConfig.getPassword());

        //Create an email instance
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(feedback.getEmail());
        mailMessage.setTo("thienle112014@gmail.com");
        mailMessage.setSubject("New feedback from " + feedback.getName());
        mailMessage.setText(feedback.getFeedback());

        //Send mail
        mailSender.send(mailMessage);
    }

//    @PostMapping("/send")
//    public String sendEmail(@RequestBody EmailMessage emailMessage) {
//        sendMail(emailMessage);
//        return "Email sent successfully";
//    }
//
//    private void sendMail(EmailMessage emailMessage) {
//
//        Properties props = new Properties();
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.starttis.enable", "true");
//        props.put("mail.smtp.host", "smtp.gmail.com");
//        props.put("mail.smtp.port", "587");
//
//        Session session = Session.getInstance(props,
//                new javax.mail.Authenticator() {
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication(username, password);
//            }
//                });
//
//        Message msg = new MimeMessage(session);
//        msg.setFrom(new InternetAddress(username, false));
//
//        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("thienle112014@gmail.com"));
//        msg.setSubject(emailMessage.getSubject());
//        msg.setContent(emailMessage.getBody(), "text/html");
//        msg.setSentDate(new Date());
//    }

}
