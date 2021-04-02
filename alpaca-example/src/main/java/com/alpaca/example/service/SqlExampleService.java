package com.alpaca.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Lien6o
 */
@Component
public class SqlExampleService {
    @Autowired
    private SqlInvokeAlpaca sqlInvokeAlpaca;

    public String invoke() {
        return sqlInvokeAlpaca.getOrder();
    }
}
