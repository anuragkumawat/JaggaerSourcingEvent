package com.doas.jaggaer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationProperties {

    @Value("${jaggaer.header.authentication.identity}")
    private String identity;
    
    @Value("${jaggaer.header.authentication.sharedsecret}")
    private String sharedSecret;

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getSharedSecret() {
        return sharedSecret;
    }

    public void setSharedSecret(String sharedSecret) {
        this.sharedSecret = sharedSecret;
    }
    
    
}
