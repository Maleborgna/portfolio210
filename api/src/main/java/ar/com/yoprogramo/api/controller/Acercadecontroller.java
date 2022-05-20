/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.com.yoprogramo.api.controller;

/**
 *
 * @author malen
 */
import ar.com.yoprogramo.api.AcercadeDTO;
import ar.com.yoprogramo.api.Mensaje;
import java.util.List;

import ar.com.yoprogramo.api.dto.Mensaje;
import ar.com.yoprogramo.api.AcercadeDTO;
import ar.com.yoprogramo.api.models.Acercade;
import ar.com.yoprogramo.api.services.AcercadeServices.Acercadeservices;


import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/acercade")
@CrossOrigin(origins = "*")
public class Acercadecontroller {
     @Autowired
    Acercadeservices acercadeServices;

    @GetMapping("/ver/acercade")
    public ResponseEntity<List<Acercade>> lista(){
        List<Acercade> lista = acercadeServices.listado();
        return new ResponseEntity<List<Acercade>>(lista, HttpStatus.OK);
    }

    @GetMapping("/obtener/acercade/{id}")
    public ResponseEntity<?> buscaracercadeId(@PathVariable Long id){
        if (!acercadeServices.existeId(id))
            return new ResponseEntity<Mensaje>(new Mensaje("Id No Existe"), HttpStatus.NOT_FOUND);
        Acercade persona = acercadeServices.buscarAcercadeId(id);
        return new ResponseEntity<Acercade>(acercade, HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<?> crearAcercade(@RequestBody AcercadeDTO acercadeDto) {
  
        if(StringUtils.isBlank(acercadeDto.getNombre()))
            return new ResponseEntity<>(new Mensaje("El nombre es requerido"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(acercadeDto.getApellido()))
            return new ResponseEntity<>(new Mensaje("El apellido es requerido"), HttpStatus.BAD_REQUEST);
        Acercade acercade = new Acercade(acercadeDto.getNombre(),acercadeDto.getApellido());
        acercadeServices.crearAcercade(acercade);
        return new ResponseEntity<>(new Mensaje("Persona creada"), HttpStatus.OK);
    }
    
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Long id, @RequestBody AcercadeDTO acercadeDto){
        if (!acercadeServices.existeId(id))
            return new ResponseEntity<Mensaje>(new Mensaje("Id No Existe"), HttpStatus.NOT_FOUND);
        if(StringUtils.isBlank(acercadeDto.getNombre()))
            return new ResponseEntity<Mensaje>(new Mensaje("El nombre es requerido"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(acercadeDto.getApellido()))
            return new ResponseEntity<Mensaje>(new Mensaje("El apellido es requerido"), HttpStatus.BAD_REQUEST);
        Acercade acercade= acercadeServices.buscarAcercadeId(id);
        acercade.setNombre(acercadeDto.getNombre());
        acercade.setApellido(acercadeDto.getApellido());
        acercadeServices.crearAcercade(acercade);
        return new ResponseEntity<Mensaje>(new Mensaje("La sección -Acerca de- se ha actualiado"), HttpStatus.OK);
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> borrado(@PathVariable Long id){
        if (!acercadeServices.existeId(id))
            return new ResponseEntity<Mensaje>(new Mensaje("Id No Existe"), HttpStatus.NOT_FOUND);
        acercadeServices.borrarAcercade(id);
        return new ResponseEntity<Mensaje>(new Mensaje("Persona Borrada"), HttpStatus.OK);
    }


}

