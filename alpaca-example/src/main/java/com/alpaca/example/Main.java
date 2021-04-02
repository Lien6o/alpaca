package com.alpaca.example;

import com.alpaca.example.service.HttpExampleService;
import com.alpaca.example.service.HttpInvokeAlpaca;
import com.alpaca.example.service.SqlExampleService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Lien6o
 */
public class Main {
    /**
     * JUST TEST
     * <pre>
     * <p>@SpringBootApplication</p>
     * <p>@AlpacaScan("com.alpaca.example.service")</p>
     * <p>@ComponentScan("com.alpaca.example")</p>
     * <p>public class YouApplication {</p>
     * <p>    public static void main(String[] args) {</p>
     * <p>        SpringApplication.run(YouApplication.class, args);</p>
     * <p>    }</p>
     * <p>}</p>
     * </pre>
     */
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
        HttpExampleService httpExampleService = applicationContext.getBean(HttpExampleService.class);
        // expect http://www.baidu.com http://www.qq.com
        System.out.println(httpExampleService.httpInvoke());

        SqlExampleService sqlExampleService = applicationContext.getBean(SqlExampleService.class);
        // expect SELECT * FROM t_order limit 10
        System.out.println(sqlExampleService.invoke());
    }
}
