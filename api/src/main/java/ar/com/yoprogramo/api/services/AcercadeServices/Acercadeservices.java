/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.com.yoprogramo.api.services.AcercadeServices;

/**
 *
 * @author malen
 */

import java.util.List;

import ar.com.yoprogramo.api.models.Acercade;
import ar.com.yoprogramo.api.repositories.AcercadeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Acercadeservices {
    
    @Autowired
    AcercadeRepository AcercadeRepository;

    public List<Acercade> listado(){
        return acercadeRepository.findAll();
    }

    public Acercade buscarAcercadeId(Long id){
        return acercadeRepository.findById(id).orElse(null);
    }

    public void crearAcercade(Acercade acercade){
        acercadeRepository.save(acercade);
    }

    public boolean existeId(Long id){
        return acercadeRepository.existsById(id);
    }

    public void borrarAcercade(Long id){
        acercadeRepository.deleteById(id);
    }
    
}
}

