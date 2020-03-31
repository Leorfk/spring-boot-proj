package com.leorfk.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.leorfk.workshopmongo.domain.Client;

@Repository
public interface ClientRepository extends MongoRepository<Client, String> {
}
