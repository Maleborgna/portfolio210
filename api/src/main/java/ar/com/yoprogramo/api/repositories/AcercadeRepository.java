/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.com.yoprogramo.api.repositories;

import ar.com.yoprogramo.api.models.Acercade;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author malen
 */
@Repository
public interface AcercadeRepository extends JpaRepository<Acercade, Long> {
    
}
