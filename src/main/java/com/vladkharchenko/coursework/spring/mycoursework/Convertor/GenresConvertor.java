package com.vladkharchenko.coursework.spring.mycoursework.Convertor;

import com.vladkharchenko.coursework.spring.mycoursework.dao.GenreRep;
import com.vladkharchenko.coursework.spring.mycoursework.entity.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GenresConvertor implements Converter<String, Genre> {

    @Autowired
    public GenreRep genreRep;

    @Override
    public Genre convert(String id) {
        System.out.println("Trying to convert id = " + id + " into a drink");
        int parsedInt = Integer.parseInt(id);
        List<Genre> genreList = genreRep.findAll();
        int index = parsedInt - 1;
        return genreList.get(index) ;
    }
}
