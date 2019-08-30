package pl.shop.H2OShop.service;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import pl.shop.H2OShop.domain.User;
import org.apache.commons.mail.Email;


@Service
public class EmailService {
    private String username = "h2oshopconfirm@gmail.com";
    private String password = "!Test123!";

    public void sendAuthenticationEmail (User user) throws EmailException {

        Email email = new SimpleEmail();
        email.setHostName("smtp.gmail.com");
        email.setSmtpPort(465);
        email.setAuthentication(username,password);
        email.setSSLOnConnect(true);
        email.setStartTLSEnabled(true);
        email.setFrom(username , "Witamy w sklepie");
        email.setSubject("H2OShop activation link");
        email.setMsg("Click here to activate your account on H2OShop:"
                + "\n\n http://localhost:9090/activate?link=" + user.getActivationCode());
        email.addTo(user.getEmail());
        email.send();
    }
}
