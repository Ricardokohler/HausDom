package com.imobiliaria.imobiliaria.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="tb_pedidos")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String observations;

    @ManyToMany
    @JoinTable(name="tb_orders_properties", joinColumns = @JoinColumn(name = "Id_Order"), inverseJoinColumns = @JoinColumn(name = "id_propertie"))
    private List<Property> propertieList = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "Id_consultant")
    private Consultant consultant;

    @ManyToOne
    @JoinColumn(name = "id_client")
    private Client client;

    public Order() {
    }

    public Order(Long id, String observations, Consultant consultant, Client client) {
        this.id = id;
        this.observations = observations;
        this.consultant = consultant;
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public void setPropertieList(List<Property> propertieList) {
        this.propertieList = propertieList;
    }

    public List<Property> getPropertieList() {
        return propertieList;
    }

    public Consultant getConsultant() {
        return consultant;
    }

    public void setConsultant(Consultant consultant) {
        this.consultant = consultant;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
