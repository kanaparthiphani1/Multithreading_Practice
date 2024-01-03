package ReadWriteLock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {
    boolean isAvailable = false;
    ReadWriteLock lock;
    SharedResource(ReadWriteLock lock) {
        this.lock = lock;
    }

    public  void addResource() {
        try{
            lock.readLock().lock();
            System.out.println("Read Lock acqiured by thrad : "+Thread.currentThread().getName());
            Thread.sleep(6000);
        }catch (Exception e){

        }
        finally {
            System.out.println("Read Lock released : "+ Thread.currentThread().getName());
            lock.readLock().unlock();
        }
    }

    public  void consumeResource() {
        try{
            lock.writeLock().lock();
            System.out.println("Write Lock acqiured by thrad : "+Thread.currentThread().getName());
        }catch (Exception e){

        }
        finally {
            System.out.println("Write Lock released : "+ Thread.currentThread().getName());
            lock.writeLock().unlock();
        }
    }


}
