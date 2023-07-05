/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.jurisconexao.notify.services;


import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.jurisconexao.notify.exception.UserNotFoundException;
import br.com.jurisconexao.notify.models.Evento;
import br.com.jurisconexao.notify.repositories.EventoRepository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.aspectj.apache.bcel.classfile.annotation.NameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;


/**
 *
 * @author Marcos
 */

@Service
public class EventoService {
    
   
	 @Autowired
	    private EventoRepository rp;
	    
	     public List<Evento> findAll() {
	        return rp.findAll();
	    }
	     
	     public Evento findEventoById(Long id) {
	        return rp.findEventoById(id)
	                .orElseThrow(() -> new UserNotFoundException("Evento by id " + id + " was not found"));
	    }
	     public  List<Evento> findByEmail(String email) {
	        return rp.findByEmail(email);
	    }
	     
	     public Evento addEvento(Evento cinefilo) {
	        return rp.save(cinefilo);
	    }
	     
	      public Evento updateEvento(Evento cinefilo) {
	        return rp.save(cinefilo);
	    }
	      
	      public void deleteEvento(Long id){
	        try{
	          rp.deleteEventoById(id);  
	        }catch(DataIntegrityViolationException e){
	            throw new DataIntegrityViolationException(
	                    "Não foi possivel deletar o Evento");
	        }
	    }
    
}
