package br.com.wleydsonlemos.clients.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
public class Services {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 200)
    private String description;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    private BigDecimal value;
}
