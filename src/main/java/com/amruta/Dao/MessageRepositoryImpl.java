package com.amruta.Dao;

import com.amruta.model.Message;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by amrutaj on 17/12/2018.
 */
@Repository
@Qualifier("messageRepositoryImpl")
@Component
public class MessageRepositoryImpl implements MessageRepository {

    private Map<String, Message> messageMap = new HashMap<>();

    @Override
    public void save(Message message) {
        messageMap.put(message.getDigest(), message);
    }

    @Override
    public String getMessagebyHash(String hashVal) {

        if(Objects.nonNull(messageMap.get(hashVal))){
            Message message =messageMap.get(hashVal);
            return  message.getMessage();
        }
        return null;
    }
}
