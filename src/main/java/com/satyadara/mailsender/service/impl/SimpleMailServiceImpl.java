package com.satyadara.mailsender.service.impl;

import com.satyadara.mailsender.model.Mail;
import com.satyadara.mailsender.service.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service("simpleMail")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SimpleMailServiceImpl implements MailService {

    private final JavaMailSender sender;

    @Override
    public void send(Mail mail) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(mail.getRecipient());
        message.setSubject(mail.getSubject());
        message.setText(mail.getBody());

        sender.send(message);
    }
}
