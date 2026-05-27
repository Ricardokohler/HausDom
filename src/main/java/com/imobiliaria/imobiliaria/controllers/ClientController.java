package com.imobiliaria.imobiliaria.controllers;

import com.imobiliaria.imobiliaria.entities.Client;
import com.imobiliaria.imobiliaria.entities.dtos.ClientDto;
import com.imobiliaria.imobiliaria.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService service;


    //Create
    @PostMapping("/add")
    public ResponseEntity <ClientDto> create(@RequestBody ClientDto clientDto) {
        ClientDto createdClient = service.create(clientDto);

        return new ResponseEntity<>(createdClient, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity <List<ClientDto>> getAll(){
        List <ClientDto> allProperties = service.getAll();

        return new ResponseEntity<>(allProperties, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity <?> getById(@PathVariable Long id){
       ClientDto clientDto = service.getById(id);

        if (clientDto != null) {

            return new ResponseEntity<>(clientDto, HttpStatus.OK);

        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity <String> delete(@PathVariable Long id){
       ClientDto deletedClient = service.getById(id);

        if(deletedClient != null){
            service.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Client successfully deleted");

        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado");
        }
    }



    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody ClientDto clientDto){

        try{
            ClientDto updatedClient = service.update(id, clientDto);
        return new ResponseEntity<>(updatedClient, HttpStatus.OK);

        } catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado");
        }
    }
}
