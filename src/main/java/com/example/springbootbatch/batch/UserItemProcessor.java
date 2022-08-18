package com.example.springbootbatch.batch;

import com.example.springbootbatch.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import java.util.Locale;

public class UserItemProcessor implements ItemProcessor<User, User> {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserItemProcessor.class);

    @Override
    public User process(User user) throws Exception {
        User transformedUser = new User(
                user.getId(),
                user.getUsername().toLowerCase(Locale.ROOT),
                user.getEmail(),
                user.getBirthday()
        );
        LOGGER.info("Converting (" + user + ") into (" + transformedUser + ")");
        return transformedUser;
    }
}
