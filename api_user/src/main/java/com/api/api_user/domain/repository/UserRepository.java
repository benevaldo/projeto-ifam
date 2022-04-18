package com.api.api_user.domain.repository;

//import java.util.List;

import com.api.api_user.domain.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User,Long>  {

    @Query("SELECT u FROM User u WHERE u.login = ?1 and u.senha = ?2")
    User findUserByLoginAndPassword(String login, String password);

}
