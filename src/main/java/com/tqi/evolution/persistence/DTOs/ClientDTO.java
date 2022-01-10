package com.tqi.evolution.persistence.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientDTO {
    private String name;
    private String email;
    private String cpf;
    private String rg;
    private double income;
    private String password;
}
