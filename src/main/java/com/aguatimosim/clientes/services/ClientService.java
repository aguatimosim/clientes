package com.aguatimosim.clientes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aguatimosim.clientes.dto.ClientDTO;
import com.aguatimosim.clientes.entities.Client;
import com.aguatimosim.clientes.repositories.ClientRepository;

@Service 
public class ClientService {

    @Autowired 
    private ClientRepository repository;

    @Transactional(readOnly = true)
    public ClientDTO findById(Long id)    {
        Client cliente = repository.findById(id).get();
        return new ClientDTO(cliente);
    }

}
