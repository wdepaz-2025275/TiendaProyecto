package com.wilfreddepaz.tienda.repository;

import com.wilfreddepaz.tienda.entity.LoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<LoginEntity, Integer> {

    LoginEntity findByUsernameAndPassword(String username, String password);
    LoginEntity findByUsername(String username);
}
