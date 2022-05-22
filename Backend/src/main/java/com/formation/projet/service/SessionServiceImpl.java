package com.formation.projet.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formation.projet.entities.*;

import com.formation.projet.repository.SessionRepository;
import com.formation.projet.response.MessageResponse;

@Service

public class SessionServiceImpl  implements SessionService {
	
	@Autowired
	SessionRepository sessionRepository;

    @Transactional
	@Override
	public MessageResponse save(Session session) {
		boolean existe = sessionRepository.existsById(session.getId());
        if (existe){
        	return new MessageResponse(false,"Echec !","Ce session existe déja !");   
        } else {
        	sessionRepository.save(session);
        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");
        }
    }

    
    
    @Transactional
    @Override
    public MessageResponse update(long id, Session session) {
    	Session existe = findById(id);
        if (existe == null){
        	return new MessageResponse(false,"Echec !","Ce profil n'existe pas !");   
        } else {
        //delete(id);
        	session.setId(id);
        sessionRepository.save(session);
        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");
        }
    }

    @Transactional
    @Override
	public MessageResponse delete(long id)  {
    	Session session = findById(id);
		if (session == null){
        	return new MessageResponse(false,"Echec !","Ce profil n'existe pas !");   
        } else {
        	sessionRepository.delete(session);
        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");
        }
    }
    
    
    @Override
    public List<Session> findAll() {

        return sessionRepository.findAll();
    }

    /*public Session findVehicleById(Long vehicleId) {
        return vehicleRepository.findByVehicleId(vehicleId);
    }*/

    public Session updateSession(Session session) {
        return sessionRepository.save(session);
    }

	@Override
	public Session findById(long id) {
		Session session = sessionRepository.findById(id);
        return session;
	}
	
	
	
}
