package com.anderson.secomp_backend_help_RS.controller;

import com.anderson.secomp_backend_help_RS.dto.UserDto;
import com.anderson.secomp_backend_help_RS.model.User;
import com.anderson.secomp_backend_help_RS.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user/")
public class UserController {

    @Autowired
    private UserService service;

    @CrossOrigin( origins = "*")
    @PostMapping("create")
    public ResponseEntity create(@RequestBody UserDto dto){
        try {

            service.validationUser(dto);
            service.saveUser(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(dto);

        }catch (Exception exception){

            System.out.println(exception.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("User name or Email already registered");
        }
    }

    @CrossOrigin( origins = "*")
    @GetMapping("getAll")
    public List<User> getAll(){
        return service.getAll();
    }

    @PutMapping("updateUserName/{id}")
    public ResponseEntity updateUserName(@PathVariable Integer id, @RequestBody User user){

        if (service.findUser(id, user)){
            service.saveUserNameUpdate(id, user);
            return ResponseEntity.status(HttpStatus.OK).body("Username updated successfully");

        }else {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }

    @PutMapping("updateEmail/{id}")
    public ResponseEntity updateEmail(@PathVariable Integer id, @RequestBody User user){

        if (service.findUser(id, user)){
            service.saveUserEmail(id, user);
            return ResponseEntity.status(HttpStatus.OK).body("Email updated successfully");

        }else {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id){

        if (service.delete(id)){
            return ResponseEntity.status(HttpStatus.OK).body("Delete user successfully");

        }else {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }

}
