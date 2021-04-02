package com.alpaca.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Lien6o
 */
@Component
public class HttpExampleService {

    @Autowired
    private HttpInvokeAlpaca httpInvokeAlpaca;

    public String httpInvoke() {
        return httpInvokeAlpaca.getBaidu() + " " + httpInvokeAlpaca.getTencent();
    }
}
