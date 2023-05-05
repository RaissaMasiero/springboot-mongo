package com.raissamasi.mongo.resources;

import com.raissamasi.mongo.domain.Post;
import com.raissamasi.mongo.resources.util.URL;
import com.raissamasi.mongo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id){
        Post obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping(value = "/titlesearch")
    public ResponseEntity<List<Post>> findByTitulo(@RequestParam(value = "texto", defaultValue = "") String texto){
        texto = URL.decodeParam(texto);
        List<Post> list = service.findByTitulo(texto);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/fullsearch")
    public ResponseEntity<List<Post>> findAnyPlace(@RequestParam(value = "texto", defaultValue = "") String texto,
                                                   @RequestParam(value = "minDate", defaultValue = "") String minDate,
                                                   @RequestParam(value = "maxDate", defaultValue = "") String maxDate){
        texto = URL.decodeParam(texto);
        Date min = URL.convertDate(minDate, new Date(0L));
        Date max = URL.convertDate(maxDate, new Date());
        List<Post> list = service.findAnyPlace(texto, min, max);
        return ResponseEntity.ok().body(list);
    }
}
