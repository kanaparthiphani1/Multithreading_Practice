package ReentrantLock;

import java.util.concurrent.locks.ReentrantLock;

public class Client {
    public static void main(String[] args) {
        ReentrantLock rl = new ReentrantLock();
        SharedResource s = new SharedResource(rl);
        SharedResource s2 = new SharedResource(rl);

        Thread t1 = new Thread(() ->{
            s.addResource();
        });

        Thread t2 = new Thread(()->{
            try {
                s2.addResource();
            }catch (Exception e){

            }
        });

        t1.start();
        t2.start();
    }
}
