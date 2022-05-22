package com.formation.projet.controller;

import java.util.List;

import com.formation.projet.entities.Domaine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.formation.projet.entities.Pays;
import com.formation.projet.response.MessageResponse;
import com.formation.projet.service.PaysServiceImpl;

@RestController
@CrossOrigin("*")
@RequestMapping("/pays")
public class PaysController {

	@Autowired
    private PaysServiceImpl paysService;
	
	
    @GetMapping

     public List<Pays> findAll() {
        return paysService.findAll();
    }

    @PutMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Pays> updatePays(@RequestBody Pays pays) {
        Pays update = paysService.updatePays(pays);
        return new ResponseEntity<>(update, HttpStatus.OK);
    }

	 @PostMapping
     @PreAuthorize("hasRole('ROLE_ADMIN')")
    public MessageResponse save(@RequestBody Pays pays) {
		 return paysService.save(pays);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public MessageResponse update(@PathVariable int id, @RequestBody Pays pays) {
    	return paysService.update(id, pays);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public MessageResponse delete(@PathVariable int id) {
    	return paysService.delete(id);
    }
    
    @GetMapping("/{id}")

    public Pays findById(@PathVariable long id) {
        return paysService.findById(id);
    }
    
    
}
