package com.alpaca.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Lien6o
 */
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
        BaiduAlpaca bean = applicationContext.getBean(BaiduAlpaca.class);
        System.out.println(bean.getBaidu());
    }
}
