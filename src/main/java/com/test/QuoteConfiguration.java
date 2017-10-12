package com.test;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.soap.security.support.KeyStoreFactoryBean;
import org.springframework.ws.soap.security.support.TrustManagersFactoryBean;
import org.springframework.ws.transport.http.HttpsUrlConnectionMessageSender;

import javax.net.ssl.HostnameVerifier;

//@Configuration
public class QuoteConfiguration {

//    @Value("${client.ssl.trust-store}")
//    private Resource trustStore;
//
//    @Value("${client.ssl.trust-store-password}")
//    private String trustStorePassword;
//
//    @Bean
//    public Jaxb2Marshaller marshaller() {
//        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
//        // this package must match the package in the <generatePackage> specified in
//        // pom.xml
//        marshaller.setContextPath("order.wsdl");
//        return marshaller;
//    }
//
//    @Bean
//    public WebCall webCall(Jaxb2Marshaller marshaller) throws Exception {
//        WebCall client = new WebCall();
//        client.setDefaultUri("http://www.webservicex.com/stockquote.asmx");
//        client.setMarshaller(marshaller);
//        client.setUnmarshaller(marshaller);
//        client.setMessageSender(httpsUrlConnectionMessageSender());
//        return client;
//    }
//
//    @Bean
//    public HttpsUrlConnectionMessageSender httpsUrlConnectionMessageSender() throws Exception {
//        HttpsUrlConnectionMessageSender httpsUrlConnectionMessageSender =
//                new HttpsUrlConnectionMessageSender();
//        httpsUrlConnectionMessageSender.setTrustManagers(trustManagersFactoryBean().getObject());
//        // allows the client to skip host name verification as otherwise following error is thrown:
//        // java.security.cert.CertificateException: No name matching localhost found
//        httpsUrlConnectionMessageSender.setHostnameVerifier(new HostnameVerifier() {
//            @Override
//            public boolean verify(String hostname, javax.net.ssl.SSLSession sslSession) {
//                if ("localhost".equals(hostname)) {
//                    return true;
//                }
//                return false;
//            }
//        });
//
//        return httpsUrlConnectionMessageSender;
//    }
//
//    @Bean
//    public KeyStoreFactoryBean trustStore() {
//        KeyStoreFactoryBean keyStoreFactoryBean = new KeyStoreFactoryBean();
//        keyStoreFactoryBean.setLocation(trustStore);
//        keyStoreFactoryBean.setPassword(trustStorePassword);
//
//        return keyStoreFactoryBean;
//    }
//
//    @Bean
//    public TrustManagersFactoryBean trustManagersFactoryBean() {
//        TrustManagersFactoryBean trustManagersFactoryBean = new TrustManagersFactoryBean();
//        trustManagersFactoryBean.setKeyStore(trustStore().getObject());
//
//        return trustManagersFactoryBean;
//    }

}