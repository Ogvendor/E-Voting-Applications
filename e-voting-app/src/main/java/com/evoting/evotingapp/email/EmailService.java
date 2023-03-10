package com.evoting.evotingapp.email;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;



@Service
@Slf4j
public class EmailService implements EmailSender{

    final JavaMailSender javaMailSender;
    public EmailService(JavaMailSender javaMailSender){
        this.javaMailSender = javaMailSender;
    }

    @Override
    @Async
    public void send(String to, String email) throws MessagingException {
        try {
            MimeMessage mailMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mailMessage, mailMessage.getEncoding());
            mimeMessageHelper.setSubject("Confirm Email");
            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setFrom("iykevictor75@yahoo.com");
            mimeMessageHelper.setText(email, true);
            javaMailSender.send(mailMessage);
        }catch (MessagingException e){
            log.info("problem: ");
            log.info(e.getMessage());
            throw new RuntimeException();
    }
    }
}
