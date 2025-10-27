package com.joffre.sec01;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class InboundOutboundTaskDemo {
    private static final int MAX_PLATFORM_THREADS = 10;
    private static final int MAX_PLATFORM = 10_000;
    private static final int MAX_VIRTUAL = 20;
    public static void main(String[] args) throws InterruptedException {
       // platformThreadDemo1();
       // platformThreadDemo2();
      //  platformThreadDemo3();
      //  virtualThreadDemo();
        platformThreadDemo();
    }

    private static void platformThreadDemo(){

        List<Thread> classicThreads = new ArrayList<>();
        List<Thread> platformThreads = new ArrayList<>();
        for (int i = 0; i < MAX_PLATFORM_THREADS; i++){
          int j = i;
          //Crear y arrancar hilos clásicos
            Thread thread = new Thread(() -> TaskJoffre.ioIntensive(j));
            thread.start();
            classicThreads.add(thread);
          //Crear y arramcar un thread de plataforma
          Thread platformThread = Thread.ofPlatform().unstarted(() -> TaskJoffre.ioIntensive(j));
            platformThread.start();
            platformThreads.add(platformThread);
        }
        //Esperar a que terminen los hilos clásicos
        for(Thread t:classicThreads){
            try{
                t.join();
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
        }
        //Esperar a que terminen los hilos de plataforma
      for (Thread t:platformThreads){
          try{
              t.join();
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
      }
    }


    private static void platformThreadDemo1(){
        for (int i = 0; i < MAX_PLATFORM; i++) {
            int j = i;
            Thread thread = new Thread(() -> Task.ioIntensive(j));
            thread.start();
        }
    }

    private static void platformThreadDemo2(){
        var builder = Thread.ofPlatform().name("joffre: ", 1);
        for (int i = 0; i < MAX_PLATFORM; i++) {
            int j = i;
            Thread thread = builder.unstarted(() -> Task.ioIntensive(j));
            thread.start();
        }
    }
    private static void platformThreadDemo3Joffre() throws InterruptedException {
        var latch = new java.util.concurrent.CountDownLatch(MAX_PLATFORM);
        var builder = Thread.ofPlatform().daemon().name("daemon", 1);
        for (int i = 0; i < MAX_PLATFORM; i++) {
            int j = i;
            Thread thread = builder.unstarted(() -> {
                TaskJoffre.ioIntensive(j);
                latch.countDown();
            });
            thread.start();
        }
        latch.await();
    }

    private static void platformThreadDemo3() throws InterruptedException {
        var latch = new java.util.concurrent.CountDownLatch(MAX_PLATFORM);
        var builder = Thread.ofPlatform().daemon().name("daemon", 1);
        for (int i = 0; i < MAX_PLATFORM; i++) {
            int j = i;
            Thread thread = builder.unstarted(() -> {
                Task.ioIntensive(j);
                latch.countDown();
            });
            thread.start();
    }
        latch.await();
}

private static void virtualThreadDemo() throws InterruptedException {
        var latch = new CountDownLatch(MAX_PLATFORM);
        var builder = Thread.ofVirtual().name("virtual", 1);
        for(int i = 0; i< MAX_VIRTUAL; i++){
            int j = i;
            Thread thread = builder.unstarted(() -> {
                Task.ioIntensive(j);
                latch.countDown();
            });
            thread.start();
        }
            latch.await();


    }



}