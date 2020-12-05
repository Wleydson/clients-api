package br.com.wleydsonlemos.clients.model.entity;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @Column(nullable = false, length = 200)
    private String name;

    @Column(nullable = false, length = 11)
    private String cpf;

    @Column(nullable = false, length = 150)
    private String email;

    @Column
    private String phone;

    @Column(name = "data_register", nullable = false)
    private LocalDate dateRegister;
}
