package com.imobiliaria.imobiliaria.entities.dtos;

import com.imobiliaria.imobiliaria.entities.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDto{

        private Long id;
        private String name;
        private String phone;
        private String address;
        private Double anualIncome;

        private List<Order> orderList;
}
