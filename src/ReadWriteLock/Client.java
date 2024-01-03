package ReadWriteLock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Client {
    public static void main(String[] args) {
        ReadWriteLock rl = new ReentrantReadWriteLock();
        SharedResource s = new SharedResource(rl);

        Thread t1 = new Thread(() ->{
            s.addResource();
        });

        Thread t2 = new Thread(()->{
            try {
                s.addResource();
            }catch (Exception e){

            }
        });

        SharedResource s3 = new SharedResource(rl);


        Thread t3 = new Thread(()->{
            try {
                Thread.sleep(2000);
                s3.consumeResource();
            }catch (Exception e){

            }
        });

        t1.start();
        t2.start();
        t3.start();
    }
}
