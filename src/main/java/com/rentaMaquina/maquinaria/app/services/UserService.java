/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rentaMaquina.maquinaria.app.services;

import com.rentaMaquina.maquinaria.app.entities.User;
import com.rentaMaquina.maquinaria.app.repositories.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author nacai
 */
@Service
public class UserService {
    @Autowired 
    private UserRepository repository;
    
    
    // GET para listar todos los usuarios regitrados
    public List<User> getUsers(){
        return repository.findAll();
    }
    
    // POST para regitrar un nuevo usuario
    public User saveUser(User user){
        return repository.save(user);
    }
    
    public String buscaEmail(String correo){
        
        if(repository.existsByEmail(correo)){
            return "true";
        }
        else{
            return "false";
        }        
    }
    
    public User validarUser(String correo, String contrasena){
        User usuarioADevolver = new User();
        if(repository.existsByEmailAndPassword(correo, contrasena)){
            usuarioADevolver = repository.findByEmailAndPassword(correo, contrasena);
        }
        else{
            usuarioADevolver.setId(null);
            usuarioADevolver.setEmail(correo);
            usuarioADevolver.setPassword(contrasena);
            usuarioADevolver.setName("NO DEFINIDO");
        }
        return usuarioADevolver;
    }
    
}
