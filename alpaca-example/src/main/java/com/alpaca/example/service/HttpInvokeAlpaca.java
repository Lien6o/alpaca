package com.alpaca.example.service;


import com.alpaca.annoatation.Alpaca;
import com.alpaca.example.annotation.Get;
import com.alpaca.example.proxy.AlpacaHttpProxy;

/**
 * @author Lien6o
 */
@Alpaca(invocationHandler = AlpacaHttpProxy.class)
public interface HttpInvokeAlpaca {

    @Get("http://www.baidu.com")
    String getBaidu();

    @Get("http://www.qq.com")
    String getTencent();
}
