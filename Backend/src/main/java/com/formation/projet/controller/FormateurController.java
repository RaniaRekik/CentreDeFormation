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

import com.formation.projet.entities.Formateur;
import com.formation.projet.response.MessageResponse;
import com.formation.projet.service.FormateurServiceImpl;

@RestController
@CrossOrigin("*")
@RequestMapping("/formateur")
public class FormateurController {

	@Autowired
    private FormateurServiceImpl formateurService;
	
	
    @GetMapping
    public List<Formateur> findAll() {
        return formateurService.findAll();
    }
	
	 @PostMapping
     @PreAuthorize("hasRole('ROLE_USER') ")
    public MessageResponse save(@RequestBody Formateur formateur) {
		 return formateurService.save(formateur);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_USER') ")
    public MessageResponse update(@PathVariable int id, @RequestBody Formateur formateur) {
    	return formateurService.update(id, formateur);
    }

    @PutMapping
    @PreAuthorize("hasRole('ROLE_USER') ")
        public ResponseEntity<Formateur> updateEmployee(@RequestBody Formateur formateur) {
        Formateur update = formateurService.updateFormateur(formateur);
        return new ResponseEntity<>(update, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_USER') ")
    public MessageResponse delete(@PathVariable int id) {
    	return formateurService.delete(id);
    }
    
    @GetMapping("/{id}")
    public Formateur findById(@PathVariable long id) {
        return formateurService.findById(id);
    }
    
    
}
