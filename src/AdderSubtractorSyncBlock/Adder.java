package AdderSubtractorSyncBlock;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;

public class Adder implements Callable<Void> {
    Value x;
    Adder(Value x){
        this.x = x;
    }

    @Override
    public Void call() throws Exception {
        for (int i = 0; i < 50000; i++) {
            synchronized (x){
                x.x = x.x+1;
            }

        }
        return null;
    }
}
