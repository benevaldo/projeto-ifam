package com.api.api_user.controller;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import com.api.api_user.domain.dto.ResponseDto;
import com.api.api_user.domain.dto.UserDto;
import com.api.api_user.domain.entity.User;
import com.api.api_user.domain.exceptions.AppExceptionHandler;
import com.api.api_user.domain.repository.UserRepository;
import com.api.api_user.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import java.net.URI;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

  @Autowired
  private UserService userService;

  @Autowired
	private UserRepository userRepository;

  @Autowired
	private AppExceptionHandler exception;
  

  @PostMapping //http://localhost:8080/user/
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseDto saveUser(@Valid @RequestBody User user) {
    return userService.saveUser(user);
  }

  @GetMapping(value = "/list") // http://localhost:8080/user/list
  public List<UserDto> getAllUser() {
    return userService.getAllUserOrderByName();
  }

  @GetMapping(value = "/{id}")
  public UserDto getUserById(@PathVariable Long id) {
    return userService.getUserById(id);  
  }

  @PutMapping(value = "/{id}")
  public ResponseDto updateUser(@PathVariable Long id , @Valid @RequestBody User user) {
      return userService.updateUser(id, user);
  }

  @DeleteMapping(value = "/{id}")
  public ResponseDto deleteUser(@PathVariable Long id) {
    return userService.deleteUser(id);
  }

  @PostMapping(value = "/validarLogin/{login}/{password}")
  public UserDto validateLogin(@PathVariable String login, @PathVariable String password) {
    return userService.validateLogin(login, password);
  }
}