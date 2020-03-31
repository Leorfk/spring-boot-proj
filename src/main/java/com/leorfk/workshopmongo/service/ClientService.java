package com.leorfk.workshopmongo.service;

import com.leorfk.workshopmongo.domain.Client;
import com.leorfk.workshopmongo.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> findAll(){
        return clientRepository.findAll();
    }
}
