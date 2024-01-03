package AdderSubtractorSyncBlock;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Client {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Value v = new Value();
        Adder ad = new Adder(v);
        Subtractor sb = new Subtractor(v);

        ExecutorService es= Executors.newCachedThreadPool();

        es.submit(ad).get();
        es.submit(sb).get();

        System.out.println(v.x);

    }
}
