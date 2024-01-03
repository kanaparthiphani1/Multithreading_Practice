package AdderSubtractorMutex;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Client {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Value v = new Value();
        Lock l = new ReentrantLock();
        Adder ad = new Adder(v,l);
        Subtractor sb = new Subtractor(v,l);

        ExecutorService es= Executors.newCachedThreadPool();

        es.submit(ad).get();
        es.submit(sb).get();

        System.out.println(v.x);

    }
}
