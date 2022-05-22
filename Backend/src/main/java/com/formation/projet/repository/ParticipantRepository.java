package com.formation.projet.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.formation.projet.entities.*;

@Repository
public interface ParticipantRepository extends JpaRepository<Participant, Long>     {
	public  Participant  findById(long id);
	boolean existsByEmail(String email);
	
	
}
