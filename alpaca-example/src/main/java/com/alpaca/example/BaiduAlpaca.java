package com.alpaca.example;

import com.alpaca.annoatation.Alpaca;
import com.alpaca.annoatation.Get;
import com.alpaca.proxy.AlpacaProxy;

/**
 * @author Lien6o
 */
@Alpaca(invocationHandler = AlpacaProxy.class)
public interface BaiduAlpaca {

    @Get("http://www.baidu.com")
    String getBaidu();
}
