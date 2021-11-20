/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.rentaMaquina.maquinaria.app.repositories;

import com.rentaMaquina.maquinaria.app.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author nacai
 */
public interface UserRepository  extends JpaRepository<User, Integer> {
    
    boolean existsByEmail( String correo);
    
    boolean existsByEmailAndPassword (String email, String password);
    
    User findByEmailAndPassword (String email, String password);
    
    
           
    
}
