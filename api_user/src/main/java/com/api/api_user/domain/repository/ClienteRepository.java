package com.api.api_user.domain.repository;

import com.api.api_user.domain.entity.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {
    
}
