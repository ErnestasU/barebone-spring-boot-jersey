package spring.boot.jersey.service;

import spring.boot.jersey.rest.model.Cat;

public interface CatService {

    Cat getCat(Long Id);
}
