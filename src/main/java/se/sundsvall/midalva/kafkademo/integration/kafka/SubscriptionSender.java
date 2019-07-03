/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.sundsvall.midalva.kafkademo.integration.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import se.sundsvall.midalva.kafkademo.model.Subscription;

/**
 *
 * @author johan
 */
@Component
public class SubscriptionSender {
    
    @Value("${kafka.subscription.topic}")
    private String subscriptionTopic;

    @Autowired
    private KafkaTemplate<String, Subscription> kafkaTemplate;

    public void sendMessage(Subscription subscription) {
        kafkaTemplate.send(subscriptionTopic, subscription);
    }

}
