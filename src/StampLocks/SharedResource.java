package StampLocks;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.StampedLock;

public class SharedResource {
    private int val = 10;
    StampedLock lock;
    SharedResource(StampedLock lock) {
        this.lock = lock;
    }

    public  void addResource() {
        try{
            long stamp = lock.tryOptimisticRead();
            val=11;
            System.out.println("OPtimistic Read Lock acqiured by thrad : "+Thread.currentThread().getName());
            Thread.sleep(6000);
            if(lock.validate(stamp)){
                System.out.println("Update success");
            }else{
                System.out.println("Rollback");
                val=10;
            }
        }catch (Exception e){

        }

    }

    public  void consumeResource() {
        long stamp = lock.writeLock();
        try{
            this.val = 19;
            System.out.println("Write Lock acqiured by thrad : "+Thread.currentThread().getName());
        }catch (Exception e){

        }
        finally {
            System.out.println("Write Lock released : "+ Thread.currentThread().getName());
            lock.unlockWrite(stamp);
        }
    }


}
