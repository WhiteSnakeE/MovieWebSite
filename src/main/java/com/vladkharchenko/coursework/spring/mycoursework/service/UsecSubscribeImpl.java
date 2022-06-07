package com.vladkharchenko.coursework.spring.mycoursework.service;

import com.vladkharchenko.coursework.spring.mycoursework.dao.CustomerRepository;
import com.vladkharchenko.coursework.spring.mycoursework.dao.UserSubcribeRep;
import com.vladkharchenko.coursework.spring.mycoursework.entity.Issuingfilm;
import com.vladkharchenko.coursework.spring.mycoursework.entity.Status;
import com.vladkharchenko.coursework.spring.mycoursework.entity.UserSubscribe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class UsecSubscribeImpl {
    @Autowired
    private UserSubcribeRep userSubcribeRep;

//    @Scheduled(fixedDelay=10000)
    @Scheduled(cron = "@hourly")
    public void endUserSub(){
        List<UserSubscribe> userSubscribeList = userSubcribeRep.findAll();
        int result;
        LocalDate date = LocalDate.now();
        for (UserSubscribe userSubscribe:userSubscribeList) {
            if (userSubscribe.getStatus() == Status.PAID) {
                result = date.compareTo(userSubscribe.getEnd());
                if (result >= 0) {
                    userSubscribe.setStatus(Status.NOT_PAID);
                    userSubscribe.setStart(null);
                    userSubscribe.setEnd(null);
                    userSubcribeRep.save(userSubscribe);
                }

            }
        }
    }

}
