package br.com.jurisconexao.notify.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.web.bind.annotation.*;

import br.com.jurisconexao.notify.enums.EmailSender;
import br.com.jurisconexao.notify.enums.Emails;
import br.com.jurisconexao.notify.models.Notification;
import br.com.jurisconexao.notify.services.NotificationService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class EmailController {
    
    @Autowired
    private EmailSender emailSender;
     
    @Autowired
    private NotificationService notificationService;
    
   
   
 
    @PostMapping("/forgot_password")
public String processForgotPassword( @RequestParam("email") String email,   @RequestParam("email") String token) {
    String message = "We have sent a reset password link to your email. Please check.";
    
    
     
    try {
     
        //customerService.updateResetPasswordToken(token, email);
        String resetPasswordLink = "https://emiele.herokuapp.com/reset_password?token=" + token + "&email="+email;
        
        emailSender.sendResetPass(
                email,
                Emails.buildEmailReset(resetPasswordLink));
        
         
    } catch (Exception ex) {
       message ="error:" + ex.getMessage();
    } 
         
    return message;
}
   
    
    @PostMapping("/sendingemail")
   public String generateEmail( @RequestParam("token") String token,
           @RequestParam("email") String email, @RequestParam("email") String nome) throws Exception {
             
    
        String link = "https://emiele.herokuapp.com/confirm?token=" + token +"&email="+email;
       emailSender.sendVeriftion(
    		   email,
               Emails.buildEmail(nome, link));

       return link;
       
   }
    
   
    
    @MessageMapping("/sendingNotify")
    @SendTo("/topic/group")
    public Notification broadcastGroupMessage(@Payload Notification message) {
    	notificationService.addNotification(message);
    	
        return message;
    }

    @MessageMapping("/notify.addUser")
    @SendTo("/topic/public")
    public Notification addUser(
            @Payload Notification notification,
            SimpMessageHeaderAccessor headerAccessor
    ) {
        headerAccessor.getSessionAttributes().put("username", notification);
        return notification;
    }
    
}

