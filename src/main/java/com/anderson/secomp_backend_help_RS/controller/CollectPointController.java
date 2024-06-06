package com.anderson.secomp_backend_help_RS.controller;

import com.anderson.secomp_backend_help_RS.dto.CollectPointDto;
import com.anderson.secomp_backend_help_RS.model.CollectPoint;
import com.anderson.secomp_backend_help_RS.service.CollectPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("collectPoint/")
public class CollectPointController {

    @Autowired
    private CollectPointService service;

    @CrossOrigin( origins = "*")
    @GetMapping("getAll")
    public List<CollectPoint> getAll(){
        return service.getAllCollectPoint();
    }

    @CrossOrigin( origins = "*")
    @PostMapping("getById/{id}")
    public CollectPointDto getById(@PathVariable Integer id){
        System.out.println(id);
        return service.getById(id);
    }

    @CrossOrigin( origins = "*")
    @PostMapping("create")
    public ResponseEntity createCollectPoint(CollectPointDto dto){
        try {

            service.saveCollectPoint(dto);

            return ResponseEntity.status(HttpStatus.CREATED).body("Collect Point Created successfully");

        }catch (Exception exception){

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Collect Point already registered");

        }
    }

    @CrossOrigin( origins = "*")
    @PutMapping("updateNamePoint")
    public ResponseEntity updateNamePoint(CollectPoint point){
        try {

            service.updateNamePoint(point);

            return ResponseEntity.status(HttpStatus.OK).body("Ainda não funcionado");

        }catch (Exception exception){

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ainda não func.... not found");

        }
    }

    @CrossOrigin( origins = "*")
    @DeleteMapping("delete")
    public ResponseEntity deleteCollectPoint(Integer id){
        try {

            service.deleteCollectPoint(id);

            return ResponseEntity.status(HttpStatus.OK).body("Collect Point delete successfully");

        }catch (Exception exception){

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Collect Point not found");

        }
    }
}
