package com.example.workflow;

import com.example.workflow.model.Person;
import com.example.workflow.service.SampleServiceImpl;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;
@Component
@RestController
public class HelloWorkDelegate implements JavaDelegate {

    @Autowired
    private SampleServiceImpl sampleService;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        Person person = sampleService.getMessage(delegateExecution.getVariable("field").toString());
        System.out.println("It's work !!!!!!!!!!!" );
        System.out.println(person.getName());
    }
}
