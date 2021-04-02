package com.alpaca.example;

import com.alpaca.annoatation.AlpacaScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Lien6o
 */
@AlpacaScan("com.alpaca.example.service")
@ComponentScan("com.alpaca.example")
@Configuration
public class Config {

}
