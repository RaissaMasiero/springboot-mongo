package com.raissamasi.mongo.services;

import com.raissamasi.mongo.domain.User;
import com.raissamasi.mongo.dto.UserDTO;
import com.raissamasi.mongo.repository.UserRepository;
import com.raissamasi.mongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(String id){
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!"));
    }

    public User insert(User obj){
        return repository.insert(obj);
    }

    public User fromDTO(UserDTO objDTO){
        return new User(objDTO.getId(), objDTO.getNome(), objDTO.getEmail());
    }
}
