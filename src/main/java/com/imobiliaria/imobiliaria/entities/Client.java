package com.imobiliaria.imobiliaria.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name="TB_CLIENTS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String phone;
    private String address;
    private Double anualIncome;

    @OneToMany(mappedBy = "client")
    private List<Order> orderList;


    public Client(Long id, String name, String phone,String address, Double anualIncome) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.anualIncome = anualIncome;
    }
}
