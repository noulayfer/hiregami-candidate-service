package com.hiregami.candidateservice.sample;

import lombok.Getter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Hashtable;
import java.util.Map;
@Getter
@Component
@Order
public class SampleContextApplicationListener implements ApplicationListener<ApplicationContextEvent> {

    private Map<String,ApplicationContext> contextMap = new Hashtable<String, ApplicationContext>();

    @Override
    public void onApplicationEvent(ApplicationContextEvent event) {
        if( event instanceof ContextStartedEvent || event instanceof ContextRefreshedEvent){
            this.getContextMap().put(event.getApplicationContext().getDisplayName(), event.getApplicationContext());
        }
        contextMap.get("");
    }

}
