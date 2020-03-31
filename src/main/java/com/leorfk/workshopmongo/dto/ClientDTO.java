package com.leorfk.workshopmongo.dto;

import com.leorfk.workshopmongo.domain.Client;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

public class ClientDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private String email;
    private String country;
    private int age;

    public ClientDTO(){

    }

    public ClientDTO(Client cli) {
        this.id = cli.getId();
        this.name = cli.getName();
        this.email = cli.getEmail();
        this.country = cli.getCountry();
        this.age = cli.getAge();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
