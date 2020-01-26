package at.qe.sepm.skeleton.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import java.util.Properties;

/**
 * Service to send e-mails to users
 */
@Component
public class EmailService{

    @Autowired
    public JavaMailSender emailSender;

    /**
     * Method to send a mail to a user
     * @param to the target mail-address
     * @param subject the subject of the mail
     * @param text to text of the mail
     */
    public void sendMessage(String to, String subject, String text){
        if(emailSender==null){
            emailSender = getEmailSender();
        }
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        emailSender.send(message);
    }

    /**
     * Method to get a Instance of EmailSender
     * @return returns a JavaMailSender
     */
    @Bean
    public JavaMailSender getEmailSender(){
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);

        mailSender.setUsername("softwarearch20@gmail.com");
        mailSender.setPassword("software123MAIL");

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return mailSender;
    }


}
