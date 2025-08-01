package com.example.demo.bfpp;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.TypedStringValue;

import java.util.ArrayList;
import java.util.List;



public class EnabledBeanRegistry implements BeanFactoryPostProcessor{
    private List<String> enabledBeanNames = new ArrayList<>();

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        for (String name : beanFactory.getBeanDefinitionNames()) {
            var beanDef = beanFactory.getBeanDefinition(name);
            var props = beanDef.getPropertyValues();
            PropertyValue enabledProp = props.getPropertyValue("enabled");

            if (enabledProp != null) {
                Object value = enabledProp.getValue();
                if (value instanceof TypedStringValue typedStringValue) {
                    String actualValue = typedStringValue.getValue();
                    if ("true".equalsIgnoreCase(actualValue)) {
                        enabledBeanNames.add(name);
                    }
                } else if (value instanceof String str) {
                    if ("true".equalsIgnoreCase(str)) {
                        enabledBeanNames.add(name);
                    }
                }
            }
        }
    }
    public List<String> getEnabledBeanNames(){
        return enabledBeanNames;
    }
}
