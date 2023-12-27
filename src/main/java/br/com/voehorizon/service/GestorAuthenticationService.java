package br.com.voehorizon.service;

import br.com.voehorizon.repository.GestorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GestorAuthenticationService {

    @Autowired
    private GestorRepository gestorRepository;

}
