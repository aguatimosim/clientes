package com.aguatimosim.clientes.dto;

import java.time.LocalDate;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

import com.aguatimosim.clientes.entities.Client;

public class ClientDTO {

    private Long id;

    @NotBlank(message = "Campo requerido")
    private String name;
    
    private String cpf;
    private Double income;

    @PastOrPresent(message = "Data de nascimento não pode ser futura")
    private LocalDate birthDate;
    
    private Integer children;

    public ClientDTO() {
    }

    public ClientDTO(Client cliente) {
        id = cliente.getId();
        name = cliente.getName();
        cpf = cliente.getCpf();
        income = cliente.getIncome();
        birthDate = cliente.getBirthDate();
        children = cliente.getChildren();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public Double getIncome() {
        return income;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Integer getChildren() {
        return children;
    }

    
}
