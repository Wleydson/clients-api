package br.com.wleydsonlemos.clients.model.repository;

import br.com.wleydsonlemos.clients.model.entity.Services;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicesRepository extends JpaRepository<Services, Integer> {
}
