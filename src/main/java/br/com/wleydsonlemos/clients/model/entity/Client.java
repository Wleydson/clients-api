package br.com.wleydsonlemos.clients.model.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @Column(nullable = false, length = 200)
    @NotEmpty(message = "{fiel.name.required}")
    private String name;

    @Column(nullable = false, length = 14)
    @NotNull(message = "{fiel.cpf.required}")
    @CPF(message = "{fiel.cpf.invalid}")
    private String cpf;

    @Column(nullable = false, length = 150)
    @NotEmpty
    private String email;

    @Column
    private String phone;

    @Column(name = "data_register", nullable = false, updatable = false)
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dateRegister;

    @Column(name = "data_updated")
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dateUpdated;

    @Column(nullable = false)
    private boolean active;

    @PrePersist
    public void prePersist(){
        setActive(true);
        setDateRegister(LocalDateTime.now());
    }

    @PreUpdate
    public void preUpdate(){
        setDateUpdated(LocalDateTime.now());
    }
}
