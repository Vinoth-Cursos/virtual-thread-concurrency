package com.joffre.sec01;

import jakarta.enterprise.context.ApplicationScoped;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
public class TaskJoffreService {

    private static final Logger log = LoggerFactory.getLogger(TaskJoffreService.class);

    public void ioIntesive(){
        log.info("Starting ioIntensiveJoffreService");
        System.out.println("starting ioIntensiveJoffreService");
        try{
            Thread.sleep(500);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        log.info("Ending ioIntensiveJoffreService");
        System.out.println("ending ioIntensiveJoffreService");

    }

    public String ioIntensive(int i){
        StringBuilder resultado = new StringBuilder();
        Thread thread = new Thread(() -> {
            log.info("Starting ioIntensiveJoffreService {}", i, Thread.currentThread().getName());
            resultado.append("starting ioIntensiveJoffreService ").append(i).append("en ")
                    .append(Thread.currentThread().getName()).append("\n");
            try{
                Thread.sleep(10000);
            }catch (InterruptedException e){
                resultado.append("Error in ioIntensiveJoffreService ").append(i).append(e.getMessage()).append("\n");
                e.printStackTrace();
            }
            log.info("Ending ioIntensiveJoffreService {}", i);
            resultado.append("ending ioIntensiveJoffreService ").append(i).append("\n");
        }, "TaskJoffreService-Thread-" + i);
        thread.start();
        try{
            thread.join();
        } catch (InterruptedException e) {
           resultado.append("Error inesperado hilo: ").append(e.getMessage()).append("\n");
    }

return resultado.toString();

}

public String ioIntensiveConResultado(){
        StringBuilder resultado = new StringBuilder();
        int numTrheads = 50000;
        Thread[] threads = new Thread[numTrheads];
        for(int i = 0; i<numTrheads;i++){
            final int idx = i;
            resultadosParciales[i] = new StringBuilder();
            threads[i] = new Thread(() -> {
                log.info("Starting ioIntensiveJoffreService {}", idx, Thread.currentThread().getName());
                resultadosParciales[idx].append("starting ioIntensiveJoffreService ").append(idx).append("en ")
                        .append(Thread.currentThread().getName()).append("\n");
                try{
                    Thread.sleep(500);
                }catch (InterruptedException e){
                    resultadosParciales[idx].append("Error in ioIntensiveJoffreService ").append(idx).append(e.getMessage()).append("\n");
                    e.printStackTrace();
                }
                log.info("Ending ioIntensiveJoffreService {}", idx, Thread.currentThread().getName());
                resultadosParciales[idx].append("ending ioIntensiveJoffreService ").append(idx)
                        .append("en ").append(Thread.currentThread().getName())
                        .append("\n");
            }, "TaskJoffreService-Thread-" + idx);
            threads[i].start();
        }

// Esperar a que terminen todos los hilos
        for(int i = 0; i<numTrheads;i++){
            try{
                threads[i].join();
            } catch (InterruptedException e) {
                resultado.append("Error inesperado hilo: ").append(e.getMessage()).append("\n");
            }
        }
   //   Acumular todos los resultados
        for(int i = 0; i<numTrheads;i++){
            resultado.append(resultadosParciales[i].toString());
        }
        return resultado.toString();
    }

    public String ioIntensiveConResultado(int id){
        StringBuilder resultado = new StringBuilder();
        Thread thread = new Thread(() -> {
            log.info("Starting ioIntensiveJoffreService {}", id, Thread.currentThread().getName());
            resultado.append("starting ioIntensiveJoffreService ").append(id).append("en ")
                    .append(Thread.currentThread().getName()).append("\n");
            try{
                Thread.sleep(500);
            }catch (InterruptedException e){
                resultado.append("Error in ioIntensiveJoffreService ").append(id).append(e.getMessage()).append("\n");
                e.printStackTrace();
            }
            log.info("Ending ioIntensiveJoffreService {}", id, Thread.currentThread().getName());
            resultado.append("ending ioIntensiveJoffreService ").append(id).append("\n");
        }, "TaskJoffreService-Thread-" + id);

thread.start();
        try{
            thread.join();
        } catch (InterruptedException e) {
            resultado.append("Error inesperado hilo: ").append(e.getMessage()).append("\n");
        }
        return resultado.toString();
    }



    public String platfomrThrea
}