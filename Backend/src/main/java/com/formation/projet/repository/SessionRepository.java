package com.formation.projet.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.formation.projet.entities.*;

@Repository

public interface SessionRepository extends JpaRepository<Session, Long> {
	 public  Session  findById(long id);
	
	boolean existsById(Long id);

}
