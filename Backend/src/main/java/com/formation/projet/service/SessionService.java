package com.formation.projet.service;


import com.formation.projet.entities.*;
import com.formation.projet.response.MessageResponse;

import java.util.List;


public interface SessionService {
	

	public MessageResponse save(Session session);
	public MessageResponse update(long id,Session session);
	public MessageResponse delete(long id);
    public List<Session> findAll();
    public Session findById(long id);

}
