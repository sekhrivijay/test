package com.test;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.sleuth.annotation.NewSpan;
//import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
//import org.springframework.web.servlet.view.RedirectView;

import java.awt.*;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class WebAppController {
    private static final Logger LOGGER = LoggerFactory.getLogger(WebAppController.class);


//    @Value("${service.pimService.apolloBaseUrl}")
//    private String pimServiceApolloBaseUrl;
//    @Autowired
//    private PubSubApplication.PubsubOutboundGateway messagingGateway;
//
//    @Autowired
//    private JdbcTemplate jdbcTemplate;


//    @PostMapping("/publishMessage")
//    @NewSpan("pub")
//    public RedirectView publishMessage(@RequestParam("message") String message) {
//        for(int i =0 ; i != 10000; ++i) {
//            messagingGateway.sendToPubsub(message + " : "  +  i);
//        }
//        return new RedirectView("/");
//    }

    @GetMapping("/getTuples")
    @Cacheable(cacheNames = "default")
    public String abc(String a) {
//        HttpEntity<?> request = new HttpEntity<>(new HttpHeaders());
//        Dimension d = new Dimension(1,2);
//        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("https://apiservice.providecommerce.com/API/Product/v1/JSON/GetProductDetail")
//                .queryParam("prodid", d);
//
//        System.out.println( "jhhhhh >>>>>>>>" + builder.build().encode().toUri());
//        ResponseEntity<ProductDocument> response = restTemplate.exchange(
//                builder.build().encode().toUri(),
//                HttpMethod.GET,
//                request,
//                ProductDocument.class);
//        ProductDocument productDocument = response.getBody();
//        LOGGER.info(productDocument.toString());
//        return productDocument;
//        return "dhajksdhkashda" + builder.build().encode().toUri();
        return "dasdasdas";
    }

//    @NewSpan("busyWork")
//    public List getTuples() {
//        LOGGER.info("Calling mysql ...");
//        return this.jdbcTemplate.queryForList("SELECT * FROM users").stream()
//                .map(Map::values)
//                .collect(Collectors.toList());
//    }

}