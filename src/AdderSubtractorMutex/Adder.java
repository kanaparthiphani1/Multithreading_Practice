package AdderSubtractorMutex;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;

public class Adder implements Callable<Void> {
    Value x;
    Lock l;
    Adder(Value x, Lock l){
        this.x = x;
        this.l = l;
    }

    @Override
    public Void call() throws Exception {
        for (int i = 0; i < 50000; i++) {
            l.lock();
            x.x = x.x+1;
            l.unlock();

        }
        return null;
    }
}
