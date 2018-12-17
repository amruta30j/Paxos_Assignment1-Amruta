package com.amruta.controller;

/**
 * Created by amrutaj on 16/12/2018.
 */

import com.amruta.model.Message;
import com.amruta.model.Result;
import com.amruta.service.HashComputationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.NoSuchElementException;
import java.util.Objects;


@Controller
public class MessagesController {


    @Autowired
    @Qualifier("hash256ComputationServiceImpl")
    private HashComputationService hashComputationService;

    @RequestMapping(value = "/messages", method = RequestMethod.POST, headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)

    public
    @ResponseBody
    Result handleMessageHashGeneration(@RequestBody String message) {
        Result resultObject = new Result();
        try {
            Message hashedMessage = hashComputationService.generateHash(message);
            resultObject.setHasErrors(Boolean.FALSE);
            resultObject.setMessage("digest");
            resultObject.setSuccess("Message hashing is successful");
            resultObject.setObject(resultObject.getMessage() + ":" + hashedMessage.getDigest());
            return resultObject;
        } catch (Exception ex) {
            resultObject.setHasErrors(Boolean.TRUE);
            resultObject.setObject(ex.getMessage());
            resultObject.setErrorMessage("Error while hasing the message");
            return resultObject;
        }
    }

    @RequestMapping(value = "/messages/hash", method = RequestMethod.POST, headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Result handleGetOriginalMessageBasedOnTheHashVal(@RequestBody String hashVal) {
        Result resultObject = new Result();
        try {
            String originalMessage =hashComputationService.getOriginalMessage(hashVal);
            if(Objects.nonNull(originalMessage)){
                resultObject.setHasErrors(Boolean.FALSE);
                resultObject.setMessage("message");
                resultObject.setSuccess("Message found");
                resultObject.setObject(resultObject.getMessage() + ":" +originalMessage);
                return resultObject;
            } else {
                throw new NoSuchElementException();
            }


        } catch (NoSuchElementException ex) {
            resultObject.setHasErrors(Boolean.TRUE);
            resultObject.setMessage("err_msg");
            resultObject.setObject(ex.getMessage());
            resultObject.setErrorMessage(resultObject.getMessage() + ":" + "Message not found");
            return resultObject;
        }

    }

}
