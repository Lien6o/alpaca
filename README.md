# Alpaca

Alpaca 项目实现了代理注入Spring的工作。在使用时像mybatis-spring一样注入mapper接口即可完成。

具体代理增强可由使用方自由扩展实现，比如完成类似HTTP,SQL等操作。

## 原理
相关spring 知识点
* @Import 
* ImportBeanDefinitionRegistrar
* FactoryBean
* ClassPathScanningCandidateComponentProvider

动态代理
Alpaca 目前仅支持 JDK动态代理。丰俭由人。

## 使用方法

具体使用场景可以查看alpaca-example 项目给出的HTTP , SQL demo。

* spring-config
```java
    @SpringBootApplication
    @AlpacaScan("com.alpaca.example.service")
    @ComponentScan("com.alpaca.example")
    public class YouApplication {
        public static void main(String[] args) {
            SpringApplication.run(YouApplication.class, args);
        }
    }
```
```java
    @AlpacaScan("com.alpaca.example.service")
    @ComponentScan("com.alpaca.example")
    @Configuration
    public class Config {
    }
```
* proxy-invocation-handler
```java
    public class AlpacaHttpProxy implements InvocationHandler {
    
        @Override
        public Object invoke(Object target, Method method, Object[] args) throws Throwable {
            // you can do anything hei hei hei! so this is a extent point
            // eg. 
            Get annotation = method.getAnnotation(Get.class);
            return annotation.value();
        }
    }
```

* mapper
```java
    @Alpaca(invocationHandler = AlpacaHttpProxy.class)
    public interface HttpInvokeAlpaca {
    
        @Get("http://www.baidu.com")
        String getBaidu();
    
        @Get("http://www.qq.com")
        String getTencent();
    }
```

* using
```java
    @Component
    public class HttpExampleService {
    
        @Autowired
        private HttpInvokeAlpaca httpInvokeAlpaca;
    
        public String httpInvoke() {
            return httpInvokeAlpaca.getBaidu() + " " + httpInvokeAlpaca.getTencent();
        }
    }
```

## 使用场景

Alpaca 核心实现了代理和Spring融合的工作，针对使用场景从设计模式上看还是代理模式的使用。

* case 

调用第三方接口，需要使用HTTP请求，其中使用HTTP-client/OKHttp 发起请求、签名、日志、重试、返回值判断等情况，均可以使用动态代理增强统一实现。
  


 
