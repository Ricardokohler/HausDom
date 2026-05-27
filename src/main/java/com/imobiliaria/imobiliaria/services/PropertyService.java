package com.imobiliaria.imobiliaria.services;

import com.imobiliaria.imobiliaria.entities.Property;
import com.imobiliaria.imobiliaria.entities.dtos.PropertyDto;
import com.imobiliaria.imobiliaria.entities.mappers.ClientMapper;
import com.imobiliaria.imobiliaria.entities.mappers.PropertyMapper;
import com.imobiliaria.imobiliaria.repositories.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PropertyService {

    @Autowired
    private PropertyRepository repository;


    //Create
    public PropertyDto create(PropertyDto propertyDto){
        Property property = PropertyMapper.map(propertyDto);

        property = repository.save(property);
        return PropertyMapper.map(property);
    }


    //Get All
    public List <PropertyDto> getAll(){
        List<Property> propertyList = repository.findAll();

        return propertyList.stream()
                .map(PropertyMapper :: map)
                .collect(Collectors.toList());
    }


    //Get By Id
    public PropertyDto getById (Long id){
        Optional<Property> optionalProperty = repository.findById(id);

        return optionalProperty.map(PropertyMapper :: map).orElse(null);
    }


    //Update
    public PropertyDto update(Long id, PropertyDto propertyDto){
        Optional <Property> oldProperty = repository.findById(id);

        if(oldProperty.isPresent()){
            Property newProperty = PropertyMapper.map(propertyDto);

            newProperty.setAddress(propertyDto.getAddress());
            newProperty.setTitle(propertyDto.getTitle());
            newProperty.setPrice(propertyDto.getPrice());

            repository.save(newProperty);
            return PropertyMapper.map(newProperty);

        } else {
            throw new RuntimeException("Id não encontrado");
        }
    }


    //Delete
    public void deleteById(Long id){
        repository.deleteById(id);
    }


}
