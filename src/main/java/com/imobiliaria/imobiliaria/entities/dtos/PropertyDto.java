package com.imobiliaria.imobiliaria.entities.dtos;

import com.imobiliaria.imobiliaria.entities.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropertyDto {

    private Long id;
    private String title;
    private String address;
    private Double price;
    private List<Order> orderList;

}
