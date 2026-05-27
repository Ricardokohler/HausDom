package com.imobiliaria.imobiliaria.entities.dtos;

import com.imobiliaria.imobiliaria.entities.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConsultantDto {

        private Long id;
        private String name;
        private String phone;
        private String address;

        private List<Order> orderList;
}
