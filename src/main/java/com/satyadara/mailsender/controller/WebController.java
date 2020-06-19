package com.satyadara.mailsender.controller;

import com.satyadara.mailsender.model.Mail;
import com.satyadara.mailsender.service.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class WebController {

    @Qualifier("simpleMail")
    private final MailService simpleMail;

    @Qualifier("mimeMail")
    private final MailService mimeMail;

    @PostMapping(value = "/simple-mail", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void sendSimpleMail(@RequestBody Mail mail) {
        simpleMail.send(mail);
    }

    @PostMapping(value = "/mime-mail", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void sendMimeMail(@RequestBody Mail mail) {
        mimeMail.send(mail);
    }
}
