package com.formation.projet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formation.projet.entities.*;
import com.formation.projet.repository.ProfilRepository;
import com.formation.projet.response.MessageResponse;

@Service

public class ProfilServiceImpl implements ProfilService {

	@Autowired
	ProfilRepository profilRepository;

    @Transactional
	@Override
	public MessageResponse save(Profil profil) {
		boolean existe = profilRepository.existsByLibelle(profil.getLibelle());
        if (existe){
        	return new MessageResponse(false,"Echec !","Ce profil existe déja !");   
        } else {
        profilRepository.save(profil);
        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");
        }
    }

    public Profil updateProfil(Profil profil) {
        return profilRepository.save(profil);
    }
    
    
    @Transactional
    @Override
    public MessageResponse update(long id, Profil profil) {
    	Profil existe = findById(id);
        if (existe == null){
        	return new MessageResponse(false,"Echec !","Ce profil n'existe pas !");   
        } else {
        //delete(id);
        profil.setId(id);
        profilRepository.save(profil);
        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");
        }
    }

    @Transactional
    @Override
	public MessageResponse delete(long id)  {
    	Profil profil = findById(id);
		if (profil == null){
        	return new MessageResponse(false,"Echec !","Ce profil n'existe pas !");   
        } else {
        profilRepository.delete(profil);
        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");
        }
    }
    
    
    @Override
    public List<Profil> findAll() {

        return profilRepository.findAll();
    }


	@Override
	public Profil findById(long id) {
		Profil profil = profilRepository.findById(id).orElse(null);
        return profil;
	}

}
