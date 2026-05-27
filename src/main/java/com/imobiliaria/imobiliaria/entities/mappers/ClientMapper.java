package com.imobiliaria.imobiliaria.entities.mappers;

import com.imobiliaria.imobiliaria.entities.Client;
import com.imobiliaria.imobiliaria.entities.dtos.ClientDto;

public class ClientMapper {

    public static Client map(ClientDto dto){

        Client client = new Client();
        if(dto.getId() != null) {
            client.setId(dto.getId());
        }

        client.setName(dto.getName());
        client.setPhone(dto.getPhone());
        client.setAddress(dto.getAddress());
        client.setAnualIncome(dto.getAnualIncome());

        client.setOrderList(dto.getOrderList());

        return client;
    }

    public static ClientDto map(Client client){

        ClientDto dto = new ClientDto();

        dto.setId(client.getId());
        dto.setName(client.getName());
        dto.setPhone(client.getPhone());
        dto.setAddress(client.getAddress());
        dto.setAnualIncome(client.getAnualIncome());

        dto.setOrderList(client.getOrderList());

        return dto;
    }

}
