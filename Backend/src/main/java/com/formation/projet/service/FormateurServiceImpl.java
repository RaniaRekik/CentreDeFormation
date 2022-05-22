package com.formation.projet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formation.projet.entities.*;
import com.formation.projet.repository.FormateurRepository;
import com.formation.projet.response.MessageResponse;

@Service

public class FormateurServiceImpl implements FormateurService {

	@Autowired
	FormateurRepository formateurRepository;

    @Transactional
	@Override
	public MessageResponse save(Formateur formateur) {
		boolean existe = formateurRepository.existsByEmail(formateur.getEmail());
        if (existe){
        	return new MessageResponse(false,"Echec !","Ce formateur existe déja !");   
        } else {
        formateurRepository.save(formateur);
        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");
        }
    }

    public Formateur updateFormateur(Formateur formateur) {
        return formateurRepository.save(formateur);
    }
    
    
    @Transactional
    @Override
    public MessageResponse update(long id, Formateur formateur) {
    	Formateur existe = findById(id);
        if (existe == null){
        	return new MessageResponse(false,"Echec !","Ce formateur n'existe pas !");   
        } else {
        //delete(id);
        formateur.setId(id);
        formateurRepository.save(formateur);
        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");
        }
    }

    @Transactional
    @Override
	public MessageResponse delete(long id)  {
    	Formateur formateur = findById(id);
		if (formateur == null){
        	return new MessageResponse(false,"Echec !","Ce formateur n'existe pas !");   
        } else {
        formateurRepository.delete(formateur);
        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");
        }
    }
    
    
    @Override
    public List<Formateur> findAll() {

        return formateurRepository.findAll();
    }


	@Override
	public Formateur findById(long id) {
		Formateur domaine = formateurRepository.findById(id).orElse(null);
        return domaine;
	}

}
