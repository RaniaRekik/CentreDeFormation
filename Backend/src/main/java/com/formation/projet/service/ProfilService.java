package com.formation.projet.service;

import java.util.List;

import com.formation.projet.entities.*;
import com.formation.projet.response.MessageResponse;

public interface ProfilService {

	public MessageResponse save(Profil profil);
	public MessageResponse update(long id, Profil profil);
	public MessageResponse delete(long id);
    public List<Profil> findAll();
    public Profil findById(long id);
	
}
