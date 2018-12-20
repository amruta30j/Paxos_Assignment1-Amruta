package com.amruta.test;

import com.amruta.Dao.MessageRepository;
import com.amruta.config.AppConfig;
import com.amruta.model.Message;
import com.amruta.service.Hash256ComputationServiceImpl;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by amrutaj on 17/12/2018.(Was about to write the junits using the spring test framework. However, due to config issues 
 it was not possible.)
 */
@RunWith(MockitoJUnitRunner.Silent.class)
public class Hash256ComputationServiceImplTest {

    @Mock
    private MessageRepository messageRepository;

    @InjectMocks
    private Hash256ComputationServiceImpl hash256ComputationService= new Hash256ComputationServiceImpl();


    private Message message = new Message("foo");

    private final String DIGEST ="2c26b46b68ffc68ff99b453c1d30413413422d706483bfa0f98a5e886266e7ae";



    @Before
    public  void setUp() {
    }

    @After
    public  void tearDown() {

        hash256ComputationService= null;
    }

    @Test
    public void generateHash() {
        Mockito.doNothing().when(messageRepository).save(message);
        Assert.assertEquals(DIGEST,hash256ComputationService.generateHash(message.getMessage()).getDigest());
    }

    @Test
    public void getOriginalMessage() {
        Mockito.when(messageRepository.getMessagebyHash(DIGEST)).thenReturn(message.getMessage());
        Assert.assertEquals(message.getMessage(),hash256ComputationService.getOriginalMessage(DIGEST));

    }

}
