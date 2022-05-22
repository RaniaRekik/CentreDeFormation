package com.formation.projet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formation.projet.entities.*;
import com.formation.projet.repository.FormationRepository;
import com.formation.projet.response.MessageResponse;

@Service

public class FormationServiceImpl  implements FormationService {
	
	
	@Autowired
	FormationRepository formationRepository;

    @Transactional
	@Override
	public MessageResponse save(Formation formation) {
		boolean existe = formationRepository.existsById(formation.getId());
        if (existe){
        	return new MessageResponse(false,"Echec !","Cet formation existe déja !");   
        } else {
        	formationRepository.save(formation);
        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");
        }
    }

    public Formation updateFormation(Formation formation) {
        return formationRepository.save(formation);
    }


    @Transactional
    @Override
    public MessageResponse update(long id, Formation formation) {
    	Formation existe = findById(id);
        if (existe == null){
        	return new MessageResponse(false,"Echec !","Cet Formation n'existe pas !");   
        } else {
        //delete(id);
        	formation.setId(id);
        	formationRepository.save(formation);
        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");
        }
    }

    @Transactional
    @Override
	public MessageResponse delete(long id)  {
    	Formation formation = findById(id);
		if (formation == null){
        	return new MessageResponse(false,"Echec !","Cet formation n'existe pas !");   
        } else {
        	formationRepository.delete(formation);
        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");
        }
    }
    
    
    @Override
    public List<Formation> findAll() {

        return formationRepository.findAll();
    }


	@Override
	public Formation findById(long id) {
		Formation formation = formationRepository.findById(id).orElse(null);
        return formation;
	}

}
