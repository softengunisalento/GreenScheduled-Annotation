package com.example.Tesi.myAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface GreenScheduled {

    String zone();
    String key();
    String value();
    String v3();
    int maxCarbonIntensity();

    long delay();

    // TODO:DATE-TIME FOR USE CASE INTENSITA CARBONIO PREVISTA



}
