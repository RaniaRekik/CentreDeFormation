package com.formation.projet.service;

import java.util.List;

import com.formation.projet.entities.*;
import com.formation.projet.response.MessageResponse;

public interface DomaineService {

	public MessageResponse save(Domaine domaine);
	public MessageResponse update(long id, Domaine domaine);
	public MessageResponse delete(long id);
    public List<Domaine> findAll();
    public Domaine findById(long id);
	
}
