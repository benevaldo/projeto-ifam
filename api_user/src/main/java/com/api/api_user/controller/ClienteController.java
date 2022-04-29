package com.api.api_user.controller;

import java.util.List;

import com.api.api_user.domain.dto.ClienteDTO;
import com.api.api_user.domain.dto.ResponseDto;
import com.api.api_user.domain.dto.UserDto;
import com.api.api_user.domain.entity.Cliente;
import com.api.api_user.domain.repository.ClienteRepository;
import com.api.api_user.domain.service.ClienteService;
import org.springframework.http.HttpStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@AllArgsConstructor
@RequestMapping("/cliente")
public class ClienteController {
    
    @Autowired
    private ClienteService clienteService;

    @PostMapping() //http://localhost:8080/cliente/
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseDto postMethodName(@RequestBody Cliente cliente) {
        return this.clienteService.saveClient(cliente);
    }
    
    @GetMapping(value = "/clientelist") // http://localhost:8080/cliente/clientelist
        public List<ClienteDTO> getAllUser() {
        return clienteService.getAllClient();
    }

    @GetMapping(value = "/{id}")
    public ClienteDTO getUserById(@PathVariable Long id) {
        return clienteService.getClienteById(id);
    }

    @PutMapping
    public ResponseDto updateUser(@RequestBody Cliente cliente) {
      return clienteService.updateCliente(cliente);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseDto deleteUser(@PathVariable Long id) {
      return clienteService.deleteUser(id);
    }
}
