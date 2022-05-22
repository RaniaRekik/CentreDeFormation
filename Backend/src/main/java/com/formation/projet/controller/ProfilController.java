package com.formation.projet.controller;

import java.util.List;

import com.formation.projet.entities.Pays;
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

import com.formation.projet.entities.Profil;
import com.formation.projet.response.MessageResponse;
import com.formation.projet.service.ProfilServiceImpl;

@RestController
@CrossOrigin("*")
@RequestMapping("/profil")
public class ProfilController {

	@Autowired
    private ProfilServiceImpl profilService;



	
    @GetMapping


    public List<Profil> findAll() {
        return profilService.findAll();
    }
	
	 @PostMapping
     @PreAuthorize("hasRole('ROLE_ADMIN')")
    public MessageResponse save(@RequestBody Profil profil) {
		 return profilService.save(profil);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public MessageResponse update(@PathVariable int id, @RequestBody Profil profil) {
    	return profilService.update(id, profil);
    }

    @PutMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Profil> updatePays(@RequestBody Profil profil) {
        Profil update = profilService.updateProfil(profil);
        return new ResponseEntity<>(update, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public MessageResponse delete(@PathVariable int id) {
    	return profilService.delete(id);
    }
    
    @GetMapping("/{id}")

    public Profil findById(@PathVariable long id) {
        return profilService.findById(id);
    }
    
    
}
