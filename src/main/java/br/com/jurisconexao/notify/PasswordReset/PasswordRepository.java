/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.jurisconexao.notify.PasswordReset;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Marcos
 */
@Repository
public interface PasswordRepository extends JpaRepository<PasswordResetToken, String>{
    
     @Query("SELECT c FROM PasswordResetToken c WHERE c.id = ?1")
    public Optional<PasswordResetToken>  findByEmail(String email); 
     
    public Optional<PasswordResetToken> findByResetPasswordToken(String token);
    
}
