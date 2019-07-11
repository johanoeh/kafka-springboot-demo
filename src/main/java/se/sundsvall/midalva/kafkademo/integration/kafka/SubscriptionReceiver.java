/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.sundsvall.midalva.kafkademo.integration.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import se.sundsvall.midalva.kafkademo.model.Subscription;

/**
 *
 * @author johan
 */
@Component
public class SubscriptionReceiver {
    
    private final Logger LOG = LoggerFactory.getLogger(SubscriptionReceiver.class);
    
    private static final String GROUP_ID = "subscription_topic";
    
//    @KafkaListener(topics = "subscription_topic", groupId = GROUP_ID)
    public void consume(Subscription subscription) {
        LOG.info("Consumed message {}", subscription);
    }  
}
