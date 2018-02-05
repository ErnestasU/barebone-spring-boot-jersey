package spring.boot.jersey.service;

import org.springframework.stereotype.Service;
import spring.boot.jersey.rest.model.Cat;

@Service("catService")
public class CatServiceImpl implements CatService {

    @Override
    public Cat getCat(Long id) {
        return new Cat(id);
    }
}
