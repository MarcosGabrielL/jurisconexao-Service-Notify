/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.jurisconexao.notify.PasswordReset;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.jurisconexao.notify.exception.NotFoundException;

/**
 *
 * @author Marcos
 */
@Service
public class PasswordResetServices {
    
     @Autowired
    private PasswordRepository customerRepo;
     
     public PasswordResetToken updateResetPasswordToken(String token, String email) throws NotFoundException {
        PasswordResetToken customer = new PasswordResetToken();
        
            customer.setResetPasswordToken(token);
            customer.setId(email);
          return  customerRepo.save(customer);
        
    }
     
    public PasswordResetToken getByResetPasswordToken(String token) {
        return customerRepo.findByResetPasswordToken(token)
                .orElseThrow(() -> new NotFoundException("This token was not found"));
    }
     
   public void deleteResetPasswordToken(String token, String email) throws NotFoundException {
        PasswordResetToken customer = new PasswordResetToken();
        
            customer.setResetPasswordToken(token);
            customer.setId(email);
          try{ customerRepo.delete(customer);
          }catch(DataIntegrityViolationException e){
            throw new DataIntegrityViolationException(
                    "Não foi possivel deletar o Person");
        }
   }
   
}
