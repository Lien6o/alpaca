package com.alpaca.annoatation;

import com.alpaca.spring.AlpacaScannerRegistrar;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author Lien6o
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
@Import({AlpacaScannerRegistrar.class})
public @interface AlpacaScan {

    String value();
}
