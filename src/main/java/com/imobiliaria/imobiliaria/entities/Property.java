package com.imobiliaria.imobiliaria.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tb_imoveis")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String address;
    private double price;

    @JsonIgnore
    @OneToOne(mappedBy = "property")
    private Order order;

    public Property(Long id, String title, String address, double price) {
        this.id = id;
        this.title = title;
        this.address = address;
        this.price = price;
    }
}
