package com.formation.projet.service;

import javax.transaction.Transactional;

import com.formation.projet.entities.CustomUserBean;
import com.formation.projet.entities.User;
import com.formation.projet.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username)
                .orElseThrow(() -> new UsernameNotFoundException("User with "
                        + "user name "+ username + " not found"));
        return CustomUserBean.createInstance(user);
    }
}