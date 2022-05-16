package com.api.api_user.domain.service;

import java.util.List;
import java.util.stream.Collectors;

import com.api.api_user.domain.dto.ClienteDto;
import com.api.api_user.domain.dto.ResponseDto;
import com.api.api_user.domain.entity.Cliente;
import com.api.api_user.domain.enumeration.Status;
import com.api.api_user.domain.repository.ClienteRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClienteService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ResponseDto responseDto;

    ClienteRepository clienteRepository;

    public ResponseDto saveCliente(Cliente cliente) {
        String url = "https://viacep.com.br/ws/" +
                cliente.getEndereco().getCep() + "/json/?callback=endereco";
        RestTemplate restTemplate = new RestTemplate();
        String CEP = restTemplate.getForObject(url, String.class);

        if (CEP.contains("erro")) {
            System.out.println(CEP.contains("entra aqui"));
            responseDto.setMenssage("CEP invalido");
            responseDto.setStatus(Status.ERROR.value());
            return responseDto;
        }

        responseDto.setId(clienteRepository.save(cliente).getId());
        responseDto.setMenssage("Usuário incluído com sucesso...");
        responseDto.setStatus(Status.SUCCESS.value());
        return responseDto;
    }

    public List<ClienteDto> getAllCliente() {
        List<ClienteDto> listAllClienteDto = clienteRepository.findAll().stream()
                .map(Cliente -> modelMapper.map(Cliente, ClienteDto.class))
                .collect(Collectors.toList());
        return listAllClienteDto;
    }

    public List<ClienteDto> getAllClienteOrderByName() {
        List<ClienteDto> listAllClienteDto = clienteRepository.findAll(Sort.by(Sort.Direction.ASC, "nome")).stream()
                .map(Cliente -> modelMapper.map(Cliente, ClienteDto.class))
                .collect(Collectors.toList());
        return listAllClienteDto;
    }

    public ClienteDto getClienteById(Long id) {
        return modelMapper.map(clienteRepository.findById(id).get(), ClienteDto.class);
    }

    public ResponseDto updateCliente(Cliente cliente) {
        if (clienteRepository.existsById(cliente.getId())) {
            if (cliente.getId() > 0) {
                responseDto.setId(clienteRepository.save(cliente).getId());
                responseDto.setMenssage("Usuário alterado com sucesso...");
                responseDto.setStatus(Status.SUCCESS.value());
            } else {
                responseDto.setMenssage("ID do Usuário inválido...");
                responseDto.setStatus(Status.ERROR.value());
            }
        }

        return responseDto;
    }

    public ResponseDto deleteCliente(Long id) {
        responseDto.setId(id);
        if (id > 0) {
            clienteRepository.deleteById(id);
            responseDto.setMenssage("Usuário deletado com sucesso...");
            responseDto.setStatus(Status.SUCCESS.value());
        } else {
            responseDto.setMenssage("ID do Usuário inválido...");
            responseDto.setStatus(Status.ERROR.value());
        }
        return responseDto;
    }

    public ClienteDto validateLogin(String login, String password) {
        return modelMapper.map(clienteRepository.findClienteByLoginAndPassword(login, password), ClienteDto.class);
    }

}
