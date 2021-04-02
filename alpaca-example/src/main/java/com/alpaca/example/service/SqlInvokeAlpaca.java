package com.alpaca.example.service;


import com.alpaca.annoatation.Alpaca;
import com.alpaca.example.annotation.Get;
import com.alpaca.example.annotation.Sql;
import com.alpaca.example.proxy.AlpacaHttpProxy;
import com.alpaca.example.proxy.AlpacaSqlProxy;

/**
 * @author Lien6o
 */
@Alpaca(invocationHandler = AlpacaSqlProxy.class)
public interface SqlInvokeAlpaca {

    @Sql("SELECT * FROM t_order limit 10 ")
    String getOrder();
}
