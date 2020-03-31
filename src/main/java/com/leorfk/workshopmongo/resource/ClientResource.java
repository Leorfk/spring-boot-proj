package com.leorfk.workshopmongo.resource;

import com.leorfk.workshopmongo.domain.Client;
import com.leorfk.workshopmongo.dto.ClientDTO;
import com.leorfk.workshopmongo.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/client")
public class ClientResource {

    @Autowired
    private ClientService clientService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<ClientDTO>> findAll(){
        List<Client> clients = clientService.findAll();
        List<ClientDTO> clientDTOs = clients.stream().map(x -> new ClientDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok(clientDTOs);
    }

}
