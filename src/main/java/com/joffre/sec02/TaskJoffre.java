package com.joffre.sec02;


import com.joffre.util.CommonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class TaskJoffre {
    private static final Logger log = LoggerFactory.getLogger(TaskJoffre.class);

    public static String execute(int i){
        StringBuilder resultado = new StringBuilder();
        resultado.append("starting joffre task").append(i).append("\n");
        log.info("starting Task Joffre{}",i);
        try{
           resultado.append(method1(i));
        }catch (Exception e){
            log.error("Error in Task Joffre{}", e.getMessage());
            resultado.append("error for ").append(i).append(":").append(e.getMessage()).append("\n");
        }
        resultado.append("ending joffre task").append(i).append("\n");
        log.info("ending Task Joffre{}",i);
        return resultado.toString();
    }

    private static String method1(int i) {
        StringBuilder resultado = new StringBuilder();
        CommonUtils.sleep(Duration.ofMillis(300));
        try{
         resultado.append(method2(i));
        }catch (Exception e){
            throw new RuntimeException(e);


        }
        return resultado.toString();
    }

    private static String method2(int i) {
       StringBuilder resultado = new StringBuilder();
       CommonUtils.sleep(Duration.ofMillis(100));
       resultado.append(method3(i));
       return resultado.toString();
    }

    private static String method3(int i){
        StringBuilder resultado = new StringBuilder();
        CommonUtils.sleep(Duration.ofMillis(500));
        if(i==4){
            throw new IllegalArgumentException(" I can not be 4");

        }
        return resultado.toString();
    }






}
