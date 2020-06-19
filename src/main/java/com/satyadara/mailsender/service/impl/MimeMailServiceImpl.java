package com.satyadara.mailsender.service.impl;

import com.satyadara.mailsender.model.Mail;
import com.satyadara.mailsender.service.MailService;
import com.satyadara.mailsender.util.MailUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

@Service("mimeMail")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
public class MimeMailServiceImpl implements MailService {

    private final JavaMailSender sender;

    @Override
    public void send(Mail mail) {
        MimeMessage message = sender.createMimeMessage();

        Map<String, Object> map = new HashMap<>();
        map.put("recipient", mail.getRecipient());
        String html = MailUtils.formatMessage(mail.getBody(), map);

        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(mail.getRecipient());
            helper.setSubject(mail.getSubject());
            helper.setText(html, true);

            sender.send(message);
        } catch (MessagingException e) {
            log.error(e.getMessage());
        }
    }
}
