package se.sundsvall.midalva.kafkademo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.kafka.KafkaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import se.sundsvall.midalva.kafkademo.integration.kafka.SubscriptionSender;
import se.sundsvall.midalva.kafkademo.model.Subscription;

@SpringBootApplication(exclude = KafkaAutoConfiguration.class)
public class KafkademoApplication {
    
    private static final Logger LOG = LoggerFactory.getLogger(KafkademoApplication.class);
    
    private static final String DATE_TIME_FORMAT  = "yyyy-MM-dd HH-mm-ss.SSSS";
    private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT);

        @Autowired
        private SubscriptionSender sender;
        
	public static void main(String[] args) {
		SpringApplication.run(KafkademoApplication.class, args);
	}
        
        @Bean 
        CommandLineRunner commandLineRunner(){
            return (String... args) -> {
                for (int i = 0; true ; i++) {
                    
                    Subscription subscription = new Subscription();
                    
                    subscription.setId("ID_"+i);
                    subscription.setTimeStamp(dtf.format(LocalDateTime.now()));
                    subscription.setUserIdentificationNumber("198712037403");
                    LOG.info("Sending subscription {}",subscription);
                    sender.sendMessage(subscription);
                    
                    Thread.sleep(3000);
                    
                }
            };
        }

}
