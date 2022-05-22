package com.formation.projet.service;

import java.util.List;

import com.formation.projet.entities.*;
import com.formation.projet.response.MessageResponse;


public interface FormationService {
	public MessageResponse save(Formation formation);
	public MessageResponse update(long id, Formation formation);
	public MessageResponse delete(long id);
    public List<Formation> findAll();
    public Formation findById(long id);

	
	
	
}
