/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.jurisconexao.notify.services;

import br.com.jurisconexao.notify.exception.UserNotFoundException;
import br.com.jurisconexao.notify.models.Notification;
import br.com.jurisconexao.notify.repositories.NotificationRopository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

/**
 *
 * @author Marcos
 */
@Service
public class NotificationService {
    
	 @Autowired
	    private NotificationRopository rp;
	 
	
	    
	     public List<Notification> findAll() {
	        return rp.findAll();
	    }
	     
	     public Notification findNotificationById(Long id) {
	        return rp.findNotificationById(id)
	                .orElseThrow(() -> new UserNotFoundException("Notification by id " + id + " was not found"));
	    }
	     
	     
	     
	     public Notification addNotification(Notification cinefilo) {
	        return rp.save(cinefilo);
	    }
	     
	      public Notification updateNotification(Notification cinefilo) {
	        return rp.save(cinefilo);
	    }
	      
	      public void deleteNotification(Long id){
	        try{
	          rp.deleteNotificationById(id);  
	        }catch(DataIntegrityViolationException e){
	            throw new DataIntegrityViolationException(
	                    "Não foi possivel deletar o Notification");
	        }
	    }
    
    
}
