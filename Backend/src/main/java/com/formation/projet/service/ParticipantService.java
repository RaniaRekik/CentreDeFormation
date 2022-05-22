package com.formation.projet.service;

import java.util.List;


import com.formation.projet.entities.Participant;
import com.formation.projet.response.MessageResponse;

public interface ParticipantService {

	public MessageResponse save(Participant participant);
	public MessageResponse update(long id, Participant participant);
	public MessageResponse delete(long id);
    public List<Participant> findAll();
    public Participant findById(long id);
	
}
