package com.alpaca.util;

import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.filter.AnnotationTypeFilter;

import java.util.Set;

/**
 * @author Lien6o
 */
public class ScannerProviderUtil {

    /**
     * only scan for interface
     */
    public static Set<BeanDefinition> scanBeanDefinitionSet(String basePackage, AnnotationTypeFilter... filter) {
        ClassPathScanningCandidateComponentProvider provider = new ClassPathScanningCandidateComponentProvider(false) {
            // Override isCandidateComponent to only scan for interface
            @Override
            protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
                AnnotationMetadata metadata = beanDefinition.getMetadata();
                return metadata.isIndependent() && metadata.isInterface();
            }
        };
        for (AnnotationTypeFilter typeFilter : filter) {
            provider.addIncludeFilter(typeFilter);
        }
        return provider.findCandidateComponents(basePackage);
    }
}
