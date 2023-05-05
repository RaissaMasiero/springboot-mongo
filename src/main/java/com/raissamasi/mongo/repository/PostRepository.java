package com.raissamasi.mongo.repository;

import com.raissamasi.mongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    List<Post> findByTituloContainingIgnoreCase(String texto);

    @Query("{ 'titulo': { $regex: ?0, $options: 'i' } }")
    List<Post> findByTitulo(String texto);

    @Query("{$and:[{data:{$gte:?1}},{data:{$lte:?2}},{$or:[{'titulo':{$regex:?0,$options:'i'}}," +
            "               {'corpo':{$regex:?0,$options:'i'}},{'comments.texto':{$regex:?0,$options:'i'}}]}]}")
    List<Post> findAnyPlace(String texto, Date minDate, Date maxDate);
}
