package com.wilfreddepaz.tienda.service;

import com.wilfreddepaz.tienda.entity.LoginEntity;
import com.wilfreddepaz.tienda.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImplements implements LoginService {

    @Autowired
    private LoginRepository repo;

    @Override
    public LoginEntity registrar(String username, String password) {
        if (username == null || password == null) return null;

        String cleanUser = username.trim();
        String cleanPass = password.trim();

        LoginEntity user = new LoginEntity();
        user.setUsername(cleanUser);
        user.setPassword(cleanPass);

        return repo.save(user);
    }

    @Override
    public LoginEntity login(String username, String password) {
        if (username == null || password == null) return null;

        String cleanUser = username.trim();
        String cleanPass = password.trim();

        return repo.findByUsernameAndPassword(cleanUser, cleanPass);
    }

    @Override
    public List<LoginEntity> listar() {
        return repo.findAll();
    }

    @Override
    public void eliminar(Integer id) {
        repo.deleteById(id);
    }
}