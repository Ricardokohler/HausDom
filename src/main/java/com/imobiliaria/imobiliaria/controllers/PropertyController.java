package com.imobiliaria.imobiliaria.controllers;

import com.imobiliaria.imobiliaria.entities.Property;
import com.imobiliaria.imobiliaria.entities.dtos.PropertyDto;
import com.imobiliaria.imobiliaria.services.PropertyService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/properties")
public class PropertyController {

    @Autowired
    private PropertyService service;


    //Create
    @PostMapping("/add")
    public ResponseEntity <PropertyDto> create(@RequestBody PropertyDto propertyDto) {
        PropertyDto createdProperty = service.create(propertyDto);

        return new ResponseEntity<>(createdProperty, HttpStatus.CREATED);
    }


    //Get All
    @GetMapping("/all")
    public ResponseEntity <List<PropertyDto>> getAll(){
        List <PropertyDto> allProperties = service.getAll();

        return new ResponseEntity<>(allProperties, HttpStatus.OK);
    }


    //Get By Id
    @GetMapping("/{id}")
    public ResponseEntity <?> getById(@PathVariable Long id){
        PropertyDto optionalProperty = service.getById(id);

        if (optionalProperty != null) {

            return new ResponseEntity<>(optionalProperty, HttpStatus.OK);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado");
        }
    }


    //Delete By Id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity <String> delete(@PathVariable Long id){
        PropertyDto deletedProperty = service.getById(id);

        if(deletedProperty!= null){
            service.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Property successfully deleted");

        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado");
        }
    }


    //Update By Id
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody PropertyDto propertyDto){

        try{
            PropertyDto updatedProperty = service.update(id, propertyDto);
            return new ResponseEntity<>(updatedProperty, HttpStatus.OK);

        } catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado");
        }
    }


}
