package com.imobiliaria.imobiliaria.entities.dtos;

import com.imobiliaria.imobiliaria.entities.Client;
import com.imobiliaria.imobiliaria.entities.Consultant;
import com.imobiliaria.imobiliaria.entities.Property;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {

    private Long id;
    private String observations;

    private List<Property> properiteList;
    private Consultant consultant;
    private Client client;


}