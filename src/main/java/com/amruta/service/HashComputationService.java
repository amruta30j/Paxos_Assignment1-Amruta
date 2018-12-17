package com.amruta.service;

import com.amruta.model.Message;
import org.springframework.stereotype.Component;

import java.security.NoSuchAlgorithmException;

/**
 * Created by amrutaj on 17/12/2018.
 */
@Component
public interface HashComputationService {

    Message generateHash(String message) throws NoSuchAlgorithmException;

    String getOriginalMessage(String messageHash);

    String ALGORITHM = "SHA-256";

    /*S*/

    static String bytesToHex(byte[] hash,String algorithm) {
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
