package com.example.workflow.service;

import com.example.workflow.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class SampleServiceImpl implements SampleService{

    @Autowired
    private RestTemplate clienteRest;

    @Override
    public Person getMessage(String message) {
        Map<String, String> pathVariables = new HashMap<String, String>();
        pathVariables.put("message",message);
        Person person = clienteRest.getForObject("http://localhost:8001/api/sample/message/{message}", Person.class, pathVariables);
        return person;
    }
}
