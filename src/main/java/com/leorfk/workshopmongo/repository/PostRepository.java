package com.leorfk.workshopmongo.repository;

import com.leorfk.workshopmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    List<Post> findByTitleContainingIgnoreCase(String text);
/*
 * passamos como parâmetros para MongoRepository 
 * o tipo do dominio(Classe) que iremos utilizar e 
 * o tipo da chave(ID)
 */
}