package com.formation.projet.controller;

import java.util.List;

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

import com.formation.projet.entities.Domaine;
import com.formation.projet.response.MessageResponse;
import com.formation.projet.service.DomaineServiceImpl;

@RestController
@CrossOrigin("*")
@RequestMapping("/domaine")
public class DomaineController {

	@Autowired
    private DomaineServiceImpl domaineService;


    @GetMapping
    public List<Domaine> findAll() {
        return domaineService.findAll();
    }
	
	 @PostMapping
     @PreAuthorize("hasRole('ROLE_ADMIN')")
    public MessageResponse save(@RequestBody Domaine domaine) {
		 return domaineService.save(domaine);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public MessageResponse update(@PathVariable int id, @RequestBody Domaine domaine) {
    	return domaineService.update(id, domaine);
    }

    @PutMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Domaine> updateEmployee(@RequestBody Domaine domaine) {
        Domaine update = domaineService.updateDomaine(domaine);
        return new ResponseEntity<>(update, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public MessageResponse delete(@PathVariable int id) {
    	return domaineService.delete(id);
    }


    @GetMapping("/{id}")
    public Domaine findById(@PathVariable long id) {
        return domaineService.findById(id);
    }
    
    
}
