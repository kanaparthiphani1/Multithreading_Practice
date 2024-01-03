package NumberPrinter;

public class Printer implements Runnable{
    int num;

    Printer(int num){
        this.num=num;
    }
    @Override
    public void run() {
        System.out.println("Thread : " + Thread.currentThread().getName() + ", Value  : "+num);
    }
}
