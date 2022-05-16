package com.api.api_user.domain.repository;

import com.api.api_user.domain.entity.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClienteRepository extends JpaRepository<Cliente,Long>  {

    @Query("SELECT c FROM Cliente c WHERE c.login = ?1 and c.senha = ?2")
    Cliente findClienteByLoginAndPassword(String login, String password);
}
