package com.imobiliaria.imobiliaria.services;

import com.imobiliaria.imobiliaria.entities.Order;
import com.imobiliaria.imobiliaria.entities.dtos.OrderDto;
import com.imobiliaria.imobiliaria.entities.mappers.OrderMapper;
import com.imobiliaria.imobiliaria.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;


    //Create
    public OrderDto create(OrderDto orderDto){
        Order order = OrderMapper.map(orderDto);

        order = repository.save(order);
        return OrderMapper.map(order);
    }


    //Get All
    public List <OrderDto> getAll(){
        List <Order> orderList = repository.findAll();

        return orderList.stream()
                .map(OrderMapper :: map)
                .collect(Collectors.toList());
    }


    //Get By Id
    public OrderDto getById (Long id){
        Optional<Order> optionalOrder = repository.findById(id);

        return optionalOrder.map(OrderMapper :: map).orElse(null);
    }


    //Update
    public OrderDto update(Long id, OrderDto orderDto){
        Optional <Order> oldOrder = repository.findById(id);

        if(oldOrder.isPresent()){
            Order newOrder = OrderMapper.map(orderDto);

            newOrder.setClient(orderDto.getClient());
            newOrder.setConsultant(orderDto.getConsultant());
            newOrder.setObservations(orderDto.getObservations());

            repository.save(newOrder);
            return OrderMapper.map(newOrder);

        } else {
            throw new RuntimeException("Id não encontrado");
        }
    }


    //Delete
    public void deleteById(Long id){
        repository.deleteById(id);
    }


}
