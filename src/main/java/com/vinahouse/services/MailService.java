package com.vinahouse.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class MailService {
    @Value("spring.mail.username")
    private String userFrom;
    @Autowired(required = false)
    private JavaMailSender mailSender;

    public void sendMail(String email, String code) throws MailException, MessagingException {

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(message);
        messageHelper.setFrom(userFrom);
        messageHelper.setTo("hoant0355@gmail.com");
        messageHelper.setSubject("Mail xác thực tài khoản");
        code = "http://localhost:8081/api/auth/verify?code=" + code;
        messageHelper.setText("<html><body><h1>Xác thực tài khoản</h1><a href='" + code + "'>VERIFY</a></body></html>",true);
        mailSender.send(message);
    }
}
