package com.example.Tesi;

import com.example.Tesi.myAnnotation.GreenScheduled;
import org.springframework.stereotype.Component;
@Component
public class MyClass{
    @GreenScheduled(zone = "DE",
            key = "",
            value = "",
            v3 = "",
            maxCarbonIntensity = 900,
            delay = 10000)
    public synchronized void myMethod(){
        System.out.println("myMethod action");
    }
}
