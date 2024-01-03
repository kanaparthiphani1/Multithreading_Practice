package AdderSubtractor;

import java.util.concurrent.Callable;

public class Subtractor implements Callable<Void> {
    Value x;
    Subtractor(Value x){
        this.x = x;
    }

    @Override
    public Void call() throws Exception {
        for (int i = 0; i < 50000; i++) {
            if(i==100){
                System.out.println("JI");
            }
            x.x = x.x-1;
        }
        return null;
    }
}
