package com.anderson.secomp_backend_help_RS.service;

import com.anderson.secomp_backend_help_RS.dto.UserDto;
import com.anderson.secomp_backend_help_RS.model.User;
import com.anderson.secomp_backend_help_RS.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService{

    @Autowired
    private UserRepository repository;

    public void validationUser(UserDto dto) throws Exception{
        User user = new User();
        user.setUserName(dto.userName());
        user.setEmail(dto.email());
        user.setPassword(dto.password());
        if (repository.findByUserName(user.getUserName()) != null){
            throw new Exception("Existing username");
        }
        if (repository.findByEmail(user.getEmail()) != null) {
            throw new Exception("Existing email");
        }
    }

    public void saveUser( UserDto dto){
        User user = new User();
        user.setUserName(dto.userName());
        user.setEmail(dto.email());
        user.setPassword(dto.password());
        repository.save(user);
    }

    public List<User> getAll(){
        return  repository.findAll();
    }

    public boolean findUser(Integer id, User user){
        user.setId(id);
        Optional<User> userFind = repository.findById(user.getId());
        if (userFind.isPresent()){
            return true;
        }else {
            return false;
        }
    }

    public void saveUserNameUpdate(Integer id, User user) {
        user.setId(id);
        Optional<User> userFind = repository.findById(user.getId());
        if (userFind.isPresent()) {
            User userExisting = userFind.get();
            userExisting.setUserName(user.getUserName());
            repository.save(userExisting);
        }
    }

    public void saveUserEmail(Integer id, User user) {
        user.setId(id);
        Optional<User> userFind = repository.findById(user.getId());
        if (userFind.isPresent()) {
            User userExisting = userFind.get();
            userExisting.setEmail(user.getEmail());
            System.out.println(userExisting.getEmail());
            repository.save(userExisting);
        }
    }

    public boolean delete(Integer id){
        Optional<User> userFind = repository.findById(id);
        if (userFind.isPresent()){
            repository.deleteById(id);
            return true;
        }else {
            return false;
        }
    }


}
