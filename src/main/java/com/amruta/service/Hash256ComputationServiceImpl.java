package com.amruta.service;

import com.amruta.Dao.MessageRepository;
import com.amruta.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by amrutaj on 09/12/2018.
 */
@Service("hash256ComputationServiceImpl")
public class Hash256ComputationServiceImpl implements HashComputationService {

    @Autowired
    @Qualifier("messageRepositoryImpl")
    private MessageRepository messageRepository;



    @Override
    public Message generateHash(String originalString) {
        Message message = new Message(originalString);
        try {
            MessageDigest mDigest = MessageDigest.getInstance(ALGORITHM);
            byte[] encodedhash = mDigest.digest(originalString.getBytes(StandardCharsets.UTF_8));
            String sha256HashValue = HashComputationService.bytesToHex(encodedhash, ALGORITHM);
            //message.setMessage(originalString);
            message.setDigest(sha256HashValue);
            messageRepository.save(message);
            return message;

        } catch (NoSuchAlgorithmException ex) {
            //return "Error while generating the hash";
            return new Message("Error while generating the hash");
        }
    }

    @Override
    public String getOriginalMessage(String messageHash) {

        return messageRepository.getMessagebyHash(messageHash);
    }
}
