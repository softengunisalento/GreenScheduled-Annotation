package com.example.Tesi.strategy;

import com.example.Tesi.controller.Controller;
import com.example.Tesi.frame.CarbonIntensityFrame;
import com.example.Tesi.myAnnotation.GreenScheduled;
import com.example.Tesi.TesiApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.web.context.support.StandardServletEnvironment;

import javax.swing.*;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

public class SetStrategyImpl implements SetStrategy {
    private static final Logger LOGGER = LoggerFactory.getLogger(TesiApplication.class);

    @Override
    public void strategy() throws Exception {
        final List<Class<?>> result = new LinkedList<Class<?>>();
        final ClassPathScanningCandidateComponentProvider provider = new ClassPathScanningCandidateComponentProvider(
                true, new StandardServletEnvironment());
        provider.addIncludeFilter(new AnnotationTypeFilter(Configuration.class));
        for (BeanDefinition beanDefinition : provider
                .findCandidateComponents("com.example.Tesi")) {
            try {
                result.add(Class.forName(beanDefinition.getBeanClassName()));
            } catch (ClassNotFoundException e) {
                LOGGER.warn(
                        "Could not resolve class object for bean definition", e);
            }
        }
        Class<?>[] classes = result.toArray(new Class<?>[result.size()]);
        String carbonIntensityZone = "";
        String key = "";
        String value = "";
        String v3 = " ";
        int maxCarbonIntensity = 0;
        long delay = 0;
        for(int i = 0; i<classes.length;i++) {
            for (Method method : classes[i].getDeclaredMethods()) {
                if (method.isAnnotationPresent(GreenScheduled.class)) {
                    GreenScheduled carbonIntesity = method.getAnnotation(GreenScheduled.class);
                    carbonIntensityZone = carbonIntesity.zone();
                    key = carbonIntesity.key();
                    value = carbonIntesity.value();
                    maxCarbonIntensity = carbonIntesity.maxCarbonIntensity();
                    delay = carbonIntesity.delay();
                    v3 = carbonIntesity.v3();
                    boolean verify = false;
                    Controller controller = new Controller();
                    while (!verify) {
                        String check = controller.carbonIntensityLive(carbonIntensityZone, key, value, v3);
                        int lenght = check.length();
                        String check1 = check.substring(18, lenght);
                        int carbon = Integer.parseInt(check1);
                        if (carbon > maxCarbonIntensity) {
                            synchronized (this){
                                wait(delay);    //Alternativa a Thread.sleep
                            }
                        } else {
                            verify = true;
                            Object objects = classes[i].newInstance();
                            method.invoke(objects);
                            LOGGER.info("Metodo annotato eseguito con successo!");
                            CarbonIntensityFrame.initUI();
                        }
                    }
                }
            }
        }
    }
}