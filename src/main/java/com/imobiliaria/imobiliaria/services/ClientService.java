package com.imobiliaria.imobiliaria.services;

import com.imobiliaria.imobiliaria.entities.Client;
import com.imobiliaria.imobiliaria.entities.dtos.ClientDto;
import com.imobiliaria.imobiliaria.entities.mappers.ClientMapper;
import com.imobiliaria.imobiliaria.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;


    //Create
    public ClientDto create(ClientDto clientDto){
        Client client = ClientMapper.map(clientDto);

        client = repository.save(client);
        return ClientMapper.map(client);
    }


    //Get All
    public List <ClientDto> getAll(){
        List<Client> clientList = repository.findAll();

        return clientList.stream()
                .map(ClientMapper :: map)
                .collect(Collectors.toList());
    }


    //Get By Id
    public ClientDto  getById (Long id){
        Optional <Client> optionalClient = repository.findById(id);

        return optionalClient.map(ClientMapper :: map).orElse(null);
    }


    //Update
    public ClientDto update(Long id, ClientDto clientDto){
        Optional <Client> oldClient = repository.findById(id);

        if(oldClient.isPresent()){
            Client newClient = ClientMapper.map(clientDto);

            newClient.setAddress(clientDto.getAddress());
            newClient.setName(clientDto.getName());
            newClient.setAddress(clientDto.getAddress());
            newClient.setAnualIncome(clientDto.getAnualIncome());

            repository.save(newClient);
            return ClientMapper.map(newClient);

        } else {
            throw new RuntimeException("Id não encontrado");
        }
    }


    //Delete
    public void deleteById(Long id){
        repository.deleteById(id);
    }

}
