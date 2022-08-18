package com.example.springbootbatch.schedule;

import com.example.springbootbatch.service.impl.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Period;


@Component
public class ScheduledTasks {
    private static final Logger LOGGER = LoggerFactory.getLogger(ScheduledTasks.class);

    @Autowired
    private UserService userService;

    @Scheduled(fixedRate = 86400000) // 1 day
    public void reportCurrentTime() {
        LocalDate now = LocalDate.now();
        int dateOfMonth = now.getDayOfMonth();
        int month = now.getMonthValue();
        userService.getAllUsers().forEach(user -> {
            if (isBirthdayToday(user.getBirthday(), dateOfMonth, month))
                LOGGER.info(String.format("Happy birthday %s is %d!", user.getUsername(), getAge(user.getBirthday(), now)));
        });
    }

    private static boolean isBirthdayToday(LocalDate birthday, int dateOfMonth, int month) {
        return birthday.getDayOfMonth() == dateOfMonth && birthday.getMonthValue() == month;
    }

    private static int getAge(LocalDate birthDate, LocalDate currentDate) {
        return Period.between(birthDate, currentDate).getYears();
    }
}
