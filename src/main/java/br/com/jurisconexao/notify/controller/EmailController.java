package br.com.jurisconexao.notify.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.jurisconexao.notify.PasswordReset.PasswordResetServices;
import br.com.jurisconexao.notify.PasswordReset.PasswordResetToken;
import br.com.jurisconexao.notify.enums.EmailSender;
import br.com.jurisconexao.notify.enums.Emails;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class EmailController {
    
    @Autowired
    private EmailSender emailSender;
     
    @Autowired
    private PasswordResetServices customerService;
    
   
   
 
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
     
     
     
 
     
    @PostMapping("/reset_password")
public String processResetPassword(@RequestParam("token") String token,
            @RequestParam("email") String email, @RequestParam("password") String password) {
    
    String message = "You have successfully changed your password.";
    
    //Verifica se token existe
    PasswordResetToken customer = customerService.getByResetPasswordToken(token);
    
     if (customer == null) {
        return "Invalid Token";
     } else {   
         
     
         
     }
     
    return message;
}
   
    
    @CrossOrigin(origins = "http://localhost:4200/")
    @PostMapping("/sendingemail")
   public String generateEmail( @RequestParam("token") String token,
           @RequestParam("email") String email, @RequestParam("email") String nome) throws Exception {
             
    
        String link = "https://emiele.herokuapp.com/confirm?token=" + token +"&email="+email;
       emailSender.sendVeriftion(
    		   email,
               Emails.buildEmail(nome, link));

       return link;
       
   }
    
}

