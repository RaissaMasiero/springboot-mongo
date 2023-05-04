package com.raissamasi.mongo.domain;

import com.raissamasi.mongo.dto.AuthorDTO;
import com.raissamasi.mongo.dto.CommentDTO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Document
public class Post implements Serializable {

    @Id
    private String id;
    private Date data;
    private String titulo;
    private String corpo;
    private AuthorDTO autor;
    private List<CommentDTO> comments = new ArrayList<>();

    public Post(){}

    public Post(String id, Date data, String titulo, String corpo, AuthorDTO autor) {
        this.id = id;
        this.data = data;
        this.titulo = titulo;
        this.corpo = corpo;
        this.autor = autor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCorpo() {
        return corpo;
    }

    public void setCorpo(String corpo) {
        this.corpo = corpo;
    }

    public AuthorDTO getAutor() {
        return autor;
    }

    public void setAutor(AuthorDTO autor) {
        this.autor = autor;
    }

    public List<CommentDTO> getComments() {
        return comments;
    }

    public void setComments(List<CommentDTO> comments) {
        this.comments = comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Post post)) return false;

        return Objects.equals(id, post.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
