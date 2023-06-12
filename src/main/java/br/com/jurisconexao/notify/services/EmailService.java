/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.jurisconexao.notify.services;

/**
 *
 * @author Marcos
 */
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import br.com.jurisconexao.notify.enums.EmailSender;


@Service
@AllArgsConstructor
public class EmailService implements EmailSender {

    private final static Logger LOGGER = LoggerFactory.getLogger(EmailService.class);


   

	@Override
	public void sendVeriftion(String to, String email) {
		/* try {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
        helper.setText(email, true);
        helper.setTo(to);
        helper.setSubject("Informações - Emiele");
        helper.setFrom("tesrtddtfor@gmail.com");
        mailSender.send(mimeMessage);
    } catch (MessagingException e) {
        LOGGER.error("failed to send email", e);
        throw new IllegalStateException("failed to send email");
    }*/
		
	}


	@Override
	public void sendResetPass(String to, String email) {
		// TODO Auto-generated method stub
		
	}
    
    
    
    
}
