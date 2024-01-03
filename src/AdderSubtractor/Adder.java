package AdderSubtractor;

import java.util.concurrent.Callable;

public class Adder implements Callable<Void> {
    Value x;
    Adder(Value x){
        this.x = x;
    }

    @Override
    public Void call() throws Exception {
        for (int i = 0; i < 50000; i++) {
            x.x = x.x+1;
        }
        return null;
    }
}
