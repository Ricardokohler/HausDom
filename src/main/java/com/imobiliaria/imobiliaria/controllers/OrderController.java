package com.imobiliaria.imobiliaria.controllers;

import com.imobiliaria.imobiliaria.entities.Order;
import com.imobiliaria.imobiliaria.entities.dtos.OrderDto;
import com.imobiliaria.imobiliaria.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService service;


    //Create
    @PostMapping("/add")
    public ResponseEntity <OrderDto> create(@RequestBody OrderDto OrderDto) {
        OrderDto createdOrder = service.create(OrderDto);

        return new ResponseEntity<>(createdOrder, HttpStatus.CREATED);
    }


    //Get All
    @GetMapping("/all")
    public ResponseEntity <List<OrderDto>> getAll(){
        List <OrderDto> propertieList = service.getAll();

        return new ResponseEntity<>(propertieList, HttpStatus.OK);
    }



    //Get By Id
    @GetMapping("/{id}")
    public ResponseEntity <?> getById(@PathVariable Long id){
        OrderDto orderDto = service.getById(id);

        if (orderDto != null) {
            return new ResponseEntity<>(orderDto, HttpStatus.OK);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado");
        }
    }


    //Update By Id
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody OrderDto orderDto){

        try{
            OrderDto updatedOrder = service.update(id, orderDto);
        return new ResponseEntity<>(updatedOrder, HttpStatus.OK);

        } catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado");
        }
    }



    //Delete By Id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity <String> delete(@PathVariable Long id){
        OrderDto deletedOrder = service.getById(id);

        if(deletedOrder != null){
            service.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Order successfully deleted");

        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado");
        }
    }

}
