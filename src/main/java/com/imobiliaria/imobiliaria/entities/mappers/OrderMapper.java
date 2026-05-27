package com.imobiliaria.imobiliaria.entities.mappers;

import com.imobiliaria.imobiliaria.entities.Order;
import com.imobiliaria.imobiliaria.entities.dtos.OrderDto;

public class OrderMapper {

    public static Order map(OrderDto dto){

        Order order = new Order();
        if(dto.getId() != null) {
            order.setId(dto.getId());
        }

        order.setObservations(dto.getObservation());
        order.setPropertieList(dto.getProperiteList());
        order.setConsultant(dto.getConsultant());
        order.setClient(dto.getClient());

        return order;
    }
    
    public static OrderDto map(Order order){
        
        OrderDto dto = new OrderDto();
        
        dto.setId(order.getId());
        dto.setProperiteList(order.getPropertieList());

        dto.setObservation(order.getObservations());
        dto.setProperiteList(order.getPropertieList());
        dto.setConsultant(order.getConsultant());
        dto.setClient(order.getClient());

        return dto;
    }

}
