package com.raissamasi.mongo.services;

import com.raissamasi.mongo.domain.Post;
import com.raissamasi.mongo.repository.PostRepository;
import com.raissamasi.mongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public Post findById(String id){
        Optional<Post> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!"));
    }

    public List<Post> findByTitulo(String texto){
        return repository.findByTitulo(texto);
    }

    public List<Post> findAnyPlace(String texto, Date minDate, Date maxDate){
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
        return repository.findAnyPlace(texto, minDate, maxDate);
    }
}
