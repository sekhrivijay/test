package com.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.gcp.pubsub.core.PubSubOperations;
//import org.springframework.cloud.gcp.pubsub.support.GcpHeaders;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
//import org.springframework.integration.annotation.MessagingGateway;
//import org.springframework.integration.annotation.ServiceActivator;
//import org.springframework.integration.channel.DirectChannel;
//import org.springframework.integration.gcp.pubsub.AckMode;
//import org.springframework.integration.gcp.pubsub.inbound.PubSubInboundChannelAdapter;
//import org.springframework.integration.gcp.pubsub.outbound.PubSubMessageHandler;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.messaging.MessageChannel;
//import org.springframework.messaging.MessageHandler;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@SpringBootApplication
@EnableCaching
public class PubSubApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(PubSubApplication.class);
//    @Autowired
//    private JdbcTemplate jdbcTemplate;

    public static void main(String[] args) throws IOException {
        SpringApplication.run(PubSubApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }



//    @Bean
//    @ServiceActivator(inputChannel = "pubsubOutputChannel")
//    public MessageHandler messageSender(PubSubOperations pubsubTemplate) {
//        return new PubSubMessageHandler(pubsubTemplate, "MyTopic");
//    }
//
//    @Bean
//    public PubSubInboundChannelAdapter messageChannelAdapter(
//            @Qualifier("pubsubInputChannel") MessageChannel inputChannel,
//            PubSubOperations pubSubTemplate) {
//        PubSubInboundChannelAdapter adapter =
//                new PubSubInboundChannelAdapter(pubSubTemplate, "MySub");
//        adapter.setOutputChannel(inputChannel);
//        adapter.setAckMode(AckMode.MANUAL);
//
//        return adapter;
//    }
//
//    @Bean
//    public MessageChannel pubsubInputChannel() {
//        return new DirectChannel();
//    }
//
//    @Bean
//    @ServiceActivator(inputChannel = "pubsubInputChannel")
//    public MessageHandler messageReceiver() {
//        return message -> {
//            LOGGER.info("Message arrived! Payload: " + message.getPayload());
//            AckReplyConsumer consumer =
//                    (AckReplyConsumer) message.getHeaders().get(GcpHeaders.ACKNOWLEDGEMENT);
////            if(1 == 1) {
////                throw new RuntimeException("test");
////            }
//            consumer.ack();
//        };
//    }
//
//    @MessagingGateway(defaultRequestChannel = "pubsubOutputChannel")
//    public interface PubsubOutboundGateway {
//
//        void sendToPubsub(String text);
//    }
}