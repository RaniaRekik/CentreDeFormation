package com.formation.projet.service;

import java.util.List;

import com.formation.projet.entities.*;
import com.formation.projet.response.MessageResponse;

public interface OrganismeService {

	public MessageResponse save(Organisme organisme);
	public MessageResponse update(long id, Organisme organisme);
	public MessageResponse delete(long id);
    public List<Organisme> findAll();
    public Organisme findById(long id);
	
}
