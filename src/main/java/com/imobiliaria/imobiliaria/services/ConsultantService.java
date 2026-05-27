package com.imobiliaria.imobiliaria.services;

import com.imobiliaria.imobiliaria.entities.Consultant;
import com.imobiliaria.imobiliaria.entities.dtos.ConsultantDto;
import com.imobiliaria.imobiliaria.entities.mappers.ConsultantMapper;
import com.imobiliaria.imobiliaria.repositories.RealStateConsultantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ConsultantService {

    @Autowired
    private RealStateConsultantRepository repository;


    //Create
    public ConsultantDto create(ConsultantDto consultantDto){
        Consultant consultant = ConsultantMapper.map(consultantDto);

        consultant = repository.save(consultant);
        return ConsultantMapper.map(consultant);
    }


    //Get All
    public List <ConsultantDto> getAll(){
        List <Consultant> consultantList = repository.findAll();

        return consultantList.stream()
                .map(ConsultantMapper :: map)
                .collect(Collectors.toList());
    }


    //Get By Id
    public ConsultantDto getById (Long id){
        Optional<Consultant> optionalConsultant = repository.findById(id);

        return optionalConsultant.map(ConsultantMapper :: map).orElse(null);
    }


    //Update
    public ConsultantDto update(Long id, ConsultantDto consultantDto){
        Optional <Consultant> oldRealStateConsultant = repository.findById(id);

        if(oldRealStateConsultant.isPresent()){
            Consultant newConsultant = ConsultantMapper.map(consultantDto);

            newConsultant.setName(consultantDto.getName());
            newConsultant.setAddress(consultantDto.getAddress());
            newConsultant.setPhone(consultantDto.getPhone());

            repository.save(newConsultant);
            return ConsultantMapper.map(newConsultant);

        } else {
            throw new RuntimeException("Id não encontrado");
        }
    }


    //Delete
    public void deleteById(Long id){
        repository.deleteById(id);
    }

}
