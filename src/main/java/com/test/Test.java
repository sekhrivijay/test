package com.test;

import com.micro.services.search.api.SearchModelWrapper;
import com.micro.services.search.api.request.SearchServiceRequest;
import com.micro.services.search.api.response.SearchServiceResponse;
import org.apache.solr.client.solrj.SolrQuery;
import org.drools.core.impl.InternalKnowledgeBase;
import org.drools.core.impl.KnowledgeBaseFactory;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieSession;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.io.ResourceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootApplication
@ComponentScan({"com"})
public class Test implements CommandLineRunner {
//public class Test  {


    private RestTemplate restTemplate;

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public InternalKnowledgeBase kbase;
    public KnowledgeBuilder kbuilder;

    public static void main(String[] args)  throws Exception {



        SpringApplication.run(Test.class, args);
//        run(args);
    }


    @Override
    public void run(String... args) throws Exception {
        SearchModelWrapper searchModelWrapper = new SearchModelWrapper();
        SearchServiceRequest searchServiceRequest = new SearchServiceRequest();
        searchServiceRequest.setQ("flowers");
        SearchServiceResponse searchServiceResponse = new SearchServiceResponse();
//        SolrQuery solrQuery = new SolrQuery();
        searchModelWrapper.setSearchServiceRequest(searchServiceRequest);
        searchModelWrapper.setSearchServiceResponse(searchServiceResponse);
//        searchModelWrapper.setSolrQuery(solrQuery);

        HttpEntity<SearchModelWrapper> request = new HttpEntity<>(searchModelWrapper);


        ResponseEntity<SearchModelWrapper> response = restTemplate.exchange("http://localhost:8080/demo/rules/executePre", HttpMethod.POST, request, SearchModelWrapper.class);
        System.out.println("response is " + response.getBody());

    }

//    @Override
    public void run1(String... args) throws Exception {
//    public static void run(String... args) throws Exception {
        Test t = new Test();

        t.kbase = KnowledgeBaseFactory.newKnowledgeBase();
        t.kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        t.kbuilder.add(ResourceFactory.newClassPathResource("a.drl"), ResourceType.DRL);
        t.kbase.addPackages(t.kbuilder.getKnowledgePackages());
        System.out.println("This is a test");

        KieSession knowledgeSession = null;
        try {

            knowledgeSession = t.kbase.newKieSession();
            SearchServiceRequest searchServiceRequest = new SearchServiceRequest();
            searchServiceRequest.setQ("flowers");

            SearchServiceResponse searchServiceResponse = new SearchServiceResponse();
            // 4 - create and assert some facts
//            Person rocky = new Person("Rocky Balboa", "Philadelphia", 35);

//            knowledgeSession.insert(rocky);
            final Message message = new Message();
            message.setMessage("Hello World");

            message.setStatus(Message.HELLO);

            Message2 message2 = new Message2();
            message2.setName("Initial Name");
//            knowledgeSession.insert(message);
//            knowledgeSession.insert(message2);
//
//            knowledgeSession.fireAllRules();
//
//            System.out.println("message " + message);
//            System.out.println("message2 " + message2);

            knowledgeSession.insert(searchServiceRequest);
            knowledgeSession.insert(searchServiceResponse);

            knowledgeSession.fireAllRules();
            System.out.println("req "+ searchServiceRequest);
            System.out.println("res "+ searchServiceResponse);
        } catch (Throwable tr) {
            tr.printStackTrace();
        } finally {
            knowledgeSession.dispose();
        }


//        System.exit(0);
    }

    public static class Message2 {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Message2{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }


    public static class Message {
        public static final int HELLO = 0;
        public static final int GOODBYE = 1;

        private String message;

        private int status;

        public Message() {

        }

        public String getMessage() {
            return this.message;
        }

        public void setMessage(final String message) {
            this.message = message;
        }

        public int getStatus() {
            return this.status;
        }

        public void setStatus(final int status) {
            this.status = status;
        }

        public static Message doSomething(Message message) {
            return message;
        }

        public boolean isSomething(String msg,
                                   List<Object> list) {
            list.add(this);
            return this.message.equals(msg);
        }

        @Override
        public String toString() {
            return "Message{" +
                    "message='" + message + '\'' +
                    ", status=" + status +
                    '}';
        }
    }
}
