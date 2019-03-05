package com.robert.mentor.infrastructure.email;

import com.robert.mentor.domain.email.VerificationCodeSender;
import com.robert.mentor.domain.user.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
public class GmailVerificationCodeSender implements VerificationCodeSender {

    private final Logger log = LoggerFactory.getLogger(GmailVerificationCodeSender.class);
    private Properties gmailProperties;
    private Session session;

    @Value("${server.url}")
    private String serverUrl;
    @Value("${url.user.activation}")
    private String urlUserActivation;

    private static final String GMAIL_ADDRESS = "rbrt93@gmail.com";
    private static final String GMAIL_APP_NAME = "mentor-proj";
    private static final String GMAIL_APP_CODE = "mmhneiwafsfqycfg";

    @PostConstruct
    public void configureGmailSettings() {
        gmailProperties = System.getProperties();
        gmailProperties.put("mail.smtp.port", "587");
        gmailProperties.put("mail.smtp.auth", "true");
        gmailProperties.put("mail.smtp.starttls.enable", "true");
    }

    @Override
    public void sendVerificationCodeTo(User user) throws Exception {
        MimeMessage mimeMessage = generateMimeMessage(user);
        Transport transport = session.getTransport("smtp");
        transport.connect("smtp.gmail.com", GMAIL_ADDRESS, GMAIL_APP_CODE);
        log.info("Confirmation mail sent: " + mimeMessage.toString());
        transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
        transport.close();
    }


    private MimeMessage generateMimeMessage(User user) throws AddressException, MessagingException {
        session = Session.getDefaultInstance(gmailProperties);
        MimeMessage mimeMessage = new MimeMessage(session);
        mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(user.getId().getValue()));
        mimeMessage.setSubject("Generated code");
        StringBuilder body = new StringBuilder("The code that has been generated for your account is: " + user.getRegisteredCode());
        body.append("\nFor activation, follow the link: ");
        body.append(generateActivationUrl(user.getRegisteredCode()));
        mimeMessage.setContent(body.toString(), "text/html");
        return mimeMessage;
    }

    private String generateActivationUrl(String activationToken) {
        return new StringBuilder(serverUrl).append(urlUserActivation).append(activationToken).toString();
    }
}
