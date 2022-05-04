package com.api.api_user.domain.service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.api.api_user.domain.dto.ClienteDTO;
import com.api.api_user.domain.dto.ResponseDto;
import com.api.api_user.domain.entity.Cliente;
import com.api.api_user.domain.enumeration.Status;
import com.api.api_user.domain.repository.ClienteRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClienteService {
    
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ResponseDto responseDto; 

    ClienteRepository clienteRepository;

    public ResponseDto saveClient(Cliente cliente) {
        responseDto.setId(clienteRepository.save(cliente).getId());
        responseDto.setMenssage("Cliente incluido com sucesso");
        responseDto.setStatus(Status.SUCCESS.value());
        return responseDto;
    }

    public List<ClienteDTO> getAllClient() {
        List<ClienteDTO> listAllClients = clienteRepository.findAll().stream().map(Cliente -> modelMapper.map(Cliente, ClienteDTO.class)).collect(Collectors.toList());
        return listAllClients;
    }

    public ClienteDTO getClienteById(Long id) {
        return modelMapper.map(clienteRepository.findById(id).get(), ClienteDTO.class);
    }

    public ResponseDto updateCliente(Cliente cliente) {
        // responseDto.setId(userRepository.save(user).getId());
        if (cliente.getId() > 0) {
            this.clienteRepository.findById(cliente.getId()).get();
            clienteRepository.save(cliente);
            responseDto.setMenssage("Cliente alterado com sucesso...");
            responseDto.setStatus(Status.SUCCESS.value());
        } else {
            responseDto.setMenssage("ID do Cliente inválido...");
            responseDto.setStatus(Status.ERROR.value());
        }
        return responseDto;
    }

    public ResponseDto deleteUser(Long id) {
        responseDto.setId(id);
        if (id > 0) {
            clienteRepository.deleteById(id);
            responseDto.setMenssage("Cliente deletado com sucesso...");
            responseDto.setStatus(Status.SUCCESS.value());
        } else {
            responseDto.setMenssage("ID do Cliente inválido...");
            responseDto.setStatus(Status.ERROR.value());
        }
        return responseDto;
    }
}
