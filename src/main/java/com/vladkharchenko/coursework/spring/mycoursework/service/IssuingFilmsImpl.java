package com.vladkharchenko.coursework.spring.mycoursework.service;

import com.vladkharchenko.coursework.spring.mycoursework.dao.IssuingfilmRep;
import com.vladkharchenko.coursework.spring.mycoursework.dao.MoviesRepository;
import com.vladkharchenko.coursework.spring.mycoursework.entity.Available;
import com.vladkharchenko.coursework.spring.mycoursework.entity.Issuingfilm;
import com.vladkharchenko.coursework.spring.mycoursework.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class IssuingFilmsImpl implements IssuingFimsService {
    @Autowired
    private IssuingfilmRep issuingfilmRep;

    @Autowired
    private MoviesRepository moviesRepository;

    @Override
//    @Scheduled(fixedDelay = 10000)
    @Scheduled(cron = "@daily")
    public void deleteOldIssuing() {
        List<Issuingfilm> issuingfilms = issuingfilmRep.findAll();
        int result;
        LocalDate date = LocalDate.now();
        for (Issuingfilm issuing : issuingfilms) {
            result = date.compareTo(issuing.getReturnData());
            if (result >= 0) {
                issuingfilmRep.deleteById(issuing.getId_issuing());
            }

        }
    }
    @Transactional
    @Scheduled(fixedDelay = 10000)
//    @Scheduled(cron = "@daily")
    public void checkMoviesIssuings() {
        List<Movie> movies = moviesRepository.findAll();
        for (Movie movie : movies) {
            if (movie.getIssuingfilmsList().size() == 0 && movie.getAvailable() == Available.DELETED) {
                moviesRepository.delete(movie);
            }

        }
    }
}
