package com.formation.projet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formation.projet.entities.*;
import com.formation.projet.repository.PaysRepository;
import com.formation.projet.response.MessageResponse;

@Service

public class PaysServiceImpl implements PaysService {

	@Autowired
	PaysRepository paysRepository;

    @Transactional
	@Override
	public MessageResponse save(Pays pays) {
		boolean existe = paysRepository.existsByLibelle(pays.getLibelle());
        if (existe){
        	return new MessageResponse(false,"Echec !","Ce pays existe déja !");   
        } else {
        paysRepository.save(pays);
        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");
        }
    }
    
    
    @Transactional
    @Override
    public MessageResponse update(long id, Pays pays) {
    	Pays existe = findById(id);
        if (existe == null){
        	return new MessageResponse(false,"Echec !","Ce pays n'existe pas !");   
        } else {
        //delete(id);
        pays.setId(id);
        paysRepository.save(pays);
        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");
        }
    }

    public Pays updatePays(Pays pays) {
        return paysRepository.save(pays);
    }

    @Transactional
    @Override
	public MessageResponse delete(long id)  {
    	Pays pays = findById(id);
		if (pays == null){
        	return new MessageResponse(false,"Echec !","Ce pays n'existe pas !");   
        } else {
        paysRepository.delete(pays);
        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");
        }
    }
    
    
    @Override
    public List<Pays> findAll() {

        return paysRepository.findAll();
    }


	@Override
	public Pays findById(long id) {
		Pays domaine = paysRepository.findById(id).orElse(null);
        return domaine;
	}

}
