package ReentrantLock;

import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {
    boolean isAvailable = false;
    ReentrantLock lock;
    SharedResource(ReentrantLock lock) {
        this.lock = lock;
    }

    public  void addResource() {
        try{
            lock.lock();
            System.out.println("Lock acqiured by thrad : "+Thread.currentThread().getName());
            isAvailable=true;
            Thread.sleep(5000);
        }catch (Exception e){

        }
        finally {
            System.out.println("Lock released : "+ Thread.currentThread().getName());
            lock.unlock();
        }
    }


}
