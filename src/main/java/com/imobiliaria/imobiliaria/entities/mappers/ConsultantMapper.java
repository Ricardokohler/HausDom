package com.imobiliaria.imobiliaria.entities.mappers;

import com.imobiliaria.imobiliaria.entities.Consultant;
import com.imobiliaria.imobiliaria.entities.dtos.ConsultantDto;

public class ConsultantMapper {

    public static Consultant map(ConsultantDto dto){

        Consultant Consultant = new Consultant();
        if(dto.getId() != null) {
            Consultant.setId(dto.getId());
        }

        Consultant.setName(dto.getName());
        Consultant.setPhone(dto.getPhone());
        Consultant.setAddress(dto.getAddress());
       
        Consultant.setOrderList(dto.getOrderList());

        return Consultant;
    }
    
    public static ConsultantDto map(Consultant consultant){
        
        ConsultantDto dto = new ConsultantDto();
        
        dto.setId(consultant.getId());
        dto.setName(consultant.getName());
        dto.setPhone(consultant.getPhone());
        dto.setAddress(consultant.getAddress());
        
        dto.setOrderList(consultant.getOrderList());
        
        return dto;
    }

}
