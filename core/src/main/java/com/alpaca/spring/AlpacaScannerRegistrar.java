package com.alpaca.spring;

import com.alpaca.annoatation.Alpaca;
import com.alpaca.annoatation.AlpacaScan;
import com.alpaca.util.ScannerProviderUtil;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.filter.AnnotationTypeFilter;

import java.lang.reflect.InvocationHandler;
import java.util.Objects;
import java.util.Set;

/**
 * @author Lien6o
 */
public class AlpacaScannerRegistrar implements ImportBeanDefinitionRegistrar {

    /**
     * 注册BeanDefinitions
     * <p>
     * 自定义扫描功能
     * 一般情况下，我们要自定义扫描功能的话，可以直接使用ClassPathScanningCandidateComponentProvider完成，加上一些自定义的TypeFilter即可。
     * 或者写个自定义扫描器继承ClassPathScanningCandidateComponentProvider，并在内部添加自定义的TypeFilter。后者相当于对前者的封装。
     *
     * @param annotationMetadata annotationMetadata
     * @param registry               registry
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry registry) {
        AnnotationAttributes annotation = AnnotationAttributes.fromMap(annotationMetadata.getAnnotationAttributes(AlpacaScan.class.getName()));
        if (annotation == null) {
            return;
        }
        Set<BeanDefinition> beanDefinitionSet = ScannerProviderUtil.scanBeanDefinitionSet(annotation.getString("value"), new AnnotationTypeFilter(Alpaca.class));
        for (BeanDefinition beanDefinition : beanDefinitionSet) {
            if (beanDefinition instanceof AnnotatedBeanDefinition) {
                doRegister((AnnotatedBeanDefinition) beanDefinition, registry);
            }
        }
    }

    /**
     * 放置到spring BeanDefinitionMap
     */
    private void doRegister(AnnotatedBeanDefinition annotatedBeanDefinition, BeanDefinitionRegistry registry) {
        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition(AlpacaFactoryBean.class).getBeanDefinition();
        AnnotationMetadata metadata = annotatedBeanDefinition.getMetadata();
        Class<? extends InvocationHandler> invokeHandler = Objects.requireNonNull(AnnotationAttributes.fromMap(metadata.getAnnotationAttributes(Alpaca.class.getName()))).getClass("invocationHandler");
        String beanClassName = metadata.getClassName();
        beanDefinition.getPropertyValues().add("targetClass", beanClassName).add("invocationHandler", invokeHandler);
        String beanName = beanClassName + "$ByAlpaca";
        registry.registerBeanDefinition(beanName, beanDefinition);
    }
}
