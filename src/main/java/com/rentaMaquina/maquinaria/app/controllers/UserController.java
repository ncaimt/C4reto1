/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rentaMaquina.maquinaria.app.controllers;

import com.rentaMaquina.maquinaria.app.entities.User;
import com.rentaMaquina.maquinaria.app.services.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author nacai
 */
@RestController
@RequestMapping("user")
public class UserController {
    
    @Autowired
    private UserService service;
    
    @GetMapping("/all")
    public List<User> findAllUser(){
        return service.getUsers();
    }
    
    @PostMapping("/new")
    public ResponseEntity addUser(@RequestBody User user){
        service.saveUser(user);
        return ResponseEntity.status(201).build();
    }
    
     @GetMapping("/{correo}")
    public String  buscarXCorreo(@PathVariable String correo){
        return service.buscaEmail(correo);
    }
    
    @GetMapping("/{correo}/{contrasena}")
    
    public User validarUser(@PathVariable String correo, @PathVariable String contrasena){
        return service.validarUser(correo, contrasena);
    }
    
}
