package com.formation.projet.controller;


import java.util.List;

import com.formation.projet.entities.Participant;
import com.formation.projet.repository.FormationRepository;
import com.formation.projet.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.formation.projet.entities.Organisme;
import com.formation.projet.entities.Session;
import com.formation.projet.response.MessageResponse;
import com.formation.projet.service.SessionServiceImpl;


@RestController
@CrossOrigin("*")
@RequestMapping("/session")
public class SessionController {

	@Autowired
    private SessionServiceImpl sessionService;
    @Autowired
    private SessionRepository sessionRepository;

    @Autowired
    private FormationRepository formationRepository;

    @PostMapping("/{formationId}")
    @PreAuthorize("hasRole('ROLE_USER') ")
    public ResponseEntity<Session> add(@PathVariable(value = "formationId") Long formationId,
                                          @RequestBody Session sessionRequest) {
        Session session = formationRepository.findById(formationId).map(formation -> {
            long sessionId = sessionRequest.getId();
            // session exsist déja
            if (sessionId != 0L) {
                Session _session = sessionRepository.findById(sessionId);
                //.orElseThrow(() -> new IllegalStateException("Not found session with id = " + sessionId));
                formation.getSession().add(_session);
                formationRepository.save(formation);
                return _session;
            }
            //  add and create new session
            // formation.getSession().add(sessionRequest);
            // return sessionRepository.save(sessionRequest);
            return null;
              }).orElseThrow(() -> new IllegalStateException("Not found formation with id = " + formationId));

     return new ResponseEntity<>(session, HttpStatus.CREATED);

    }
	
    @GetMapping

    public List<Session> findAll() {
        return sessionService.findAll();
    }
	
	 @PostMapping
     @PreAuthorize("hasRole('ROLE_USER') ")
    public MessageResponse save(@RequestBody Session session) {
		 return sessionService.save(session);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_USER') ")
    public MessageResponse update(@PathVariable int id, @RequestBody Session session) {
    	return sessionService.update(id, session);
    }
    @PutMapping
    @PreAuthorize("hasRole('ROLE_USER') ")
    public ResponseEntity<Session> updateEmployee(@RequestBody Session session) {
        Session update = sessionService.updateSession(session);
        return new ResponseEntity<>(update, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_USER') ")
    public MessageResponse delete(@PathVariable int id) {
    	return sessionService.delete(id);
    }
    
    @GetMapping("/{id}")

    public Session findById(@PathVariable long id) {
        return sessionService.findById(id);
    }

	
}
