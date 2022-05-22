package com.formation.projet.controller;

import java.util.List;

import com.formation.projet.entities.Formation;
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

import com.formation.projet.entities.Organisme;
import com.formation.projet.response.MessageResponse;
import com.formation.projet.service.OrganismeServiceImpl;

@RestController
@CrossOrigin("*")
@RequestMapping("/organisme")
public class OrganismeController {

	@Autowired
    private OrganismeServiceImpl organismeService;
	
	
    @GetMapping
    public List<Organisme> findAll() {
        return organismeService.findAll();
    }
	
	 @PostMapping
     @PreAuthorize("hasRole('ROLE_ADMIN')")
    public MessageResponse save(@RequestBody Organisme organisme) {
		 return organismeService.save(organisme);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public MessageResponse update(@PathVariable int id, @RequestBody Organisme organisme) {
    	return organismeService.update(id, organisme);
    }

    @PutMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Organisme> updateEmployee(@RequestBody Organisme organisme) {
        Organisme update = organismeService.updateOrganisme(organisme);
        return new ResponseEntity<>(update, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public MessageResponse delete(@PathVariable int id) {
    	return organismeService.delete(id);
    }
    
    @GetMapping("/{id}")
    public Organisme findById(@PathVariable long id) {
        return organismeService.findById(id);
    }
    
    
}
