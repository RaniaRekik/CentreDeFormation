package com.formation.projet.service;

import java.util.List;

import com.formation.projet.entities.*;
import com.formation.projet.response.MessageResponse;

public interface FormateurService {

	public MessageResponse save(Formateur formateur);
	public MessageResponse update(long id, Formateur formateur);
	public MessageResponse delete(long id);
    public List<Formateur> findAll();
    public Formateur findById(long id);
	
}
