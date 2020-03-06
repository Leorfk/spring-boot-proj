package com.leorfk.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.leorfk.workshopmongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
/*
 * passamos como parâmetros para MongoRepository 
 * o tipo do dominio(Classe) que iremos utilizar e 
 * o tipo da chave(ID)
 */
}
