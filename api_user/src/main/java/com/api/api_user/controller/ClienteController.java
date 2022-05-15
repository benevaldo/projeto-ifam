package com.api.api_user.controller;

import java.util.List;

import javax.validation.Valid;

import com.api.api_user.domain.dto.ClienteDto;
import com.api.api_user.domain.dto.ResponseDto;
import com.api.api_user.domain.entity.Cliente;
import com.api.api_user.domain.service.ClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/cliente")
public class ClienteController {

  @Autowired
  private ClienteService clienteService;
  
  @PostMapping //http://localhost:8080/user/
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseDto saveUser(@Valid @RequestBody Cliente cliente) {
    return clienteService.saveCliente(cliente);
  }

  @GetMapping(value = "/list") // http://localhost:8080/user/list
  public List<ClienteDto> getAllUser() {
    return clienteService.getAllClienteOrderByName();
  }

  @GetMapping(value = "/{id}")
  public ClienteDto getUserById(@Valid @PathVariable Long id) {
    return clienteService.getClienteById(id);
  }

  @PutMapping
  public ResponseDto updateCliente(@Valid @RequestBody Cliente cliente) {
    return clienteService.updateCliente(cliente);
  }
   
  @DeleteMapping(value = "/{id}")
  public ResponseDto deleteCliente(@Valid @PathVariable Long id) {
    return clienteService.deleteCliente(id);
  }

  @PostMapping(value = "/validarLogin/{login}/{password}")
  public ClienteDto validateLogin(@Valid @PathVariable String login, @PathVariable String password) {
    return clienteService.validateLogin(login, password);
  }
}