package NumberPrinter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {
    public static void main(String[] args) {
        ExecutorService ex = Executors.newFixedThreadPool(3);
        for (int i = 1; i < 101; i++) {
            Printer pr = new Printer(i);
//            Thread t = new Thread(pr);
            ex.execute(pr);
        }
    }
}
