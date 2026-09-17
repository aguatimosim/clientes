package com.aguatimosim.clientes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aguatimosim.clientes.dto.ClientDTO;
import com.aguatimosim.clientes.services.ClientService;

@RestController
@RequestMapping(value = "/clientes")
public class ClientController {

    @Autowired 
    private ClientService cliente;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClientDTO> findById(@PathVariable Long id)   {
        ClientDTO dto = cliente.findById(id);
        return ResponseEntity.ok(dto);
    }
}
