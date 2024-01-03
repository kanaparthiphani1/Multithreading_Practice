package ProducerConsumerSemaphores;

import java.util.concurrent.Semaphore;

public class Client {
    public static void main(String[] args) {
        Semaphore prodSema = new Semaphore(3);
        Semaphore conSema = new Semaphore(0);
        SharedResource s = new SharedResource(3);

        Thread t1 = new Thread(() ->{

            try{
                Thread.sleep(2000);
            }catch (Exception e){

            }
            for (int i = 0; i < 6; i++) {
                try {
                    prodSema.acquire();
                    s.addResource();
                    conSema.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

        Thread t2 = new Thread(()->{
            for (int i = 0; i < 6; i++) {
                try {
                    conSema.acquire();
                    s.consumeResource();
                    prodSema.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
    }
}
