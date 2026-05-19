package com.imobiliaria.imobiliaria.controllers;

import com.imobiliaria.imobiliaria.entities.Consultant;
import com.imobiliaria.imobiliaria.services.RealStateConsultantService;
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
    private RealStateConsultantService service;


    //Create
    @PostMapping("/add")
    public ResponseEntity <Consultant> create(@RequestBody Consultant Consultant) {
        Consultant createdConsultant = service.create(Consultant);

        return new ResponseEntity<>(createdConsultant, HttpStatus.CREATED);
    }


    @GetMapping("/all")
    public ResponseEntity <List<Consultant>> getAll(){
        List <Consultant> allProperties = service.getAll();

        return new ResponseEntity<>(allProperties, HttpStatus.OK);
    }



    @GetMapping("/{id}")
    public ResponseEntity <?> getById(@PathVariable Long id){
        Optional<Consultant> optionalRealStateConsultant = service.getById(id);

        if (optionalRealStateConsultant.isPresent()) {

            return new ResponseEntity<>(optionalRealStateConsultant, HttpStatus.OK);

        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado");
        }
    }



    @DeleteMapping("/delete/{id}")
    public ResponseEntity <String> delete(@PathVariable Long id){
        Optional <Consultant> deletedRealStateConsultant = service.getById(id);

        if(deletedRealStateConsultant.isPresent()){
            service.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("RealStateConsultant successfully deleted");

        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado");
        }
    }



    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Consultant Consultant){

        try{
        Consultant updatedConsultant = service.update(id, Consultant);
        return new ResponseEntity<>(updatedConsultant, HttpStatus.OK);

        } catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado");
        }
    }
}
