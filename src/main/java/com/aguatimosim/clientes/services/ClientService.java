package com.aguatimosim.clientes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Transactional(readOnly = true)
    public Page<ClientDTO> findAll(Pageable pageable)   {
        Page<Client> cliente = repository.findAll(pageable);
        return cliente.map(x -> new ClientDTO(x));
    }

    @Transactional
    public ClientDTO insert(ClientDTO dto) {
        Client cliente = new Client();
        copyDtoToTabela(dto, cliente);
        return new ClientDTO(repository.save(cliente));
    }

    private void copyDtoToTabela(ClientDTO dto, Client cliente) {
        cliente.setName(dto.getName());
        cliente.setCpf(dto.getCpf());
        cliente.setIncome(dto.getIncome());
        cliente.setBirthDate(dto.getBirthDate());
        cliente.setChildren(dto.getChildren());
    }

}
