package com.imobiliaria.imobiliaria.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name= "tb_consultants")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Consultant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String phone;
    private String address;
    private double salary;

    @OneToMany(mappedBy = "consultant")
    private List<Order> orderList;

    public Consultant(Long id, String name, String phone, String address, double salary) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.salary = salary;
    }
}
