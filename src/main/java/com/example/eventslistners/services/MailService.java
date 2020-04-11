package com.example.eventslistners.services;

import com.example.eventslistners.dto.LibraryBookPublishedInfo;
import org.springframework.context.MessageSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.mail.internet.MimeMessage;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

@Service
public class MailService {

    private final SpringTemplateEngine templateEngine;
    private final JavaMailSender javaMailSender;

    public MailService(SpringTemplateEngine templateEngine, JavaMailSender javaMailSender) {
        this.templateEngine = templateEngine;
        this.javaMailSender = javaMailSender;
    }

    public void sendEmailToAuthor(LibraryBookPublishedInfo info) {
        sendEmailFromTemplate(info, "mail/publishedBookEmailAuthor");
    }

    private void sendEmailFromTemplate(LibraryBookPublishedInfo info, String templateName) {
        Context context = new Context(Locale.getDefault());
        context.setVariable("info", info);
        String content = templateEngine.process(templateName, context);
        sendEmail(info.getBook().getAuthor().getEmail(), "Published Book", content, false, true);

    }

    private void sendEmail(String to, String subject, String content, boolean isMultipart, boolean isHtml) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            System.out.println("Sending email");
            MimeMessageHelper message = new MimeMessageHelper(mimeMessage, isMultipart, StandardCharsets.UTF_8.name());
            message.setTo(to);
            message.setFrom("cristiaano.bombazar@gmail.com");
            message.setSubject(subject);
            message.setText(content, isHtml);
            javaMailSender.send(mimeMessage);
            System.out.println("Email sent");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
