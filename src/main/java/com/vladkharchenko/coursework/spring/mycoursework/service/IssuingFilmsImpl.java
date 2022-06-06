package com.vladkharchenko.coursework.spring.mycoursework.service;

import com.vladkharchenko.coursework.spring.mycoursework.dao.IssuingfilmRep;
import com.vladkharchenko.coursework.spring.mycoursework.entity.Issuingfilm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class IssuingFilmsImpl implements IssuingFimsService {
    @Autowired
    private IssuingfilmRep issuingfilmRep;

    @Override
//    @Scheduled(fixedDelay=10000)
    @Scheduled(cron = "@hourly")
    public void deleteOldIssuing() {
        List<Issuingfilm> issuingfilms = issuingfilmRep.findAll();
        int result;
        LocalDate date = LocalDate.now();
        for (Issuingfilm issuing:issuingfilms) {
            result = date.compareTo(issuing.getReturnData());
            if ( result >= 0) {
               issuingfilmRep.deleteById(issuing.getId_issuing());
            }

        }
    }
}
