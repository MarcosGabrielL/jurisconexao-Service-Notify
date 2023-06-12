/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.jurisconexao.notify.repositories;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.jurisconexao.notify.models.Notification;


/**
 *
 * @author Marcos
 */
@Repository
public interface NotificationRopository extends JpaRepository<Notification, Long> {
    
     Optional<Notification> findNotificationById(Long id);
     
     void deleteNotificationById(Long id);
     
   

	
}
