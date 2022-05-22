package com.formation.projet.service;


import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import com.formation.projet.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.formation.projet.entities.*;
import com.formation.projet.repository.ParticipantRepository;
import com.formation.projet.response.MessageResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class ParticipantServiceImpl implements ParticipantService {

	@Autowired
	ParticipantRepository participantRepository;
    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    private SessionServiceImpl sessionService;

    @Transactional
	@Override
	public MessageResponse save(Participant participant) {
		boolean existe = participantRepository.existsByEmail(participant.getEmail());
        if (existe){
        	return new MessageResponse(false,"Echec !","Cet organisme existe déja !");   
        } else {
        	participantRepository.save(participant);
        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");
        }
    }

    public MessageResponse savePersonne(Participant participant) {
        Participant newParticipant = new Participant();
        newParticipant.setId(participant.getId());
        newParticipant.setNom(participant.getNom());
        newParticipant.setPrenom(participant.getPrenom());
        newParticipant.setEmail(participant.getEmail());
        newParticipant.setPays(participant.getPays());
        newParticipant.setOrganisme(participant.getOrganisme());
        newParticipant.setProfil(participant.getProfil());
        newParticipant.getSession()
                .addAll(participant
                        .getSession()
                        .stream()
                        .map(s -> {
                            Session sssion = s;
                            sssion=  sessionService.findById(sssion.getId());
                            sssion.getParticipant().add(newParticipant);
                            return sssion;
                        }).collect(Collectors.toSet()));
        participantRepository.save(newParticipant);
        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");
    }



    @Transactional
    @Override
    public MessageResponse update(long id, Participant participant) {
        Participant existe = findById(id);
        if (existe == null){
            return new MessageResponse(false,"Echec !","Ce Participant n'existe pas !");
        } else {
            //delete(id);
            participant.setId(id);
            participantRepository.save(participant);
            return new MessageResponse(true,"Succès","Opération réalisée avec succès.");
        }
    }



    
    


    @Transactional
    @Override
	public MessageResponse delete(long id)  {
    	Participant participant = findById(id);
		if (participant == null){
        	return new MessageResponse(false,"Echec !","Ce formateur n'existe pas !");   
        } else {
        	participantRepository.delete(participant);
        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");
        }
    }


    public Participant updateParticipant(Participant participant) {
        return participantRepository.save(participant);
    }

    @Override
    public List<Participant> findAll() {

        return participantRepository.findAll();
    }


	@Override
	public Participant findById(long id) {
		Participant participant = participantRepository.findById(id);
        return participant;
	}


	
}
