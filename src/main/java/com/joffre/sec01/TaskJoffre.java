package com.joffre.sec01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TaskJoffre {


    private static final Logger log = LoggerFactory.getLogger(TaskJoffre.class);

    public static void ioIntensive(){
  System.out.println("Starting ioIntensive");
  try{
         Thread.sleep(500);
    }catch (InterruptedException e){
      e.printStackTrace();
  }
    System.out.println("Ending ioIntensive");
    }

  public static void ioIntensive(int i){
    log.info("Starting ioIntensiveJoffre {}", i);
    System.out.println("starting ioIntensiveJoffre " + i);
    try{
         Thread.sleep(500);
    }catch (InterruptedException e){
      e.printStackTrace();
  }
    log.info("Ending ioIntensiveJoffre {}", i);
    System.out.println("ending ioIntensiveJoffre " + i);
    }


}
