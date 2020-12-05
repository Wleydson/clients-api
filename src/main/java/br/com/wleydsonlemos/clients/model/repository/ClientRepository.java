package br.com.wleydsonlemos.clients.model.repository;

import br.com.wleydsonlemos.clients.model.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}
