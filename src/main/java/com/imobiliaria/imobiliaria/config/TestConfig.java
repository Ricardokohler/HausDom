package com.imobiliaria.imobiliaria.config;

import com.imobiliaria.imobiliaria.entities.Client;
import com.imobiliaria.imobiliaria.entities.Consultant;
import com.imobiliaria.imobiliaria.entities.Order;
import com.imobiliaria.imobiliaria.entities.Property;
import com.imobiliaria.imobiliaria.repositories.ClientRepository;
import com.imobiliaria.imobiliaria.repositories.OrderRepository;
import com.imobiliaria.imobiliaria.repositories.PropertyRepository;
import com.imobiliaria.imobiliaria.repositories.RealStateConsultantRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;
import java.util.List;

@Configuration
@Profile("h2")
public class TestConfig implements CommandLineRunner {

    private final ClientRepository clientRepository;
    private final PropertyRepository propertyRepository;
    private final RealStateConsultantRepository realStateConsultantRepository;
    private final OrderRepository orderRepository;

    public TestConfig(ClientRepository clientRepository, PropertyRepository propertyRepository, RealStateConsultantRepository realStateConsultantRepository, OrderRepository orderRepository) {
        this.clientRepository = clientRepository;
        this.propertyRepository = propertyRepository;
        this.realStateConsultantRepository = realStateConsultantRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        // Clients
        Client c1 = new Client(null, "Juvenal da Silva", "4622-3955", "Rua das Garças, 25", 50000.87);
        Client c2 = new Client(null, "Sophia Ramos Nogueira", "7622-3846", "Rua do Bexiga, 46", 192000.98);
        Client c3 = new Client(null, "Carlos Henrique Souza", "9123-4567", "Rua das Flores, 10", 85000.00);
        Client c4 = new Client(null, "Fernanda Lima", "9987-1234", "Av. Brasil, 115", 120000.00);
        Client c5 = new Client(null, "Marcos Oliveira", "9874-5566", "Rua das Acácias, 58", 43000.50);
        Client c6 = new Client(null, "Ana Paula Mendes", "9963-4785", "Rua dos Ipês, 72", 278000.00);
        Client c7 = new Client(null, "Ricardo Gomes", "9345-7654", "Rua Central, 900", 66000.25);
        Client c8 = new Client(null, "Camila Ferreira", "9654-3421", "Rua Bahia, 56", 150000.00);
        Client c9 = new Client(null, "Lucas Almeida", "9234-7658", "Rua Paraná, 441", 99000.90);
        Client c10 = new Client(null, "Amanda Costa", "9765-1238", "Rua Amazonas, 302", 210000.00);
        Client c11 = new Client(null, "Paulo Ricardo", "9346-8821", "Rua XV de Novembro, 55", 75000.00);
        Client c12 = new Client(null, "Juliana Teixeira", "9127-6678", "Rua Tiradentes, 97", 181000.45);
        Client c13 = new Client(null, "Bruno Carvalho", "9981-2234", "Rua das Palmeiras, 201", 56000.00);
        Client c14 = new Client(null, "Patricia Santos", "9345-9987", "Rua das Rosas, 88", 94000.32);
        Client c15 = new Client(null, "Diego Martins", "9871-6622", "Rua João Pessoa, 144", 135000.00);
        Client c16 = new Client(null, "Larissa Rodrigues", "9658-7744", "Rua Marechal, 65", 174500.80);
        Client c17 = new Client(null, "Gustavo Pereira", "9122-3411", "Rua das Oliveiras, 320", 89000.00);
        Client c18 = new Client(null, "Vanessa Almeida", "9987-6655", "Rua da Liberdade, 17", 245000.00);
        Client c19 = new Client(null, "Eduardo Ribeiro", "9233-4432", "Rua Horizonte, 510", 61000.90);
        Client c20 = new Client(null, "Marina Lopes", "9774-1199", "Rua do Sol, 42", 320000.00);

        clientRepository.saveAll(Arrays.asList(
                c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,
                c11,c12,c13,c14,c15,c16,c17,c18,c19,c20
        ));

        // Properties
        Property p1 = new Property(null, "Casa 4 quartos mobiliada", "Rua dos Pássaros, 35", 400000.00);
        Property p2 = new Property(null, "Apartamento 2 quartos", "Rua das Margaridas, 836", 1000726.26);
        Property p3 = new Property(null, "Sobrado 3 quartos", "Rua das Flores, 98", 580000.00);
        Property p4 = new Property(null, "Cobertura Duplex", "Av. Central, 145", 1450000.00);
        Property p5 = new Property(null, "Kitnet mobiliada", "Rua Alfa, 12", 190000.00);
        Property p6 = new Property(null, "Casa com piscina", "Rua Beta, 88", 760000.00);
        Property p7 = new Property(null, "Apartamento luxo", "Av. Beira Mar, 10", 2100000.00);
        Property p8 = new Property(null, "Chácara", "Estrada Velha, km 5", 980000.00);
        Property p9 = new Property(null, "Terreno 500m²", "Rua das Acácias, 45", 220000.00);
        Property p10 = new Property(null, "Casa geminada", "Rua Cedro, 18", 340000.00);
        Property p11 = new Property(null, "Apartamento Studio", "Rua Limoeiro, 71", 280000.00);
        Property p12 = new Property(null, "Casa de condomínio", "Condomínio Primavera", 890000.00);
        Property p13 = new Property(null, "Loft moderno", "Rua dos Pinheiros, 14", 530000.00);
        Property p14 = new Property(null, "Casa 2 dormitórios", "Rua Vitória, 91", 310000.00);
        Property p15 = new Property(null, "Sítio", "Zona Rural", 1200000.00);
        Property p16 = new Property(null, "Galpão Comercial", "Distrito Industrial", 1700000.00);
        Property p17 = new Property(null, "Sala Comercial", "Centro, 120", 390000.00);
        Property p18 = new Property(null, "Apartamento cobertura", "Av. Atlântica, 455", 1650000.00);
        Property p19 = new Property(null, "Casa térrea", "Rua Goiás, 77", 450000.00);
        Property p20 = new Property(null, "Terreno esquina", "Rua Paraná, 210", 270000.00);

        propertyRepository.saveAll(Arrays.asList(
                p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,
                p11,p12,p13,p14,p15,p16,p17,p18,p19,p20
        ));

        // Consultants
        Consultant consultant1 = new Consultant(null, "José Clodoaldo de Maria", "93826-2735", "Rua da Glória, 6452", 4000.37);
        Consultant consultant2 = new Consultant(null, "Claudemir Osias Marques", "2736-2715", "Rua dos Petecos, 2615", 8000.23);
        Consultant consultant3 = new Consultant(null, "Renato Alves", "9345-1122", "Rua Azul, 45", 5200.00);
        Consultant consultant4 = new Consultant(null, "Patrícia Gomes", "9655-3344", "Rua Verde, 12", 6100.00);
        Consultant consultant5 = new Consultant(null, "Daniel Souza", "9777-8899", "Rua Vermelha, 88", 4900.00);
        Consultant consultant6 = new Consultant(null, "Camila Ribeiro", "9444-5566", "Rua Ouro, 32", 7300.00);
        Consultant consultant7 = new Consultant(null, "Fernando Lima", "9555-2211", "Rua Prata, 17", 6800.00);
        Consultant consultant8 = new Consultant(null, "Amanda Nunes", "9666-8877", "Rua Bronze, 54", 7200.00);
        Consultant consultant9 = new Consultant(null, "Lucas Fernandes", "9111-7744", "Rua do Lago, 81", 5900.00);
        Consultant consultant10 = new Consultant(null, "Roberta Castro", "9222-9911", "Rua dos Coqueiros, 96", 8100.00);
        Consultant consultant11 = new Consultant(null, "Marcelo Rocha", "9333-1188", "Rua Primavera, 33", 5700.00);
        Consultant consultant12 = new Consultant(null, "Tatiane Costa", "9445-6611", "Rua Outono, 18", 6400.00);
        Consultant consultant13 = new Consultant(null, "Vinicius Prado", "9554-3377", "Rua Inverno, 71", 6900.00);
        Consultant consultant14 = new Consultant(null, "Sandra Lopes", "9667-7788", "Rua Verão, 44", 7500.00);
        Consultant consultant15 = new Consultant(null, "Thiago Almeida", "9771-2211", "Rua Bela Vista, 23", 5600.00);
        Consultant consultant16 = new Consultant(null, "Vanessa Moura", "9888-1144", "Rua Bela Esperança, 87", 6600.00);
        Consultant consultant17 = new Consultant(null, "Pedro Henrique", "9999-5555", "Rua Horizonte, 91", 7100.00);
        Consultant consultant18 = new Consultant(null, "Juliana Faria", "9112-9898", "Rua Aurora, 65", 6200.00);
        Consultant consultant19 = new Consultant(null, "Guilherme Barbosa", "9223-8787", "Rua Diamante, 37", 6800.00);
        Consultant consultant20 = new Consultant(null, "Melissa Duarte", "9334-7676", "Rua Safira, 120", 8400.00);

        realStateConsultantRepository.saveAll(Arrays.asList(
                consultant1,consultant2,consultant3,consultant4,consultant5,
                consultant6,consultant7,consultant8,consultant9,consultant10,
                consultant11,consultant12,consultant13,consultant14,consultant15,
                consultant16,consultant17,consultant18,consultant19,consultant20
        ));

        // Orders
        Order o1 = new Order(null, "Cliente pagou à vista", consultant1, c1);
        Order o2 = new Order(null, "Ficou faltando uma chave", consultant2, c2);
        Order o3 = new Order(null, "Financiamento aprovado", consultant3, c3);
        Order o4 = new Order(null, "Aguardando assinatura", consultant4, c4);
        Order o5 = new Order(null, "Documentação em análise", consultant5, c5);
        Order o6 = new Order(null, "Visita agendada", consultant6, c6);
        Order o7 = new Order(null, "Contrato enviado", consultant7, c7);
        Order o8 = new Order(null, "Pagamento da entrada realizado", consultant8, c8);
        Order o9 = new Order(null, "Cliente desistiu temporariamente", consultant9, c9);
        Order o10 = new Order(null, "Negociação concluída", consultant10, c10);
        Order o11 = new Order(null, "Aguardando financiamento", consultant11, c11);
        Order o12 = new Order(null, "Proposta aceita", consultant12, c12);
        Order o13 = new Order(null, "Documentos pendentes", consultant13, c13);
        Order o14 = new Order(null, "Imóvel reservado", consultant14, c14);
        Order o15 = new Order(null, "Contrato registrado", consultant15, c15);
        Order o16 = new Order(null, "Cliente solicitou alterações", consultant16, c16);
        Order o17 = new Order(null, "Entrega das chaves marcada", consultant17, c17);
        Order o18 = new Order(null, "Venda concluída", consultant18, c18);
        Order o19 = new Order(null, "Em negociação", consultant19, c19);
        Order o20 = new Order(null, "Aguardando confirmação bancária", consultant20, c20);

        o1.setPropertieList(List.of(p1));
        o2.setPropertieList(List.of(p2));
        o3.setPropertieList(List.of(p3));
        o4.setPropertieList(List.of(p4));
        o5.setPropertieList(List.of(p5));
        o6.setPropertieList(List.of(p6));
        o7.setPropertieList(List.of(p7));
        o8.setPropertieList(List.of(p8));
        o9.setPropertieList(List.of(p9));
        o10.setPropertieList(List.of(p10));

        o11.setPropertieList(List.of(p11, p12));
        o12.setPropertieList(List.of(p13));
        o13.setPropertieList(List.of(p14, p15));
        o14.setPropertieList(List.of(p16));
        o15.setPropertieList(List.of(p17, p18));
        o16.setPropertieList(List.of(p19));
        o17.setPropertieList(List.of(p20));
        o18.setPropertieList(List.of(p1, p7));
        o19.setPropertieList(List.of(p5, p11));
        o20.setPropertieList(List.of(p3, p8, p15));
        orderRepository.saveAll(Arrays.asList(
                o1,o2,o3,o4,o5,o6,o7,o8,o9,o10,
                o11,o12,o13,o14,o15,o16,o17,o18,o19,o20
        ));
    }
}