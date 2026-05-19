package com.imobiliaria.imobiliaria.services;

import com.imobiliaria.imobiliaria.entities.Consultant;
import com.imobiliaria.imobiliaria.repositories.RealStateConsultantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RealStateConsultantService {

    @Autowired
    private RealStateConsultantRepository repository;


    //Create
    public Consultant create(Consultant Consultant){
        return repository.save(Consultant);
    }

    //Get All
    public List <Consultant> getAll(){
        return repository.findAll();
    }



    //Get By Id
    public Optional <Consultant> getById (Long id){
        return repository.findById(id);

    }



    //Delete
    public void deleteById(Long id){
        repository.deleteById(id);
    }



    //Update
    public Consultant update(Long id, Consultant Consultant){
        Optional <Consultant> oldRealStateConsultant = repository.findById(id);

        if(oldRealStateConsultant.isPresent()){
            Consultant newConsultant = oldRealStateConsultant.get();

            newConsultant.setName(Consultant.getName());
            newConsultant.setAddress(Consultant.getAddress());
            newConsultant.setPhone(Consultant.getPhone());

            return repository.save(newConsultant);

        } else {
            throw new RuntimeException("Id não encontrado");
        }


    }

}
