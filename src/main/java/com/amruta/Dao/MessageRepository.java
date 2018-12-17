package com.amruta.Dao;

import com.amruta.model.Message;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * Created by amrutaj on 17/12/2018.
 */
@Component
@Repository
public interface MessageRepository {

    void save(Message message);

    String getMessagebyHash(String hashVal);
}
