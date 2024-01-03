package StampLocks;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.StampedLock;

public class Client {
    public static void main(String[] args) {
        StampedLock rl = new StampedLock();
        SharedResource s = new SharedResource(rl);

        Thread t1 = new Thread(() ->{
            s.addResource();
        });

        Thread t2 = new Thread(()->{
            try {
                s.consumeResource();
            }catch (Exception e){

            }
        });

        t1.start();
        t2.start();
    }
}
