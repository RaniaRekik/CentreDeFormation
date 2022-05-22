package com.formation.projet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formation.projet.entities.*;
import com.formation.projet.repository.OrganismeRepository;
import com.formation.projet.response.MessageResponse;

@Service

public class OrganismeServiceImpl implements OrganismeService {

	@Autowired
	OrganismeRepository organismeRepository;

    @Transactional
	@Override
	public MessageResponse save(Organisme organisme) {
		boolean existe = organismeRepository.existsByLibelle(organisme.getLibelle());
        if (existe){
        	return new MessageResponse(false,"Echec !","Cet organisme existe déja !");   
        } else {
        organismeRepository.save(organisme);
        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");
        }
    }

    public Organisme updateOrganisme(Organisme organisme) {
        return organismeRepository.save(organisme);
    }
    
    @Transactional
    @Override
    public MessageResponse update(long id, Organisme organisme) {
    	Organisme existe = findById(id);
        if (existe == null){
        	return new MessageResponse(false,"Echec !","Cet organisme n'existe pas !");   
        } else {
        //delete(id);
        organisme.setId(id);
        organismeRepository.save(organisme);
        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");
        }
    }

    @Transactional
    @Override
	public MessageResponse delete(long id)  {
    	Organisme organisme = findById(id);
		if (organisme == null){
        	return new MessageResponse(false,"Echec !","Cet organisme n'existe pas !");   
        } else {
        organismeRepository.delete(organisme);
        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");
        }
    }
    
    
    @Override
    public List<Organisme> findAll() {

        return organismeRepository.findAll();
    }


	@Override
	public Organisme findById(long id) {
		Organisme domaine = organismeRepository.findById(id).orElse(null);
        return domaine;
	}

}
