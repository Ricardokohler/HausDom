package com.imobiliaria.imobiliaria.entities.mappers;

import com.imobiliaria.imobiliaria.entities.Property;
import com.imobiliaria.imobiliaria.entities.dtos.PropertyDto;

public class PropertyMapper {

    public static Property map(PropertyDto dto){

        Property property = new Property();
        if(dto.getId() != null) {
            property.setId(dto.getId());
        }

        property.setTitle(dto.getTitle());
        property.setAddress(dto.getAddress());
        property.setPrice(dto.getPrice());

        property.setOrderList(dto.getOrderList());
        return property;
    }
    
    public static PropertyDto map(Property property){
        
        PropertyDto dto = new PropertyDto();
        
        dto.setId(property.getId());
        dto.setTitle(property.getTitle());
        dto.setAddress(property.getAddress());
        dto.setPrice(property.getPrice());

        dto.setOrderList(property.getOrderList());
        return dto;
    }

}
