package com.formation.projet.controller;



import java.util.List;

import com.formation.projet.entities.Formateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.formation.projet.entities.Domaine;
import com.formation.projet.entities.Formation;
import com.formation.projet.entities.Organisme;
import com.formation.projet.repository.FormationRepository;
import com.formation.projet.response.MessageResponse;

import com.formation.projet.service.FormationServiceImpl;



@RestController
@CrossOrigin("*")
@RequestMapping("/formation")
public class FormationController {

	
	@Autowired
    private FormationServiceImpl formationService;
	
	
    @GetMapping
    public List<Formation> findAll() {
        return formationService.findAll();
    }
	
	 @PostMapping
     @PreAuthorize("hasRole('ROLE_USER') ")
    public MessageResponse save(@RequestBody  Formation formation) {
		 return formationService.save(formation);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_USER') ")
    public MessageResponse update(@PathVariable int id, @RequestBody Formation formation) {
    	return formationService.update(id, formation);
    }

    @PutMapping
    @PreAuthorize("hasRole('ROLE_USER') ")
    public ResponseEntity<Formation> updateEmployee(@RequestBody Formation formation) {
        Formation update = formationService.updateFormation(formation);
        return new ResponseEntity<>(update, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_USER') ")
    public MessageResponse delete(@PathVariable int id) {
    	return formationService.delete(id);
    }
    
    @GetMapping("/{id}")
    public Formation findById(@PathVariable long id) {
        return formationService.findById(id);
    }
    
	
	
	
	
}
