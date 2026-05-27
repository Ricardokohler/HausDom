package com.imobiliaria.imobiliaria.controllers;

import com.imobiliaria.imobiliaria.entities.Consultant;
import com.imobiliaria.imobiliaria.entities.dtos.ConsultantDto;
import com.imobiliaria.imobiliaria.services.ConsultantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/consultants")
public class RealStateConsultantController {

    @Autowired
    private ConsultantService service;


    //Create
    @PostMapping("/add")
    public ResponseEntity <ConsultantDto> create(@RequestBody ConsultantDto consultantDto) {
        ConsultantDto createdConsultant = service.create(consultantDto);

        return new ResponseEntity<>(createdConsultant, HttpStatus.CREATED);
    }


    //Get All
    @GetMapping("/all")
    public ResponseEntity <List<ConsultantDto>> getAll(){
        List <ConsultantDto> allProperties = service.getAll();

        return new ResponseEntity<>(allProperties, HttpStatus.OK);
    }



    //Get By Id
    @GetMapping("/{id}")
    public ResponseEntity <?> getById(@PathVariable Long id){
        ConsultantDto consultantDto = service.getById(id);

        if (consultantDto != null) {
            return new ResponseEntity<>(consultantDto, HttpStatus.OK);

        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado");
        }
    }



    //Update By Id
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody ConsultantDto consultantDto){

        try{
            ConsultantDto updatedConsultant = service.update(id, consultantDto);
            return new ResponseEntity<>(updatedConsultant, HttpStatus.OK);

        } catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado");
        }
    }


    //Delete By Id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity <String> delete(@PathVariable Long id){
        ConsultantDto deletedConsultant = service.getById(id);

        if(deletedConsultant != null){
            service.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("RealStateConsultant successfully deleted");

        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado");
        }
    }


}
