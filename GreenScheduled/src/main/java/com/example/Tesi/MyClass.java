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



















//@GreenScheduled(zone = "DE", key = "X-BLOBR-KEY", value = "q3NrnyFF6g2iFhPzvYS48GSw0o413EsG", v3 = "2w97h07rvxvuaa1g",maxCarbonIntensity = 100, delay = 10000)
//@GreenScheduled(zone = "DE", key = "X-BLOBR-KEY", value = "O7PUL0pY3tpw1ZeBJ71GkWzhae34TGqp", v3 = "tw0j3yl62nfpdjv4",maxCarbonIntensity = 100, delay = 10000)
