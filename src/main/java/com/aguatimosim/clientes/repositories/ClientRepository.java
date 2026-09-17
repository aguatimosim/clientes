package com.aguatimosim.clientes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aguatimosim.clientes.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
