package com.formation.projet.service;

import java.util.List;

import com.formation.projet.entities.*;
import com.formation.projet.response.MessageResponse;

public interface PaysService {

	public MessageResponse save(Pays pays);
	public MessageResponse update(long id, Pays pays);
	public MessageResponse delete(long id);
    public List<Pays> findAll();
    public Pays findById(long id);
	
}
